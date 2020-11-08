package org.ucv.interfaces;

/**
 * Interface that is used to implement a text analyzer.
 * The implementation of this class can be used with another
 * interface (Strategy pattern) to change the analyzer behaviour.
 */
public interface Application {
    void start();
}
