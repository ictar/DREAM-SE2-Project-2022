package in.dream.ejb.services;

import in.dream.ejb.models.Problem;
import in.dream.ejb.models.Farmer;

import javax.ejb.CreateException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.sql.Timestamp;
import java.util.List;

@Stateless
public class ProblemService {
    @PersistenceContext(unitName = "DREAMEJB")
    protected EntityManager em;

    //

    //TODO how to get farmer?
    public void createRequest(String title, String content, Farmer farmer, Timestamp requesttime) throws CreateException {
        if(title.length()<1 || content.length()<1) {
            throw new CreateException("Please enter title or content.");
        }

        Problem problem = new Problem();
        problem.setTitle(title);
        problem.setRequest(content);
        problem.setFarmer(farmer);
        problem.setRequesttime(requesttime);

        try {
            em.persist(problem);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    //TODO what's list?
    public List<Problem> getProblemByFarmer(Farmer farmer) {
        List<Problem> result;

        try{
            result = em.createNamedQuery("Problem.findAll", Problem.class)
                    .setParameter(1, farmer)
                    .getResultList();
        } catch (PersistenceException e) {
            return null;
        }

        return result;
    }
}