package recursionproject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pandra3
 * Peyton Andras
 * LSU ID: 894914572
 */
public class Utilities {
    
    public static long recursiveFib(int n){
        if (n<=2)
            return 1;
        else 
            return recursiveFib(n-1) + recursiveFib(n-2);  
    }
    
    public static long iterativeFib(int n){
        if(n<=2)
            return 1;
        else{
            long olderValue = 1;
            long oldValue = 1;
            long newValue = 0;
            
            for(int i =3; i<= n; i++){
             newValue = olderValue + oldValue;
             olderValue = oldValue;
             oldValue = newValue;
            }       
            return newValue;
        }       
    }
}
