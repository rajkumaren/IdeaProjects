package convert;

import java.util.Arrays;

public class IntToBinary {


    public static void main(String[] args) {
        int i = 10;
        int arrSize = 10;
        int binary[] = new int[arrSize];
        int pointer = 0;
        while(i>0){
            if(i%2==0){
                binary[pointer++] = 0;

            }else{
                binary[pointer++] = 1;
            }
            i = i/2;
        }
        //Print array in reverse
        int j = arrSize-1;
        boolean startPos = false;
        while(j>=0){
            if(!startPos && binary[j]==1){
                startPos = true;
            }
            if(startPos){
                System.out.print(binary[j]);
            }
            j--;
        }

    }
}
