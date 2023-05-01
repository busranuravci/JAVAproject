package miniProjects.LoginPage;

import java.util.Scanner;
public class Runner {

    public static void main(String[] args) {

/*
Project: Design a page for registering and logging in to a website.
         menu: the user is shown a menu for action selection.
         register: get name, surname, username, email and password information from the user.
                             username, email and password are kept in a list.
                             same username or email is not accepted.
         login: enter username/email and password.
                       if the username or email is not found, a warning is given: not registered, sign up.
                       if the username/email and password registered in the same index are validated, the site is logged in.
         email validation: must not contain spaces
                         : must contain @
                         : must end with gmail.com, hotmail.com or yahoo.com.
                         : the username part of the mail (before @) can only contain uppercase and lowercase letters, numbers or -._ symbols.
         password validation: must not contain spaces
                            : must be at least 6 characters
                            : must contain at least one lowercase letter
                            : must contain at least one capital letter
                            : must contain at least one number
                            : must contain at least one symbol
 */


        start();



    }

    public static void start(){

        UserService userService = new UserService();

        Scanner sc= new Scanner(System.in);
        int select;

        do {
            userService.showMenu();
            select = sc.nextInt();

            switch (select){
                case 1:
                    userService.register();
                    break;
                case 2:
                    userService.login();
                    break;
                case 3:
                    System.out.println("GoodBye.");
                    break;

                default:
                    System.out.println("Please try again !");

            }

        }while (select!=3);



    }

}
