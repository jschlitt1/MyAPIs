package edu.wctc.dao;

import edu.wctc.rest.entity.Resturant;

import java.util.List;

public interface ResturantDAO {
    List<Resturant> getResturants();

    Resturant getResturant(int theId);
}
