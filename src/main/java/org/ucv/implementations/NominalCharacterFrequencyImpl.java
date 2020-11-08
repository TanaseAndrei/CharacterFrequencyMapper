package org.ucv.implementations;

import org.ucv.interfaces.AnalyzeMethod;

import java.util.HashMap;
import java.util.Map;

public class NominalCharacterFrequencyImpl implements AnalyzeMethod<Character, Integer> {

    private FileInformation fileInformation;
    private Map<Character, Integer> characterFrequency;

    public NominalCharacterFrequencyImpl(FileInformation fileInformation){
        this.fileInformation = fileInformation;
        characterFrequency = new HashMap<>();
    }

    @Override
    public Map<Character, Integer> analyze() {
        fileInformation
                .getLinesOfFile()
                .forEach(string ->{
                    for(int i = 0; i < string.length(); i++){
                        Character character = Character.valueOf(string.charAt(i));
                        if(characterFrequency.containsKey(character)){
                            characterFrequency.put(character, characterFrequency.get(character) + 1);
                        } else {
                            characterFrequency.put(character, 1);
                        }
                    }
                });
        return characterFrequency;
    }
}
