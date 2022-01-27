package in.dream.ejb.services;

import in.dream.ejb.models.Area;
import org.apache.commons.codec.Charsets;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Startup
@Singleton
public class GeospatialDataService {
    @PersistenceContext(unitName = "DREAMEJB")
    protected EntityManager em;

    private Map<Long, Area> areas;
    private String weatherurl, irrigationurl, producturl, soilurl;
    private HttpClient httpCli;

    @PostConstruct
    public void initialize() {
        try {
            // load all area information
            List<Area> alist = em.createNamedQuery("Area.findAll", Area.class).getResultList();

            areas = new HashMap<>();
            for (Area a: alist) {
                areas.put(a.getAreaid(), a);
            }

            // load configuration
            System.out.println("Begin to load configuration");
            InputStream in = this.getClass().getResourceAsStream("/dream.properties");
            Properties props = new Properties();
            props.load(in);
            irrigationurl = props.getProperty("irrigation_service");
            producturl = props.getProperty("product_service");
            weatherurl = props.getProperty("weather_service");
            soilurl = props.getProperty("soil_service");

            // initial http client
            httpCli = HttpClientBuilder.create().build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSoil(Long areaID) {
        try {
            HttpGet req = new HttpGet(soilurl+"/"+this.getArea(areaID).getName());
            HttpResponse resp = httpCli.execute(req);
            if(resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(resp.getEntity(), Charsets.UTF_8);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getWeather(Long areaID) {
        try {
            HttpGet req = new HttpGet(weatherurl+"/"+this.getArea(areaID).getName());
            HttpResponse resp = httpCli.execute(req);
            if(resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(resp.getEntity(), Charsets.UTF_8);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    // TODO
    public String getWeatherByLocation(String location) {
        return "TODO";
    }

    public String getWaterIrrigation(Long areaID) {
        try {
            HttpGet req = new HttpGet(irrigationurl+"/"+this.getArea(areaID).getName());
            HttpResponse resp = httpCli.execute(req);
            if(resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(resp.getEntity(), Charsets.UTF_8);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getTypeInfo(String productType){
        try {
            HttpGet req = new HttpGet(producturl + "/info/" + productType);
            HttpResponse resp = httpCli.execute(req);
            if(resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(resp.getEntity(), Charsets.UTF_8);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public List<String> getTypeList(){
        List<String> result = new ArrayList<>();
        try {
            HttpGet req = new HttpGet(producturl+"/types");
            HttpResponse resp = httpCli.execute(req);
            if(resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                JSONObject json = new JSONObject(EntityUtils.toString(resp.getEntity(), Charsets.UTF_8));
                List<Object> types = json.getJSONArray("types").toList();
                // convert object to string
                for (Object o: types) {
                    result.add(o.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<Area> getAreaList() {
        return new ArrayList<Area>(areas.values());
    }

    public Area getArea(Long areaID) {
        return areas.get(areaID);
    }

}
