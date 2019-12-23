package sorting;

import java.util.Arrays;

public class BubbleSort {
    //Iterate thru the array and compare N and N+1 and move the largest to the right

    public static void main(String[] args) {
        int a[] = {5,24,4,1,20};
        bubbleSort(a, a.length);
    }

    private static void bubbleSort(int[] a, int length) {
        for(int i=0;i<length-2;i++){
            if(a[i] > a[i+1]){
                swap(a,i,i+1);
            }
            printArray(a);
        }

    }

    private static void printArray(int[] a) {
       Arrays.stream(a).forEach(System.out::print);
        System.out.println();
    }

    private static void swap(int[] a, int i, int i1) {
        int temp = a[i1];
        a[i1] = a[i];
        a[i] = temp;
    }
}
