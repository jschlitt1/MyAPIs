package edu.wctc.rest;

/**
 * A runtime (unchecked) exception. This class doesn't do
 * anything special, but it acts like a "marker" so our
 * application can detect when a legend isn't found.
 */
public class ResturantNotFoundException extends RuntimeException {
    public ResturantNotFoundException(String message) {
        super(message);
    }
}
