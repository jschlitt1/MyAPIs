package edu.wctc.rest.controller;

import edu.wctc.rest.LegendErrorResponse;
import edu.wctc.rest.LegendNotFoundException;
import edu.wctc.rest.ResturantErrorResponse;
import edu.wctc.rest.ResturantNotFoundException;
import edu.wctc.rest.entity.Legend;
import edu.wctc.rest.entity.Resturant;
import edu.wctc.service.LegendService;
import edu.wctc.service.ResturantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private LegendService legendService;
    @Autowired
    private ResturantService resturantService;

    // @PostConstruct called only once, after this bean (MyRestController) is constructed
    // Need Common Annotations API if using Java 9 or higher
    @PostConstruct
    public void loadData() {
    }

    // legend section --------------------------------------------------------------------------------
    @GetMapping("/legends")
    // defines endpoint for "/students" - return list of students
    public List<Legend> getLegends() {
        return legendService.getLegends();
    }

    @GetMapping("/legends/{legendId}")
    // defines endpoint for "/legends/{legendId}" - return legend by ID
    // Path variable must match parameter name by default
    public Legend getLegend(@PathVariable int legendId) {
        return legendService.getLegend(legendId);

        // return null;
        //throw new LegendNotFoundException("Legend ID not found: " + legendId);
    }

    @ExceptionHandler
    // handles the exception that is thrown by getStudent when an invalid ID
    // is requested
    public ResponseEntity<LegendErrorResponse> handleException(LegendNotFoundException exception) {
        LegendErrorResponse error = new LegendErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    // handles any other exceptions that are thrown by this controller, such as an
    // alphanumeric student ID that can't be parsed to an int
    public ResponseEntity<LegendErrorResponse> handleException(Exception exception) {
        LegendErrorResponse error = new LegendErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    //resturant section ----------------------------------------------------------------------------
    @GetMapping("/resturants")
    // defines endpoint for "/resturants" - return list of resturants
    public List<Resturant> getResturants() {
        return resturantService.getResturants();
    }

    @GetMapping("/resturants/{resturantId}")
    // defines endpoint for "/resturants/{resturantId}" - return resturant by ID
    // Path variable must match parameter name by default
    public Resturant getResturant(@PathVariable int resturantId) {
        return resturantService.getResturant(resturantId);

        // return null;
        //throw new LegendNotFoundException("Legend ID not found: " + legendId);
    }

    @ExceptionHandler
    // handles the exception that is thrown by getStudent when an invalid ID
    // is requested
    public ResponseEntity<ResturantErrorResponse> handleException(ResturantNotFoundException exception) {
        ResturantErrorResponse error = new ResturantErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
