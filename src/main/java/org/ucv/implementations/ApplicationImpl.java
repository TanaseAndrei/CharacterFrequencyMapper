package org.ucv.implementations;

import org.ucv.exceptions.MyFileNotFoundException;
import org.ucv.interfaces.Analyzer;
import org.ucv.interfaces.Application;
import org.ucv.interfaces.FileInformationResolver;
import org.ucv.utils.MapPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ApplicationImpl implements Application {

    private FileInformation fileInformation;
    private FileInformationResolver fileInformationResolver;
    private Analyzer<Character, Integer> analyzer;
    private boolean isRunning;

    public ApplicationImpl(){
        isRunning = false;
    }

    public void start(){
        extractFileData();
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int option = 0;
        isRunning = true;
        while(isRunning){
            System.out.println("1 for nominal values, 2 for percentage values, 3 to exit the program.");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    NominalCharacterFrequencyImpl nominalCharacterFrequency = new NominalCharacterFrequencyImpl(fileInformation);
                    analyzer = new AnalyzerImpl<>(nominalCharacterFrequency);
                    MapPrinter.print(analyzer.analyze());
                    break;
                case 2:
                    PercentageCharacterFrequencyImpl percentageCharacterFrequency = new PercentageCharacterFrequencyImpl(fileInformation);
                    analyzer = new AnalyzerImpl<>(percentageCharacterFrequency);
                    MapPrinter.printPercentage(analyzer.analyze());
                    break;
                case 3: isRunning = false;
                    break;
                default:
                    System.out.println("Enter a value from 1 to 3!");
                    break;
            }
        }
    }

    private void extractFileData(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = false;
        while(!flag){
            try{
                System.out.println("Enter the absolute path to the desired text file!");
                String filePath = bufferedReader.readLine();
                fileInformationResolver = new FileInformationResolverImpl(filePath);
                fileInformation = fileInformationResolver.extractData();
                flag = true;
            } catch(IOException ioException){
                System.err.println("An error has occured while trying to enter the data, please rewrite!");
                flag = false;
            } catch(MyFileNotFoundException myFileNotFoundException){
                flag = false;
            }
        }
    }

}
