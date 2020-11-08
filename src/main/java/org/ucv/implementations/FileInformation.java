package org.ucv.implementations;

import java.util.ArrayList;
import java.util.List;

/**
 * A class used to represent the details of a file, like number of characters,
 * its lines etc.
 */
public class FileInformation {

    private int numberOfCharacters;
    private List<String> linesOfFile;

    public FileInformation(){
        linesOfFile = new ArrayList<>();
    }

    public void addLine(String line){
        linesOfFile.add(line);
    }

    public int getNumberOfCharacters() {
        return numberOfCharacters;
    }

    public void setNumberOfCharacters(int numberOfCharacters) {
        this.numberOfCharacters = numberOfCharacters;
    }

    public List<String> getLinesOfFile() {
        return linesOfFile;
    }

}
