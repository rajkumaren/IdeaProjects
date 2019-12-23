package sorting;

public class BubbleSort1 {

//Compare adjacent elements and move the smallest one to the first


    public static void main(String[] args) {
        char a[] = {'5','1','4','2','8'};

        for(int iteration = 0;iteration<a.length;iteration++){
            for(int index=0;index<a.length-1;index++){
                if(a[index]>a[index+1]){
                    System.out.print(a);
                    System.out.print(" -> ");
                    a = swap(a,index,index+1);
                }

                System.out.println(a);
            }
        }



    }


    private static char[] swap(char[] a, int i, int j){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return a;
    }

}
