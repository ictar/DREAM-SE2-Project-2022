package in.dream.ejb.services;

import in.dream.ejb.external.Soil;
import org.junit.jupiter.api.Test;

import javax.ejb.EJB;

import static org.junit.jupiter.api.Assertions.*;

class GeospatialDataServiceTest {
    @EJB(name = "in.dream.ejb.services/GeospatialDataService")
    private GeospatialDataService geoService;

    @Test
    void getSoil() {
        Long areaId = 1L;
        Soil soil = geoService.getSoil(areaId);
        System.out.print(soil.getFertility());
    }

    @Test
    void getWeather() {
    }
}