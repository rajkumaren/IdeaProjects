package com.formatter;

import java.util.Scanner;

public class JsonFormatter {


    public static void main(String args[]){

        //Read the Raw Input
        //Validate the JSON
        //Identify the JSON issue if exists
        //Format the JSON
        //Return with Format

        JsonFormatter formatter = new JsonFormatter();
        String inputJson = formatter.readJsonFromUser();
        int pos = formatter.validateJson();
        if(pos==-1){
            formatter.printFormattedJson(formatter.addFormatting(inputJson));

            return;
        }


    }

    private void printFormattedJson(String output) {
        System.out.println(output);
    }

    private String addFormatting(String inputJson) {
        StringBuffer output = new StringBuffer();
        //Rules for adding format
        // { - New line and tab
        // } - new line and backward tab
        // , - Just new line
        char prevChar;
        for(char a : inputJson.toCharArray()){




            switch(a){
                case '{' :
                    output.append("{\n\t");
                    break;
                case '}' :
                    output.append("}\n");
                    break;
                case ',' :
                    output.append(","+"\n");
                    break;
                case ':' :
                    break;
            }
        }
        return output.toString();

    }

    private int validateJson() {
        //Rules for Validation
        //1* - Always starts and ends with Flower brackets
        //1 - No of Opening and Closing braces and brackets should be same
        //2 - No of single quotes and double quotes should be same
        //3 - String should be enclosed with quotes
        //4 - Numbers may or may not be enclosed with quotes
        //5 - true/false may or may not be enclosed with quotes
        return -1;
    }

    private String readJsonFromUser() {
        Scanner scanner = new Scanner(System.in);
        StringBuffer stringBuffer = new StringBuffer();
        String input = scanner.next();
        while(!input.equals("end")){
            stringBuffer.append(input);
            input = scanner.next();
        }
        System.out.println(stringBuffer);
        return stringBuffer.toString();
    }

}
