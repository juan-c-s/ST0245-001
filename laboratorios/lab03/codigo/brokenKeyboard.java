import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

import javax.sound.sampled.Line;

public class brokenKeyboard {

    public static String input = "This_is_a_[Beiju]_text\n [[]][][]Happy_Birthday_to_Tsinghua_University\n asd[fgh[jkl\n";


    public static void main(String[] args) {

        brokenKeyboard.readBrokenText(brokenKeyboard.input);
        // LinkedList<String> lineList = new LinkedList<>();
        // lineList.addLast("tomas");

        // System.out.println(Arrays.toString(lineList.toArray()));

        // Stack<Character> stack = new Stack<Character>();

        


    
    }

    public static void printer(LinkedList<String> lista){

        String finalString = "";

        for(String part: lista){

            finalString = finalString + part.trim();
        }

        System.out.println(finalString);

    }




    public static void  readBrokenText(String input){

        String[] inputList = input.split("\n");
 

        for(String line: inputList){

            int start = 0;
            int end = 0;
            Stack<Character> simbols = new Stack<>();
            LinkedList<String> lineList = new LinkedList<>();
            
            for(int tt = 0; tt < line.length();tt++){

                if(line.charAt(tt) == '[' || line.charAt(tt) == ']' || tt == line.length()-1){

                    if(tt == line.length()-1){end++;}

                    if(simbols.isEmpty()){
                        lineList.add(line.substring(start,end));
                        
                    }
                    if(!simbols.isEmpty() && simbols.peek() == ']'){
                        lineList.addLast(line.substring(start,end));
                    }
                    if(!simbols.isEmpty() && simbols.peek() == '['){
                        lineList.addFirst(line.substring(start,end));
                    }
                    simbols.add(line.charAt(tt));
                    end++;
                    start = end;

                }else{
                    end++;
                }

            }

            brokenKeyboard.printer(lineList);
           
            
        }

    }
    
}
