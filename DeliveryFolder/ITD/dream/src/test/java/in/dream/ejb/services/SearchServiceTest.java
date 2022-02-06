package in.dream.ejb.services;

import in.dream.ejb.models.Problem;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;

public class SearchServiceTest {

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
