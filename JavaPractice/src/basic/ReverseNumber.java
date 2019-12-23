package basic;


    public class ReverseNumber {
        public static void main(String[] args) {
            int test = 964632435;
            int test1 = test*10;
            System.out.println(test*10);



            int num = 1534236469;
            int reversed = 0;
            while(num != 0) {
                int digit = num % 10;
                if((reversed*10)>Integer.MAX_VALUE) {
                    reversed = 0;
                    System.out.println("Reversed Number1: " + reversed);
                    return;
                }
                reversed = reversed * 10 + digit;

                num /= 10;
            }
            System.out.println("Reversed Number: " + reversed);
        }
}
