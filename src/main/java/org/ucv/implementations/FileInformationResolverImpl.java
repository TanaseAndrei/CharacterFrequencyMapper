package org.ucv.implementations;

import org.ucv.exceptions.MyFileNotFoundException;
import org.ucv.interfaces.FileInformationResolver;
import org.ucv.utils.StringUtils;

import java.io.*;

public class FileInformationResolverImpl implements FileInformationResolver {

    private String filePath;
    private FileInformation fileInformation;

    public FileInformationResolverImpl(String filePath){
        this.filePath = filePath;
        fileInformation = new FileInformation();
    }

    @Override
    public FileInformation extractData() {
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] splittedLines = StringUtils.split(line, " ");
                String lineWithoutSpaces = StringUtils.concatStrings(splittedLines);
                fileInformation.addLine(lineWithoutSpaces);
                fileInformation.setNumberOfCharacters(fileInformation.getNumberOfCharacters() + StringUtils.getNumberOfCharacters(lineWithoutSpaces));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            throw new MyFileNotFoundException("The file has not been found!");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return fileInformation;
    }

}
