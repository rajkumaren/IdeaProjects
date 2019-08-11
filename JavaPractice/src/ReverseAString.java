public class ReverseAString {

    public static void main(String[] args) {
        ReverseAString reverseAString = new ReverseAString();
        reverseUsingChar("abc");
        System.out.println(reverseAString.reverseUsingChar("abc"));
    }

    private String reverseUsingStringBuilderAPI(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        return stringBuilder.toString();

    }


    private String reverseUsingStringBuilder(String str){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<str.length();i++){
            stringBuilder.append(str.charAt(str.length()-i-1));
        }
        return stringBuilder.toString();
    }

    private static String reverseUsingChar(String str){
        int length = str.length();
        char[]  chars = str.toCharArray();
        char[] reverseChars = new char[chars.length];
        int index = 0;
        for(char c: chars){
            reverseChars[length-index-1]=c;
            index++;
        }
        return new String(reverseChars);
    }
}
