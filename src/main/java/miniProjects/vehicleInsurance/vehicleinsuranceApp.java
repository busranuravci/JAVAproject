package miniProjects.vehicleInsurance;

import java.util.InputMismatchException;
import java.util.Scanner;

public class vehicleinsuranceApp {
    /*
    Project: Car Insurance Premium Calculator
       Vehicle types:car, truck, bus, motorcycle
                    -bus 18-30 seats or 31 or more seats
       T. period:December 2022,June 2022
       1st semester: June 2022 2nd semester: December 2022
          automobile: 2000 automobile: 2500
          Truck:   3000 trucks:   3500
          bus: type1: 4000 type2: 5000 bus: type1: 4500 type2: 5500
          motorcycle: 1500 motorcycles: 1750
      >>>  In case of incorrect input, the calculation fails and the menu is displayed again.  <<<
     */

    public static void main(String[] args) {

        start();

    }

    public static void start(){

        Scanner sc = new Scanner(System.in);
        boolean isFail;

        do {
            isFail = false;
            System.out.println("--- Insurance Calculation---");
            System.out.println("Select tariff period:");
            System.out.println("1.Term : June 2022");
            System.out.println("2.Term : December 2022");

            int term = 0;
            try {
                term = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Invalid entry.");
            }
            sc.nextLine();    // dummy


            if (term == 1 || term == 2) {
                vehicleTypePrim vehicle = new vehicleTypePrim();
                String termName = term==1 ? "June 2022" : "December 2022" ;

                System.out.println("Enter vehicle type. Cars, trucks, motorcycles, buses : ");
                String select = sc.next();
                vehicle.type = select;
                vehicle.countPrim(term);

                if (vehicle.prim >0) {

                    System.out.println("The calculation was completed successfully.");
                    //result;
                    System.out.println("Vehicle type : " + vehicle.type);
                    System.out.println("Term period : " + termName);
                    System.out.println("Your vehicle insurance prim: " + vehicle.prim);

                }else {
                    System.out.println("Calculation failed! Enter the selections correctly again.");

                    System.out.println("Enter 1 to make a new transaction and 0 to exit");
                    int choice = sc.nextInt();
                    if (choice == 1)
                        isFail = true;
                    else
                        isFail = false;

                }

            }else{
                System.out.println("Incorrect entry !!! Please select 1 or 2.");
                isFail = true;
            }

        }while (isFail);
        System.out.println("Have a good day ! :) ");
    }
}
