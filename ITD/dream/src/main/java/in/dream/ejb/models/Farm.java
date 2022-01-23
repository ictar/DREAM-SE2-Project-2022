package in.dream.ejb.models;

import javax.persistence.*;

@Entity
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

    private String location;

    @Basic
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private float acreage;

    @Basic
    public float getAcreage() {
        return acreage;
    }

    public void setAcreage(float acreage) {
        this.acreage = acreage;
    }

    @OneToOne
    private Farmer farmer;


    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    @ManyToOne
    private Area area;

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
