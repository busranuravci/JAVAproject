package lambda;

public class Lambda_Util {

    public static int getLengthSquare (String s){
        return s.length()*s.length();

    }


    public static boolean isLengthEven(String s){
        return s.length()%2 ==0;



    }


    public static String getLastChar (String s){

        return s.substring(s.length()-1);



    }


    public static void printSameLineWithSpace (Object obj){

        System.out.println(obj + " ");
    }

    public static boolean isNumberEven(int x){
        return x%2 ==0;

    }

    public static int getSumOfDigit(int x){

        int sum=0;
        while (x!=0){

            sum = sum + x%10;
            x= x / 10;

        }
        return sum;
    }



}
