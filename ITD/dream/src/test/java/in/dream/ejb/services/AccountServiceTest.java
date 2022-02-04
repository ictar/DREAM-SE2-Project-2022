package in.dream.ejb.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    @PersistenceContext(unitName = "DREAMEJB")
    EntityManager em;
    AccountService accountService;

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