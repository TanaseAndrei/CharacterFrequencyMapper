package org.ucv.interfaces;

import java.util.Map;

public interface Analyzer<K, V> {
    Map<K, V> analyze();
}
