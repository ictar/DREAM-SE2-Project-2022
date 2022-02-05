package in.dream.ejb.services;

import in.dream.ejb.models.Agronomist;
import in.dream.ejb.models.Dailyplan;
import in.dream.ejb.models.Farmer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

class DailyPlanServiceTest {



    @Test
    void createDailyPlan() {
        try {
            EntityManager em = Mockito.mock(EntityManager.class);
            List<Farmer> customResults = new ArrayList<Farmer>();
            TypedQuery<Farmer> qu = Mockito.mock(TypedQuery.class);


            Mockito.when(em.createNamedQuery("Farmer.findOne", Farmer.class)).thenReturn(qu);
            Mockito.when(qu.setParameter(any(Integer.class), any(Object.class))).thenReturn(qu);
            Mockito.when(qu.getResultList()).thenReturn(customResults);
            Mockito.when(qu.getSingleResult()).thenReturn(new Farmer());

            DailyPlanService ds = new DailyPlanService();
            ds.em = em;
            Agronomist a = new Agronomist();
            List<Long> fs = new ArrayList<>();
            fs.add(1l);
            ds.createDailyPlan(  a, "titlr", "1/11/2020", fs , "conteng");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getDailyPlanDetail() {
        try {
            EntityManager em = Mockito.mock(EntityManager.class);
            List<Dailyplan> customResults = new ArrayList<Dailyplan>();
            TypedQuery<Dailyplan> qu = Mockito.mock(TypedQuery.class);


            Mockito.when( em.createNamedQuery("Dailyplan.findOne", Dailyplan.class)).thenReturn(qu);
            Mockito.when(qu.setParameter(any(Integer.class), any(Object.class))).thenReturn(qu);
            Mockito.when(qu.getResultList()).thenReturn(customResults);
            Mockito.when(qu.getSingleResult()).thenReturn(new Dailyplan());

            DailyPlanService ds = new DailyPlanService();
            ds.em = em;
            Agronomist a = new Agronomist();
            List<Long> fs = new ArrayList<>();
            fs.add(1l);
            Dailyplan d = ds.getDailyPlanDetail(  1l);
            assertNotNull(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void confirmDailyPlan() {
        try {
            EntityManager em = Mockito.mock(EntityManager.class);
            List<Dailyplan> customResults = new ArrayList<Dailyplan>();
            TypedQuery<Dailyplan> qu = Mockito.mock(TypedQuery.class);


            Mockito.when(  em.createNamedQuery("Dailyplan.findOne", Dailyplan.class)).thenReturn(qu);
            Mockito.when(qu.setParameter(any(Integer.class), any(Object.class))).thenReturn(qu);
            Mockito.when(qu.getResultList()).thenReturn(customResults);
            Mockito.when(qu.getSingleResult()).thenReturn(new Dailyplan());

            DailyPlanService ds = new DailyPlanService();
            ds.em = em;
            Agronomist a = new Agronomist();
            List<Long> fs = new ArrayList<>();
            fs.add(1l);
            String d = ds.confirmDailyPlan(  1l, "asdsadsad");
            assertNotNull(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getDailyPlanList() {
        try {
            EntityManager em = Mockito.mock(EntityManager.class);
            List<Dailyplan> customResults = new ArrayList<Dailyplan>();
            TypedQuery<Dailyplan> qu = Mockito.mock(TypedQuery.class);


            Mockito.when(em.createNamedQuery("Dailyplan.findByAgronomist", Dailyplan.class)).thenReturn(qu);
            Mockito.when(qu.setParameter(any(Integer.class), any(Object.class))).thenReturn(qu);
            Mockito.when(qu.getResultList()).thenReturn(customResults);
            Mockito.when(qu.getSingleResult()).thenReturn(new Dailyplan());

            DailyPlanService ds = new DailyPlanService();
            ds.em = em;

            List<Long> fs = new ArrayList<>();
            fs.add(1l);
            List<Dailyplan> d = ds.getDailyPlanList(  1l, 1, 1);
            assertNotNull(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}