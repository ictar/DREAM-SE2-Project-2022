package in.dream.ejb.services;

import in.dream.ejb.models.*;

import javax.ejb.CreateException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.security.auth.login.CredentialException;
import java.util.List;
import java.util.Map;

@Stateless
public class AccountService {
    @PersistenceContext(unitName = "DREAMEJB")
    protected EntityManager em;

    @Inject
    private GeospatialDataService geoService;

    private static final int PASSWORD_LENGTH = 8;
    // check if passsword satisfy
    // "At least 8 alphanumeric characters, 2 numeric characters."
    private static boolean isValidPassword(String pwd) {
        if(pwd.length() < PASSWORD_LENGTH) return false;

        int charCnt = 0;
        int numCnt = 0;

        for (int i = 0; i < pwd.length(); i++) {
            char ch = pwd.charAt(i);
            if(isNumber(ch)) numCnt++;
            else if(isLetter(ch)) charCnt++;
            else return false;
        }
        return numCnt >= 2;
    }
    private static boolean isLetter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }
    private static boolean isNumber(char ch) {
        return (ch >= '0' && ch <= '9');
    }

    // farmer
    public void createFarmerAccount(String username, String pwd, String phonenumer) throws CreateException {
        if(!isValidPassword(pwd)) {
            throw new CreateException("Password should be at least 8 alphanumeric characters, 2 numeric characters.");
        }
        List<Farmer> fList;

        fList = em.createNamedQuery("Farmer.checkDuplicatePhoneNumber", Farmer.class)
                .setParameter(1, phonenumer)
                .getResultList();

        if (!fList.isEmpty()) {
            throw new CreateException("Phone number alreay exists.");
        }

        Farmer farmer = new Farmer();
        farmer.setName(username);
        farmer.setPassword(pwd);
        farmer.setPhonenumber(phonenumer);

        try {
            Farm fm = em.createNamedQuery("Farm.findByFarmer", Farm.class)
                    .setParameter(1, phonenumer).getSingleResult();
            farmer.setFarm(fm);
        } catch(NoResultException e) {

        }

        try {
            em.persist(farmer);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
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

    public List<Farmer> getFarmerListByArea(Long areaID) {
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

    public void updatePerformance(Map<Long, Integer> performanceData) {
        for(Long fid: performanceData.keySet()) {
            Farmer f = em.createNamedQuery("Farmer.findOne", Farmer.class)
                    .setParameter(1, fid).getSingleResult();
            f.setPerformance(performanceData.get(fid));
        }
    }

    public List<Farmer> getFarmerPerformanceList(Long areaID) {
        return getFarmerListByArea(areaID);
    }

    // policy maker
    public void createPolicyMakerAccount(String username, String pwd, String email) throws CreateException{
        if(!isValidPassword(pwd)) {
            throw new CreateException("Password should be at least 8 alphanumeric characters, 2 numeric characters.");
        }

        List<Policymaker> pmList;

        pmList = em.createNamedQuery("Policymaker.checkDuplicateEmail", Policymaker.class)
                .setParameter(1, email)
                .getResultList();

        if (!pmList.isEmpty()) {
            throw new CreateException("Email already exists");
        }

        Policymaker pm = new Policymaker();
        pm.setName(username);
        pm.setPassword(pwd);
        pm.setEmail(email);

        try {
            em.persist(pm);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
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
    public void createAgronomistAccount(String username, String pwd, String email, Long areaId) throws CreateException {
        if(!isValidPassword(pwd)) {
            throw new CreateException("Password should be at least 8 alphanumeric characters, 2 numeric characters.");
        }
        List<Agronomist> aList;

        aList = em.createNamedQuery("Agronomist.checkDuplicateEmail", Agronomist.class)
                .setParameter(1, email)
                .getResultList();

        if (!aList.isEmpty()) {
            throw new CreateException("Email already exists");
        }

        Area area = geoService.getArea(areaId);
        if(area == null) {
            throw new CreateException("Area does not exist!");
        }

        Agronomist ag = new Agronomist();
        ag.setName(username);
        ag.setPassword(pwd);
        ag.setEmail(email);
        ag.setArea(area);

        try {
            em.persist(ag);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
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

    public Agronomist getAgronomist(Long agronomistid) {
        Agronomist a;
        try {
            a = em.createNamedQuery("Agronomist.findOne", Agronomist.class)
                    .getSingleResult();
        }catch (Exception e) {
            return null;
        }
        return a;
    }
}
