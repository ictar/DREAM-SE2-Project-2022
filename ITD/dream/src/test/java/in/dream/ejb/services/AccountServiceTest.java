package in.dream.ejb.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AccountServiceTest {

    @Mock
    private EntityManager em;

    @Mock
    private TypedQuery<Object> query1;

    @InjectMocks
    private AccountService accountService;

    private static final String USER_NAME = "TEST1";
    private static final String PASSWORD = "test";


    @BeforeAll
    public void setUp() {
        accountService = new AccountService();

    }

    @Test
    void createFarmerAccount() {
    }

    @Test
    void authenticateFarmer() {
    }

    @Test
    void getFarmerListByArea() {
    }

    @Test
    void getFarmerListByAgronomist() {
    }

    @Test
    void getAgronomistByFarmer() {
    }

    @Test
    void updatePerformance() {
    }

    @Test
    void getFarmerPerformanceList() {
    }

    @Test
    void createPolicyMakerAccount() {
    }

    @Test
    void authenticatePolicymaker() {
    }

    @Test
    void createAgronomistAccount() {
    }

    @Test
    void authenticateAgronomist() {
    }

    @Test
    void getAgronomistList() {
    }

    @Test
    void getAgronomist() {
    }
}