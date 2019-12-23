package basic;

public class TwoSum {
    public static void main(String[] args) {
        int sample[] = {3,5,9,8};
        int target = 13;
        for(int i=0;i<sample.length;i++){
            for(int j=i+1;j<sample.length;j++){
                if(sample[i]+sample[j]==target){
                    System.out.println("Indexes are : "+i+"  "+j);
                }
            }

        }
    }
}
