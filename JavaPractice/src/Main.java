public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String s = "Greeek";
        String s1 = "Greek";
        String sWithoutDuplicates = new Main().removeDuplicates(s);
        String s1WithoutDuplicates = new Main().removeDuplicates(s1);
        System.out.println("FInal String : "+new Main().removeDuplicates(s));
        System.out.println("FInal String : "+new Main().removeDuplicates(s1));
        System.out.println("They are " + (sWithoutDuplicates.equals(s1WithoutDuplicates) ? "Same" : "Different"));


    }


    private boolean compareOrder(String s1, String s2){
        return false;
    }

    private String removeDuplicates(String inputStr){
        if(inputStr!=null){
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(inputStr.charAt(0));
            for(int i = 1;i<inputStr.length();i++){
                System.out.println(inputStr.charAt(i-1)+" "+inputStr.charAt(i));
                if(inputStr.charAt(i-1)==inputStr.charAt(i)){
                    continue;
                }else{
                    System.out.println("adding "+inputStr.charAt(i));
                    stringBuffer.append(inputStr.charAt(i));
                }

            }
            return stringBuffer.toString();
        }else{
            return null;
        }
    }

}
