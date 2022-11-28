/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interviewquestions;

import java.util.Stack;

/**
 *
 * @author pandra3
 * Peyton Andras
 * LSU ID: 894914572
 * 
 */
public class InterviewQuestions {
     
    public static void main(String[] args) {
        System.out.println(IsBalancedExpression("{}")); 
        System.out.println(IsBalancedExpression("({({)})}")); 
        System.out.println(IsBalancedExpression("({})")); 
        
        System.out.println(EvaluateExpression("5 4 5 * + 5 /"));
        System.out.println(EvaluateExpression("4 5 + 7 2 - *"));
    }
    
    public static boolean IsBalancedExpression(String input){
        char[] chars = input.toCharArray();
        Stack<Character> myStack = new Stack<>();
        
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '(' || chars[i] == '{')
                myStack.push(chars[i]);
            
            else if(chars[i] == ')' || chars[i] == '}'){
                if(myStack.isEmpty())
                    return false;
                char op = myStack.pop();
                
                if (op == '(' && chars[i] != ')' || op == '{' && chars[i] != '}')
                    return false;
            }
        }
        if(myStack.isEmpty())
            return true;
        
        return false;
    }
    
    public static double EvaluateExpression(String expression){
        char[] chars = expression.toCharArray();
        Stack<Integer> myStack = new Stack<>();
        
        for(int i = 0; i < chars.length; i++){
            if(Character.isDigit(chars[i]))
                myStack.push(Character.getNumericValue(chars[i]));
            else if(chars[i] == '+' || chars[i] == '-' || chars[i] == '/' || chars[i] == '*'){
                if(myStack.size()<2){
                    System.out.print("Expression is invalid");
                    return 0;
                }
                int num1 = myStack.pop();
                int num2 = myStack.pop();
                
                if(chars[i]=='+')
                    myStack.push(num1 + num2);
                else if (chars[i] == '-')
                    myStack.push(num2 - num1);
                else if(chars[i] == '/')
                    myStack.push(num2 / num1);
                else if (chars[i] == '*')
                    myStack.push(num1*num2);
                else{
                    System.out.print("Expression is invalid");
                    break;
                }
            }
        }
        if(myStack.size()>1){
            System.out.println("Expression is invalid");
            return 0;
        }
        return myStack.pop();
    }
}
