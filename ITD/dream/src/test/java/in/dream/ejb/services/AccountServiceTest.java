package in.dream.ejb.services;

import in.dream.ejb.models.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import javax.ejb.CreateException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.security.auth.login.CredentialException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AccountServiceTest {

    @Mock
    private EntityManager em;

    @Mock
    private TypedQuery<Agronomist> agqry;
    @Mock
    private TypedQuery<Farm> fqry;
    @Mock
    private TypedQuery<Farmer> fmqry;
    @Mock
    private TypedQuery<Policymaker> pmqry;

    @InjectMocks
    private AccountService accountService;

    private static final String USER_NAME = "TEST1";
    private static final String PASSWORD = "test";

    @BeforeEach
    public void setUp() {
        when(em.createNamedQuery(anyString(), eq(Farmer.class))).thenReturn(fmqry);
        when(em.createQuery(anyString(), eq(Farmer.class))).thenReturn(fmqry);
        when(fmqry.setParameter(anyInt(), any(String.class))).thenReturn(fmqry);
        when(fmqry.setParameter(anyInt(), any(Long.class))).thenReturn(fmqry);

        when(em.createNamedQuery(anyString(), eq(Farm.class))).thenReturn(fqry);
        when(em.createQuery(anyString(), eq(Farm.class))).thenReturn(fqry);
        when(fqry.setParameter(anyInt(), any(String.class))).thenReturn(fqry);

        when(em.createNamedQuery(anyString(), eq(Agronomist.class))).thenReturn(agqry);
        when(em.createQuery(anyString(), eq(Agronomist.class))).thenReturn(agqry);
        when(agqry.setParameter(anyInt(), any(String.class))).thenReturn(agqry);
        when(agqry.setParameter(anyInt(), any(Long.class))).thenReturn(agqry);

        when(em.createNamedQuery(anyString(), eq(Policymaker.class))).thenReturn(pmqry);
        when(em.createQuery(anyString(), eq(Policymaker.class))).thenReturn(pmqry);
        when(pmqry.setParameter(anyInt(), any(String.class))).thenReturn(pmqry);

        //accountService = new AccountService();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void createFarmerAccount_success() {
        List<Farmer> customResults = new ArrayList<Farmer>();

        String phonenumer = "12323123213";
        List<Farm> Farms = new ArrayList<Farm>();


        when(fmqry.getResultList()).thenReturn(customResults);

        when(fqry.getResultList()).thenReturn(Farms);

        assertDoesNotThrow(() -> accountService.createFarmerAccount("aaa", "aaaa123456", phonenumer));
    }

    @Test
    public void createFarmerAccount_invalidpwd() {
        List<Farmer> customResults = new ArrayList<Farmer>();

        String phonenumer = "12323123213";
        List<Farm> Farms = new ArrayList<Farm>();


        when(fmqry.getResultList()).thenReturn(customResults);

        when(fqry.getResultList()).thenReturn(Farms);

        assertThrows(CreateException.class,
                ()-> accountService.createFarmerAccount("aaa", "aaaaaa", phonenumer)
        );
    }

    @Test
    public void authenticateFarmer_success() {
        String  phonenumer = "12323123213";
        List<Farmer> customResults = new ArrayList<Farmer>();
        customResults.add(new Farmer());

        when(fmqry.getResultList()).thenReturn(customResults);

        assertDoesNotThrow(()->{
            Farmer a = accountService.authenticateFarmer( phonenumer, "aaaaa11aaaaaaaaa");
            assertNotNull(a);
        });
    }

    @Test
    public void authenticateFarmer_noexist() {
        String  phonenumer = "12323123213";
        List<Farmer> customResults = new ArrayList<Farmer>();

        when(fmqry.getResultList()).thenReturn(customResults);

        assertThrows(CredentialException.class,
                ()->accountService.authenticateFarmer( phonenumer, "aaaaa11aaaaaaaaa")
        );
    }
    @Test
    public void authenticateFarmer_morethan2() {
        String  phonenumer = "12323123213";
        List<Farmer> customResults = new ArrayList<Farmer>();
        customResults.add(new Farmer());
        customResults.add(new Farmer());

        when(fmqry.getResultList()).thenReturn(customResults);

        assertThrows(CredentialException.class, ()->accountService.authenticateFarmer( phonenumer, "aaaaa11aaaaaaaaa"));
    }

    @Test
    public void getFarmerListByArea() {
        List<Farmer> customResults = new ArrayList<Farmer>();
        customResults.add(new Farmer());

        when(fmqry.getResultList()).thenReturn(customResults);

        List<Farmer> a = accountService.getFarmerListByArea( 1111l);
        assertNotNull(a);

    }

    @Test
    public void getFarmerListByAgronomist() {
        List<Farmer> customResults = new ArrayList<Farmer>();
        customResults.add(new Farmer());

        when(fmqry.getResultList()).thenReturn(customResults);

        List<Farmer> a =  accountService.getFarmerListByAgronomist( 1111L);
        assertNotNull(a);
    }

    @Test
    public void getAgronomistByFarmer() {
        Agronomist testag = new Agronomist();

        when(agqry.getSingleResult()).thenReturn(testag);

        Agronomist a  = accountService.getAgronomistByFarmer( 1111L);
        assertNotNull(a);
    }

    @Test
    public void updatePerformance() {
        try {
            List<Farmer> customResults = new ArrayList<Farmer>();
            Farmer farmer = new Farmer();

            when(fmqry.getResultList()).thenReturn(customResults);
            when(fmqry.getSingleResult()).thenReturn(farmer);

            Map<Long, Integer> map = new HashMap<>();
            map.put(111l, 1);
           accountService.updatePerformance( map);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createPolicyMakerAccount() {
        try {
            List<Policymaker> customResults = new ArrayList<Policymaker>();

            when(pmqry.getResultList()).thenReturn(customResults);

            accountService.createPolicyMakerAccount( "elel","aaaa11aaaaa", "1@a.com");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void authenticatePolicymaker() {

        try {
            List<Policymaker> customResults = new ArrayList<Policymaker>();

            when(pmqry.getResultList()).thenReturn(customResults);

            Policymaker p = accountService.authenticatePolicymaker(  "1@a.com", "aaaa11aaaaa");
            assertNotNull(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createAgronomistAccount() {

        try {
            List<Agronomist> customResults = new ArrayList<Agronomist>();

            when(agqry.getResultList()).thenReturn(customResults);

            GeospatialDataService gs = Mockito.mock(GeospatialDataService.class);
            when(gs.getArea(anyLong())).thenReturn(new Area());

            accountService.createAgronomistAccount( "elel","aaaa11aaaaa", "1@a.com", 1111l);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void authenticateAgronomist() {
        try {
            List<Agronomist> customResults = new ArrayList<Agronomist>();
            customResults.add(new Agronomist());

            when(agqry.getResultList()).thenReturn(customResults);

            Agronomist a =  accountService.authenticateAgronomist(  "1@a.com", "aaaa11aaaaa");
            assertNotNull(a);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAgronomistList() {
        try {
            List<Agronomist> customResults = new ArrayList<Agronomist>();

            when(agqry.getResultList()).thenReturn(customResults);

            List<Agronomist> a=  accountService.getAgronomistList( );
            assertEquals(0, a.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAgronomist() {
        try {
            Agronomist ag = new Agronomist();
            List<Agronomist> customResults = new ArrayList<Agronomist>();
            customResults.add(ag);


            when(agqry.getResultList()).thenReturn(customResults);

            Agronomist a=  accountService.authenticateAgronomist(  "1@a.com", "aaaa11aaaaa");
            assertNotNull(a);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}