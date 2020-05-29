package edu.wctc.service;
import edu.wctc.dao.LegendDAO;
import edu.wctc.rest.entity.Legend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class LegendServiceImp implements LegendService {
    // inject Legend DAO
    @Autowired
    private LegendDAO legendDAO;

    @Override
    @Transactional
    public Legend getLegend(int theId) {
        return legendDAO.getLegend(theId);
    }


    @Override
    // with @Transactional annotation, no need to begin or commit transaction
    @Transactional
    public List<Legend> getLegends() {
        // Delegate call to DAO
        return legendDAO.getLegends();
    }
}
