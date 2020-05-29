package edu.wctc.service;

import edu.wctc.rest.entity.Resturant;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResturantService {
    Resturant getResturant(int theId);

    List<Resturant> getResturants();
}
