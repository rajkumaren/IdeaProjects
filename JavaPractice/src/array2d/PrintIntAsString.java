package array2d;

public class PrintIntAsString {

    public static void main(String[] args) {

        int input = 12;
        convertToStmt(input);

    }

    private static void convertToStmt(int input){


        String[] strTerms = {"", "", "hundred and", "thousand",""};
        String[] strOnes = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] strTeens = {"Ten","Eleven", "Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] strTens = {"", "Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety","Hundred"};

        StringBuffer stringBuffer = new StringBuffer();

        int digits=0;
        int lastDigit;
        int number = input;
        while(input>0){
            lastDigit = input%10;
            input = input/10;
            System.out.println("Input : "+input+" Last Digit: " + lastDigit);
            if(digits==0){
                stringBuffer.insert(0,strOnes[lastDigit-0]);// (strOnes[lastDigit-0]);
            }/*if(digits==1){
                if()
            }*/
            digits++;
        }

        if(digits==1){
            System.out.println(strOnes[input]);
        }else if(digits==2 && number<20){
            System.out.println(strTeens[number-10]);
        }

        //System.out.println(stringBuffer.toString());

    }
}
