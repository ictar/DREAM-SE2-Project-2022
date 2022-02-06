package in.dream.ejb.models;

import javax.persistence.*;

@Entity
@NamedQuery(name="Farm.findByFarmer", query = "SELECT f from Farm f where f.farmer=?1")
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farmid;

    public Long getFarmid() {
        return farmid;
    }

    public void setFarmid(Long farmid) {
        this.farmid = farmid;
    }


    private float acreage;

    @Basic
    public float getAcreage() {
        return acreage;
    }

    public void setAcreage(float acreage) {
        this.acreage = acreage;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="area")
    private Area area;

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    private String farmer;

    public String getFarmer() {
        return farmer;
    }
}
