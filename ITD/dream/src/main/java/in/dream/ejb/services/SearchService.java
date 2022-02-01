package in.dream.ejb.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Stateless
public class SearchService {
    @PersistenceContext(unitName = "DREAMEJB")
    protected EntityManager em;

    // TODO
    public List<String> searchTypeList() {
        return null;
    }

    // TODO
    public Map<String, String> search(String location, String productType) {
        return null;
    }
}
