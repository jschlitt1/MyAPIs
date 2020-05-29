package edu.wctc.service;

import edu.wctc.rest.entity.Legend;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface LegendService {
    Legend getLegend(int theId);

    List<Legend> getLegends();
}
