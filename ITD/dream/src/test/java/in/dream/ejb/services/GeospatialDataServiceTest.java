package in.dream.ejb.services;

import in.dream.ejb.external.Soil;
import in.dream.ejb.models.Dailyplan;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class GeospatialDataServiceTest {


    @Test
    void getSoil() {
        try {
            EntityManager em = Mockito.mock(EntityManager.class);
            List<Dailyplan> customResults = new ArrayList<Dailyplan>();
            TypedQuery<Dailyplan> qu = Mockito.mock(TypedQuery.class);


            Mockito.when(em.createNamedQuery("Dailyplan.findByAgronomist", Dailyplan.class)).thenReturn(qu);
            Mockito.when(qu.setParameter(any(Integer.class), any(Object.class))).thenReturn(qu);
            Mockito.when(qu.getResultList()).thenReturn(customResults);
            Mockito.when(qu.getSingleResult()).thenReturn(new Dailyplan());

            GeospatialDataService ds = new  GeospatialDataService();
            ds.em = em;

            List<Long> fs = new ArrayList<>();
            fs.add(1l);
            Soil d = ds.getSoil(  1l);
            assertNotNull(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getWeather() {
    }
}