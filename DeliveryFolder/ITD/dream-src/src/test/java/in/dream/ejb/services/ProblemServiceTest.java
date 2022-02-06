package in.dream.ejb.services;

import in.dream.ejb.models.Agronomist;
import in.dream.ejb.models.Dailyplan;
import in.dream.ejb.models.Farmer;
import in.dream.ejb.models.Problem;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;

public class ProblemServiceTest {
    @Test
    void createRequest() {
        try {
            EntityManager em = Mockito.mock(EntityManager.class);
            List<Dailyplan> customResults = new ArrayList<Dailyplan>();
            TypedQuery<Dailyplan> qu = Mockito.mock(TypedQuery.class);


            Mockito.when(em.createNamedQuery("Dailyplan.findByAgronomist", Dailyplan.class)).thenReturn(qu);
            Mockito.when(qu.setParameter(any(Integer.class), any(Object.class))).thenReturn(qu);
            Mockito.when(qu.getResultList()).thenReturn(customResults);
            Mockito.when(qu.getSingleResult()).thenReturn(new Dailyplan());

            ProblemService ds = new ProblemService();
            ds.em = em;

            List<Long> fs = new ArrayList<>();
            fs.add(1l);
            Timestamp time = new Timestamp(System.currentTimeMillis());

            ds.createProblem(  "asdsad", "asdsadsads", new Farmer(), time, new Agronomist());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getProblemByFarmer() {
        try {
            EntityManager em = Mockito.mock(EntityManager.class);
            List<Problem> customResults = new ArrayList<Problem>();
            TypedQuery<Problem> qu = Mockito.mock(TypedQuery.class);


            Mockito.when( em.createQuery("SELECT a from Problem a WHERE a.farmer.farmerid=?1 ", Problem.class)).thenReturn(qu);
            Mockito.when(qu.setParameter(any(Integer.class), any(Object.class))).thenReturn(qu);
            Mockito.when(qu.getResultList()).thenReturn(customResults);


            ProblemService ds = new ProblemService();
            ds.em = em;

            List<Long> fs = new ArrayList<>();
            fs.add(1l);
            Timestamp time = new Timestamp(System.currentTimeMillis());

            List<Problem> l =  ds.getProblemByFarmer(  1l);
            assertNotNull(l);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void updateFeedback() {
        try {
            EntityManager em = Mockito.mock(EntityManager.class);

            Mockito.when( em.find(eq(Problem.class), anyLong())).thenReturn(new Problem());


            ProblemService ds = new ProblemService();
            ds.em = em;

            List<Long> fs = new ArrayList<>();
            fs.add(1l);
            Timestamp time = new Timestamp(System.currentTimeMillis());

            ds.feedbackProblem(  1l, 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
