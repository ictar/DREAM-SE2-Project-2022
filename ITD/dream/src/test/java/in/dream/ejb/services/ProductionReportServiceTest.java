package in.dream.ejb.services;

import in.dream.ejb.models.Dailyplan;
import in.dream.ejb.models.Farmer;
import in.dream.ejb.models.Problem;
import in.dream.ejb.models.Report;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.any;

public class ProductionReportServiceTest {

    @Test
    void getFarmerProductionList() {
        try {
            EntityManager em = Mockito.mock(EntityManager.class);

            List<Report> customResults = new ArrayList<Report>();
            TypedQuery<Report> qu = Mockito.mock(TypedQuery.class);


            Mockito.when(qu.setParameter(any(Integer.class), any(Object.class))).thenReturn(qu);
            Mockito.when(qu.getResultList()).thenReturn(customResults);
            Mockito.when(em.createQuery("select r from Report r where r.farmer.farm.area.areaid=?1",
                    Report.class)).thenReturn(qu);
            ProductionReportService ds = new ProductionReportService();
            ds.em = em;

            List<Report>  l = ds.getFarmerProductionList(  1l);
            assertNotNull(l);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void reportProduction() {
        try {
            EntityManager em = Mockito.mock(EntityManager.class);

            List<Report> customResults = new ArrayList<Report>();
            TypedQuery<Report> qu = Mockito.mock(TypedQuery.class);


            Mockito.when(qu.setParameter(any(Integer.class), any(Object.class))).thenReturn(qu);
            Mockito.when(qu.getResultList()).thenReturn(customResults);
            Mockito.when(em.createQuery("select r from Report r where r.farmer.farm.area.areaid=?1",
                    Report.class)).thenReturn(qu);
            ProductionReportService ds = new ProductionReportService();
            ds.em = em;
            ds.reportProduction(new Farmer(), "asdsad", 111f,
            222f, "2020-11-1", "2020-11-1");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
