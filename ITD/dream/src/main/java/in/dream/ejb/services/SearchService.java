package in.dream.ejb.services;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class SearchService {
    @PersistenceContext(unitName = "DREAMEJB")
    protected EntityManager em;

    @Inject
    private GeospatialDataService geoService;

    public Map<String, Object> search(Long areaId, String productType) {
        Map<String, Object> result = new HashMap<>();

        result.put("weather", geoService.getWeather(areaId));
        if(productType != null && !productType.isEmpty()) {
            result.put("suggestion", geoService.getTypeInfo(productType));
        }
        return result;
    }
}
