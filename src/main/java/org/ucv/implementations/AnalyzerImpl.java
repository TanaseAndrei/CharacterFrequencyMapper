package org.ucv.implementations;

import org.ucv.interfaces.AnalyzeMethod;
import org.ucv.interfaces.Analyzer;

import java.util.Map;

public class AnalyzerImpl<K, V> implements Analyzer<K, V> {

    private AnalyzeMethod analyzeMethod;

    public AnalyzerImpl(AnalyzeMethod analyzeMethod){
        this.analyzeMethod = analyzeMethod;
    }

    public Map<K, V> analyze() {
        return analyzeMethod.analyze();
    }

}
