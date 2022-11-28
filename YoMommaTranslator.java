/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package yomommatranslator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author pandra3
 * Peyton Andras
 * 894914572
 * 
 */
public class YoMommaTranslator {

    public static void main(String[] args) throws FileNotFoundException{
        TreeMap<String, String> acronymsMap = new TreeMap<>();
        
        //load acronyms and their meanings from file
        
        File input = new File("acronyms.txt");
        Scanner fileInput = new Scanner(input);
        
        String line;
        
        while(fileInput.hasNextLine()){
            line = fileInput.nextLine();
            String[] splitted = line.split("\\t");
            acronymsMap.put(splitted[0].toLowerCase(), splitted[1].toLowerCase());
        }
        //take user input and split into an array
        System.out.println("Please enter sentence:");
        Scanner in = new Scanner(System.in).useDelimiter("\\n");
        String userInput = in.next();
        String[] split = userInput.split("\\s+");
        
        //read user input and compare to map 
        int i;
        for(i = 0; i<split.length; i++){
            if(acronymsMap.containsKey(split[i].toLowerCase())) {
                System.out.print(acronymsMap.get(split[i].toLowerCase()).toLowerCase() + " ");                
            }
            else{
                System.out.print(split[i] + " ");
            }
        } 

        
        
 }
}
