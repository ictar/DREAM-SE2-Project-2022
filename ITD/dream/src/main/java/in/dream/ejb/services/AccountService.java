package in.dream.ejb.services;

import in.dream.ejb.models.Agronomist;
import in.dream.ejb.models.Area;
import in.dream.ejb.models.Farmer;
import in.dream.ejb.models.Policymaker;

import javax.ejb.CreateException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.security.auth.login.CredentialException;
import java.util.List;

@Stateless
public class AccountService {
    @PersistenceContext(unitName = "DREAMEJB")
    protected EntityManager em;

    // farmer
    public boolean createFarmerAccount(String username, String pwd, String phonenumer) {
        List<Farmer> fList;

        fList = em.createNamedQuery("Farmer.checkDuplicatePhoneNumber", Farmer.class)
                .setParameter(1, phonenumer)
                .getResultList();

        if (!fList.isEmpty()) {
            return false;
        }

        Farmer farmer = new Farmer();
        farmer.setName(username);
        farmer.setPassword(pwd);
        farmer.setPhonenumber(phonenumer);

        try {
            em.persist(farmer);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Farmer authenticateFarmer(String phonenumber, String pwd) throws CredentialException {
        List <Farmer> flist;

        try {
            flist = em.createNamedQuery("Farmer.checkCredentials", Farmer.class)
                    .setParameter(1, phonenumber)
                    .setParameter(2, pwd)
                    .getResultList();
        } catch (PersistenceException e) {
            throw new CredentialException("Could not verify credentials of farmer " + phonenumber);
        }

        if(flist.isEmpty()) {
            return null;
        } else if(flist.size() == 1) {
            return flist.get(0);
        }

        throw new CredentialException("More than one farmer registered with same credentials.");
    }

    public List<Farmer> getFarmerListByArea(int areaID) {
        List<Farmer> result;
        try {
            result = em.createQuery("select f from Farmer f, Farm fm where fm.phonenumber = fm.farmer and fm.area = ?1",
                        Farmer.class).setParameter(1, areaID).getResultList();
        } catch (Exception e) {
            return null;
        }

        return result;
    }

    public List<Farmer> getFarmerListByAgronomist(int agronomistID) {
        List<Farmer> result;

        try {
            result = em.createQuery("select f from Farmer f, Farm fm, Agronomist a where f.phonenumber = fm.farmer and fm.area = a.area and a.agronomistid=?1",
                    Farmer.class).setParameter(1, agronomistID).getResultList();
        } catch (Exception e) {
            return null;
        }
        return result;
    }

    public Agronomist getAgronomistByFarmer(int farmerID) {
        Agronomist ag;

        try {
            ag = em.createQuery("select a from Farmer f, Farm fm, Agronomist a where f.phonenumber = fm.farmer and fm.area = a.area and f.farmerid=?1",
                    Agronomist.class).setParameter(1, farmerID).getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return ag;
    }

    // TODO
    /*public void updatePerformance(Map<int, int> performanceData) {

    }*/

    public List<Farmer> getFarmerPerformanceList(int areaID) {
        return getFarmerListByArea(areaID);
    }

    // policy maker
    public boolean createPolicyMakerAccount(String username, String pwd, String email){
        List<Policymaker> pmList;

        pmList = em.createNamedQuery("Policymaker.checkDuplicateEmail", Policymaker.class)
                .setParameter(1, email)
                .getResultList();

        if (!pmList.isEmpty()) {
            return false;
        }

        Policymaker pm = new Policymaker();
        pm.setName(username);
        pm.setPassword(pwd);
        pm.setEmail(email);

        try {
            em.persist(pm);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public Policymaker authenticatePolicymaker(String email, String pwd) throws CredentialException {
        List <Policymaker> plist;

        try {
            plist = em.createNamedQuery("Policymaker.checkCredentials", Policymaker.class)
                    .setParameter(1, email)
                    .setParameter(2, pwd)
                    .getResultList();
        } catch (PersistenceException e) {
            throw new CredentialException("Could not verify credentials of policy maker " + email);
        }

        if(plist.isEmpty()) {
            return null;
        } else if(plist.size() == 1) {
            return plist.get(0);
        }

        throw new CredentialException("More than one policy maker registered with same credentials.");
    }

    // agronomist
    public boolean createAgronomistAccount(String username, String pwd, String email, Area area) throws CreateException {
        List<Agronomist> aList;

        aList = em.createNamedQuery("Agronomist.checkDuplicateEmail", Agronomist.class)
                .setParameter(1, email)
                .getResultList();

        if (!aList.isEmpty()) {
            return false;
        }

        Agronomist ag = new Agronomist();
        ag.setName(username);
        ag.setPassword(pwd);
        ag.setEmail(email);
        ag.setArea(area);

        try {
            em.persist(ag);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public Agronomist authenticateAgronomist(String email, String pwd) throws CredentialException {
        List <Agronomist> alist;

        try {
            alist = em.createNamedQuery("Agronomist.checkCredentials", Agronomist.class)
                    .setParameter(1, email)
                    .setParameter(2, pwd)
                    .getResultList();
        } catch (PersistenceException e) {
            throw new CredentialException("Could not verify credentials of agronomist " + email);
        }

        if(alist.isEmpty()) {
            return null;
        } else if(alist.size() == 1) {
            return alist.get(0);
        }

        throw new CredentialException("More than one agronomist registered with same credentials.");
    }

    public List<Agronomist> getAgronomistList() {
        List<Agronomist> result;

        try{
            result = em.createNamedQuery("Agronomist.findAll", Agronomist.class)
                    .getResultList();
        } catch (PersistenceException e) {
            return null;
        }

        return result;
    }
}
