package edu.wctc.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.wctc.rest.entity.Legend;

import java.io.File;
import java.io.IOException;

public class RestDemoApplication {
    private ObjectMapper mapper;

    public RestDemoApplication() {
        // Create Jackson JSON mapper
        mapper = new ObjectMapper();

        // Enable pretty-print output
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Support for Java 8 temporal classes like LocalDate
        mapper.registerModule(new JavaTimeModule());
    }

    public static void main(String[] args) throws IOException {
        new RestDemoApplication().readWriteLegend();
    }

    public void readWriteLegend() throws IOException {
        File input = new File("rest-data/legend-in.json");

        Legend aLegend = mapper.readValue(input, Legend.class);

        System.out.println(aLegend);

        File output = new File("rest-data/legend-out.json");

        mapper.writeValue(output, aLegend);
    }
}
