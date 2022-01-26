package in.dream.ejb.models;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name="Area.findAll", query="SELECT a from Area a")
})
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long areaid;

    public Long getAreaid() {
        return areaid;
    }

    public void setAreaid(Long areaid) {
        this.areaid = areaid;
    }

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
