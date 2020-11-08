package org.ucv.implementations;

import org.ucv.interfaces.AnalyzeMethod;

import java.util.HashMap;
import java.util.Map;

public class PercentageCharacterFrequencyImpl implements AnalyzeMethod<Character, Float> {

    private FileInformation fileInformation;
    private Map<Character, Float> characterPercentage;

    public PercentageCharacterFrequencyImpl(FileInformation fileInformation){
        this.fileInformation = fileInformation;
        characterPercentage = new HashMap<>();
    }

    @Override
    public Map<Character, Float> analyze() {
        Map<Character, Integer> nominalCharactersFrequencies = getCharacterNominalFrequencies();
        float[] value = {0};
        nominalCharactersFrequencies
                .entrySet()
                .stream()
                .forEach(entry ->{
                    characterPercentage.put(entry.getKey(), (float)entry.getValue()/fileInformation.getNumberOfCharacters()*100);
                    value[0] = (float)entry.getValue()/fileInformation.getNumberOfCharacters()*100;
                });

        return characterPercentage;
    }

    private Map<Character, Integer> getCharacterNominalFrequencies(){
        Map<Character, Integer> nominalValues = new HashMap<>();
        fileInformation
                .getLinesOfFile()
                .forEach(string ->{
                    for(int i = 0; i < string.length(); i++){
                        Character character = Character.valueOf(string.charAt(i));
                        if(nominalValues.containsKey(character)){
                            nominalValues.put(character, nominalValues.get(character) + 1);
                        } else {
                            nominalValues.put(character, 1);
                        }
                    }
                });
        return nominalValues;
    }
}
