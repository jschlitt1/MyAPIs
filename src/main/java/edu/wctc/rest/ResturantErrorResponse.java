package edu.wctc.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This POJO can be serialized as JSON and sent to clients
 * to inform them about the error that occurred.
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResturantErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
