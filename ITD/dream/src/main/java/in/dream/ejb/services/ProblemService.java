package in.dream.ejb.services;

import in.dream.ejb.models.Problem;
import in.dream.ejb.models.Area;
import in.dream.ejb.models.Farmer;
import in.dream.ejb.models.Policymaker;

import javax.ejb.CreateException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.security.auth.login.CredentialException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

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
    public List<Problem> getProblemTitle() {
        List<Problem> result;

        try{
            result = em.createNamedQuery("Problem.findAll", Problem.class).getResultList();
        } catch (PersistenceException e) {
            return null;
        }

        return result;
    }
}