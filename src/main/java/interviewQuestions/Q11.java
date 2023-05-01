package interviewQuestions;

public class Q11 {

    public static void main(String[] args) {


        for (int row = 1; row <=7 ; row++) {
            for (int s = 1; s <=15 ; s++) {
                if (row == 1 && (s == 3 || s == 4 || s == 5 || s == 10 || s == 11 || s == 12) ||
                        row == 2 && (s == 2 || s == 7 || s == 9 || s == 14) ||
                        row == 3 && (s == 1 || s == 8 || s == 15) ||
                        row == 4 && (s == 2 || s == 14) ||
                        row == 5 && (s == 4 || s == 12) ||
                        row == 6 && (s == 6 || s == 10) ||
                        row == 7 && (s == 8)
                ) {
                    System.out.print("*");

                } else System.out.print(" ");
            } System.out.println();


        }


    }
}

/*
 3.4.5.|| 10.11.12
 2 || 7.9 ||14
 1 ||8||15
 2||14
 4||12
 6 ||10
 8
 */