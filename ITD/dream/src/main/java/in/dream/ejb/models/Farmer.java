package in.dream.ejb.models;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name="Farmer.checkCredentials", query="SELECT f from Farmer f WHERE f.phonenumber=?1 and f.password=?2"),
        @NamedQuery(name="Farmer.findOne", query="SELECT f from Farmer f where f.farmerid=?1"),
        @NamedQuery(name="Farmer.checkDuplicatePhoneNumber", query="SELECT f from Farmer f where f.phonenumber=?1")
})
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farmerid;

    public Long getFarmerid() {
        return farmerid;
    }

    public void setFarmerid(Long farmerid) {
        this.farmerid = farmerid;
    }

    private String name;

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String phonenumber;

    @Basic
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    private String password;

    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private int performance;

    @Basic
    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }
}
