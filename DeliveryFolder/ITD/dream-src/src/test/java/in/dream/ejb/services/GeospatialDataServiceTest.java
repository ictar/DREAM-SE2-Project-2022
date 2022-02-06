package in.dream.ejb.services;

import in.dream.ejb.external.Soil;
import in.dream.ejb.models.Area;
import in.dream.ejb.models.Dailyplan;
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

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class GeospatialDataServiceTest {
    @Mock
    private EntityManager em;

    @Mock
    private TypedQuery<Area> query;

    @InjectMocks
    private GeospatialDataService geospatialDataService;

    private Area area;

    private  static final Long AREAID = 1L;
    private  static final String AREANAME = "test area 1";


    @BeforeEach
    public void setUp() {
        when(em.createNamedQuery(anyString(), eq(Area.class))).thenReturn(query);
        area = new Area();
        area.setAreaid(AREAID);
        area.setName(AREANAME);
        List<Area> areas = new ArrayList<>();
        areas.add(area);
        when(query.getResultList()).thenReturn(areas);

        geospatialDataService.initialize();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    void getAreaList() {
        List<Area> ret = geospatialDataService.getAreaList();
        assertNotNull(ret);
    }

    @Test
    void getArea_exist() {
        Area ret = geospatialDataService.getArea(AREAID);
        assertNotNull(ret);
    }

    @Test
    void getArea_noexist() {
        Area ret = geospatialDataService.getArea(AREAID+100);
        assertNull(ret);
    }
}