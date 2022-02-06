package in.dream.ejb.models;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name="Agronomist.checkCredentials", query="SELECT a from Agronomist a WHERE a.email=?1 and a.password=?2"),
        @NamedQuery(name="Agronomist.findAll", query="SELECT a from Agronomist a"),
        @NamedQuery(name="Agronomist.findOne", query="SELECT a from Agronomist a where a.agronomistid=?1"),
        @NamedQuery(name="Agronomist.checkDuplicateEmail", query="SELECT a from Agronomist a where a.email=?1")
})
public class Agronomist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agronomistid;

    public Long getAgronomistid() {
        return agronomistid;
    }

    public void setAgronomistid(Long agronomistid) {
        this.agronomistid = agronomistid;
    }

    private String name;

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String email;

    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String password;

    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="area")
    private Area area;

    public Area getArea() {return area;}
    public void setArea(Area area) {this.area = area;}
}
