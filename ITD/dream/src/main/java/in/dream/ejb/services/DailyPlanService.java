package in.dream.ejb.services;

import in.dream.ejb.models.Agronomist;
import in.dream.ejb.models.Dailyplan;
import in.dream.ejb.models.Farmer;

import javax.ejb.CreateException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DailyPlanService {
    @PersistenceContext(unitName = "DREAMEJB")
    protected EntityManager em;
    // NOT USED
    public void createDailyPlan(Agronomist agronomist, String title,

                                String date, List<Long> farmerList, String content) throws CreateException {

        // set farmerList
        List<Farmer> farmers = new ArrayList<>();
        for (Long fid: farmerList) {
            Farmer farmer = em.createNamedQuery("Farmer.findOne", Farmer.class).setParameter(1,fid).getSingleResult();
            farmers.add(farmer);
        }

        if(farmers.isEmpty()) {

        }
        Dailyplan dp = new Dailyplan();
        dp.setFarmers(farmers);
        dp.setTitle(title);
        dp.setContent(content);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        dp.setDate(LocalDate.parse(date, formatter));

        // set agronomist
        dp.setAgronomist(agronomist);

        try{
            em.persist(dp);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    // NOT USED
    private String modifyDailyPlan(Long dailyPlanID, String title,
                                 String date, List<Long> farmerList, String content) {
        try {
            Dailyplan dp = em.createNamedQuery("Dailyplan.findOne", Dailyplan.class)
                    .setParameter(1, dailyPlanID)
                    .getSingleResult();
            if (dp == null) {
                return "Dailyplan does not exist!";
            }

            dp.setTitle(title);
            dp.setContent(content);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            dp.setDate(LocalDate.parse(date, formatter));

            // TODO: set farmerList
            em.refresh(dp);

        } catch (Exception e) {
            return e.getMessage();
        }

        return "";
    }

    public Dailyplan getDailyPlanDetail(Long dailyPlanID) {
        try {
            return em.createNamedQuery("Dailyplan.findOne", Dailyplan.class)
                    .setParameter(1, dailyPlanID)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // NOT USED
    public String confirmDailyPlan(Long dailyPlanID, String deviation) {
        try {
            Dailyplan dp = em.createNamedQuery("Dailyplan.findOne", Dailyplan.class)
                    .setParameter(1, dailyPlanID)
                    .getSingleResult();

            if(dp == null) {
                return "Dailyplan does not exist!";
            }

            dp.setCompleted();
            dp.setDeviation(deviation);

            em.refresh(dp);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "";
    }

    /*
    It returns a list of daily plans of the given agronomist.
    The size of the list is computed based on the given parameters,
    and the list will be sorted by time in descending order (latest entries listed first).
    If “page” and “count” are both set to “-1”,
    it will return all daily plans for the given agronomist.
     */
    public List<Dailyplan> getDailyPlanList(Long agronomistID, int page, int count) {
        List<Dailyplan> result;
        try {

            TypedQuery<Dailyplan> query  = em.createNamedQuery("Dailyplan.findByAgronomist", Dailyplan.class)
                    .setParameter(1, agronomistID);

            if(page != -1 || count != -1) {
                query.setFirstResult(page);
                query.setMaxResults(count);
            }

            result = query.getResultList();
        } catch (Exception e) {
            return null;
        }
        return result;
    }
}
