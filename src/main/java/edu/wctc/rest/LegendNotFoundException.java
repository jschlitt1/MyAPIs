package edu.wctc.rest;

/**
 * A runtime (unchecked) exception. This class doesn't do
 * anything special, but it acts like a "marker" so our
 * application can detect when a legend isn't found.
 */
public class LegendNotFoundException extends RuntimeException {
    public LegendNotFoundException(String message) {
        super(message);
    }
}
