package org.ucv.interfaces;

import java.util.Map;

/**
 * Interface used to implement a way to analyze a file.
 */
public interface AnalyzeMethod<K, V> {
    Map<K, V> analyze();
}
