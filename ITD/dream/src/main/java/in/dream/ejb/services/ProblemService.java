package in.dream.ejb.services;

import in.dream.ejb.models.Comment;
import in.dream.ejb.models.Problem;
import in.dream.ejb.models.Farmer;

import javax.ejb.CreateException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Stateless
public class ProblemService {
    @PersistenceContext(unitName = "DREAMEJB")
    protected EntityManager em;

    public void createRequest(String title, String content, Farmer farmer, Timestamp time) throws CreateException {
        if (title.length() < 1 || content.length() < 1) {
            throw new CreateException("Please enter title or content.");
        }

        Problem problem = new Problem();
        problem.setTitle(title);
        problem.setRequest(content);
        problem.setFarmer(farmer);
        problem.setRequesttime(time);

        try {
            em.persist(problem);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    public List<Problem> getProblemByFarmer(Long farmerid) {
        List<Problem> result;

        try {
            result = em.createQuery("SELECT a from Problem a WHERE a.farmer.farmerid=?1 ", Problem.class).setParameter(1, farmerid).getResultList();
        } catch (PersistenceException e) {
            return null;
        }
        return result;
    }

    public void updateFeedback(Long problemId, int feedback) {


    }
}