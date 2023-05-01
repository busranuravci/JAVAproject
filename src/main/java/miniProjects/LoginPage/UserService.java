package miniProjects.LoginPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    List<String> userNameList = new ArrayList<>();
    List<String> emailList = new ArrayList<>();
    List<String> passwordList = new ArrayList<>();


    public void showMenu(){

        System.out.println(" ----- LA CHAMP ------");
        System.out.println("1- Register");
        System.out.println("2- Login");
        System.out.println("3- Logout");
        System.out.println("Enter your selection: ");

    }

    public void register(){

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter full name");
        String name= sc.nextLine();


        String username;
        boolean existUsername;

        do {
            System.out.println("Enter username");
            username =sc.nextLine();
            existUsername = userNameList.contains(username);

            if (existUsername){
                System.out.println("This username has been used before. Try again");
            }

        }while (existUsername);



        String email;
        boolean existEmail;
        boolean isValid;

        do {

            System.out.println("Enter e-mail");
            email = sc.nextLine();
            isValid = validateEmail(email);

            existEmail = emailList.contains(email);
            if (existEmail){
                System.out.println("This e-mail has been used before. Try again");
                isValid =false;
            }


        }while (!isValid);

        //---------------------------------------------------------//

        String password;
        boolean isValidPassword;


        do {

            System.out.println("Enter password");
            password = sc.nextLine();
            isValidPassword = validatePassword(password);



        }while (!isValidPassword);

        User user = new User(name,username,email,password);
        System.out.println(user);

        userNameList.add(username);
        emailList.add(email);
        passwordList.add(password);
        System.out.println("Registration has been successfully completed!");
        System.out.println("You can login with username or Email");


    }

    public void login(){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter username or Email");
        String userLogin = input.nextLine();

        boolean isEmail = emailList.contains(userLogin);
        boolean isUsername = userNameList.contains(userLogin);

        if (isEmail || isUsername) {

            while (true) {
                System.out.println("Enter password");
                String psw = input.nextLine();

                int idx;
                if (isUsername){
                    idx = userNameList.indexOf(userLogin);

                }else{
                    idx = emailList.indexOf(userLogin);
                }

                if (passwordList.get(idx).equals(psw)) {
                    System.out.println("Successful!");
                    break;

                }else{
                    System.out.println("Wrong password. Try again !");
                }

            }

        }else{
            System.out.println("No registered user found.");
            System.out.println("Check your information or register.");
        }

///-------------------------------------------------------------------------------------//

    }


    public static boolean validateEmail (String email){

        boolean isValid;

        boolean space = email.contains(" ");
        boolean isContainAt = email.contains("@");

        if (space){
            System.out.println("Email should not contain spaces.");
            isValid = false;

        } else if (!isContainAt) {
            System.out.println("Email should contains '@' ");
            isValid = false;

        }else{

            String firstPart = email.split("@") [0];
            String secondPart = email.split("@") [1];

            boolean checkFirst = firstPart.replaceAll("[A-Za-z0-9.-_]","").length()==0;
            boolean checkSecond = secondPart.equals("gmail.com") ||
                    secondPart.equals("yahoo.com") ||
                    secondPart.equals("hotmail.com");

            if (!checkFirst){
                System.out.println("Email cannot contain upper/lower case letters, numbers or characters other than -._ characters");

            } else if (!checkSecond) {
                System.out.println("Email contains yahoo.com/ gmail.com/hotmail.com");
            }

            isValid = checkFirst && checkSecond;

        }

        return isValid;
    }

    public static boolean validatePassword(String password){
        boolean isValid;

        boolean space = password.contains(" ");
        boolean length6 = password.length()>5;  // >=6
        boolean existUpper = password.replaceAll("[^A-Z]","").length()>0;
        boolean existLower = password.replaceAll("[^a-z]","").length()>0;
        boolean existDigit = password.replaceAll("[^0-9]","").length()>0;
        boolean existSymbol = password.replaceAll("[\\P{Punct}]","").length()>0;

        if (space) {
            System.out.println("Password cannot contain spaces");

        } else if (!length6) {
            System.out.println("The password must be at least 6 characters.");

        } else if (!existUpper) {
            System.out.println("Password must contain at least 1 capital letter");

        } else if (!existLower) {
            System.out.println("Password must contain at least 1 lowercase letter");

        } else if (!existDigit) {
            System.out.println("Password must contain at least 1 digit");

        } else if (!existSymbol) {
            System.out.println("Password must contain at least 1 symbol");
        }

        isValid = !space && length6 && existDigit && existLower && existUpper && existSymbol;

        return isValid;
    }
}
