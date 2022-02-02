package in.dream.ejb.services;

import in.dream.ejb.models.Farmer;
import in.dream.ejb.models.Report;

import javax.ejb.CreateException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Stateless
public class ProductionReportService {
    @PersistenceContext(unitName = "DREAMEJB")
    protected EntityManager em;

    public void reportProduction(Farmer farmer, String type, float amount,
                                 float acreage, String starttime, String endtime) throws CreateException{
        Report report = new Report();
        report.setType(type);
        report.setAmount(amount);
        report.setAcreage(acreage);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        report.setStartime(LocalDate.parse(starttime, formatter));
        report.setEndtime(LocalDate.parse(endtime, formatter));

        report.setFarmer(farmer);
        try {
            em.persist(report);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    public List<Report> getFarmerProductionList(Long areaID) {
        List<Report> result;
        try {
            result = em.createQuery("select r from Report r, Farm fm where r.farmer.phonenumber=fm.farmer and fm.area=?1",
                    Report.class).setParameter(1, areaID).getResultList();
        } catch (Exception e) {
            return null;
        }
        return result;
    }
}
