package in.dream.ejb.external;

import com.google.gson.annotations.SerializedName;

public class Fertility {
    @SerializedName("pH")
    private float ph;
    @SerializedName("ElectricalConductivity")
    private float electricalConductivity;
    @SerializedName("OrganicCarbon")
    private float organicCarbon;
    @SerializedName("Nitrogen")
    private float nitrogen;


    public float getPh() {
        return ph;
    }

    public void setPh(float ph) {
        this.ph = ph;
    }


    public float getNitrogen() {
        return nitrogen;
    }

    public void setNitrogen(float nitrogen) {
        this.nitrogen = nitrogen;
    }

    public float getElectricalConductivity() {
        return electricalConductivity;
    }

    public void setElectricalConductivity(float electricalConductivity) {
        this.electricalConductivity = electricalConductivity;
    }

    public float getOrganicCarbon() {
        return organicCarbon;
    }

    public void setOrganicCarbon(float organicCarbon) {
        this.organicCarbon = organicCarbon;
    }
}
