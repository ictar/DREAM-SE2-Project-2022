package in.dream.ejb.models;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name="Policymaker.checkCredentials", query="SELECT p from Policymaker p WHERE p.email=?1 and p.password=?2"),
        @NamedQuery(name="Policymaker.checkDuplicateEmail", query="SELECT f from Farmer f where f.phonenumber=?1")
})
public class Policymaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policymakerid;

    public Long getPolicymakerid() {
        return policymakerid;
    }

    public void setPolicymakerid(Long policymakerid) {
        this.policymakerid = policymakerid;
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
}
