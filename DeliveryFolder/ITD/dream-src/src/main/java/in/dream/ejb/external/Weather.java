package in.dream.ejb.external;

import java.util.Map;

public class Weather {
    private Map<String, Rainfall> rainfall;

    public Map<String, Rainfall> getRainfall() {
        return rainfall;
    }

    public void setRainfall(Map<String, Rainfall> rainfall) {
        this.rainfall = rainfall;
    }
}
