package edu.wctc.service;
import edu.wctc.dao.ResturantDAO;
import edu.wctc.rest.entity.Resturant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ResturantServiceImp implements ResturantService {
    // inject Legend DAO
    @Autowired
    private ResturantDAO resturantDAO;

    @Override
    @Transactional
    public Resturant getResturant(int theId) {
        return resturantDAO.getResturant(theId);
    }


    @Override
    // with @Transactional annotation, no need to begin or commit transaction
    @Transactional
    public List<Resturant> getResturants() {
        // Delegate call to DAO
        return resturantDAO.getResturants();
    }
}
