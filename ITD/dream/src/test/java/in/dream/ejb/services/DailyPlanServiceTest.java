package in.dream.ejb.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

class DailyPlanServiceTest {

    @PersistenceContext(unitName = "DREAMEJB")
    EntityManager em;

    DailyPlanService dailyPlanService;

    @BeforeAll
    public void setUp() {
        dailyPlanService = new DailyPlanService();

    }

    @Test
    void createDailyPlan() {

    }

    @Test
    void getDailyPlanDetail() {
    }

    @Test
    void confirmDailyPlan() {
    }

    @Test
    void getDailyPlanList() {
    }

}