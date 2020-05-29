package edu.wctc.dao;

import edu.wctc.rest.entity.Legend;

import java.util.List;

public interface LegendDAO {
    List<Legend> getLegends();

    Legend getLegend(int theId);
}
