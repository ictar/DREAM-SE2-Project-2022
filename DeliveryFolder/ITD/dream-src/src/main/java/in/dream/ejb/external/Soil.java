package in.dream.ejb.external;

public class Soil {
    private float temperature;
    private float moisture;
    private Fertility fertility;

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }


    public float getMoisture() {
        return moisture;
    }

    public void setMoisture(float moisture) {
        this.moisture = moisture;
    }

    public Fertility getFertility() {
        return fertility;
    }

    public void setFertility(Fertility fertility) {
        this.fertility = fertility;
    }
}
