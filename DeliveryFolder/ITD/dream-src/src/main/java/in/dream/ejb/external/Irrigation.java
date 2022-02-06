package in.dream.ejb.external;

import java.util.Date;

public class Irrigation {
    private float consumption;
    private Date date;

    public float getConsumption() {
        return consumption;
    }

    public void setConsumption(float consumption) {
        this.consumption = consumption;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
