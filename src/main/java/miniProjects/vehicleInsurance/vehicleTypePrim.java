package miniProjects.vehicleInsurance;

import java.util.Scanner;

public class vehicleTypePrim {

    public String type;
    public int prim;



    public void countPrim(int term) {

        switch (this.type) {

            case "automobile" :
                this.prim = term==1 ? 2000 : 2500;
                break;

            case "truck" :
                this.prim = term==1 ? 3000 : 3500;
                break;

            case "motorcycle" :
                this.prim = term==1 ? 1500 : 1750;
                break;

            case "bus" :
                countPrimBus(term);
                break;

            default:
                System.out.println("Invalid entry!!");
                this.prim = 0;
                break;

        }
    }
    public void countPrimBus(int term){

        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter the bus type: ");
        System.out.println("1- between 18-30 seats");
        System.out.println("2- over 30 seats");
        int busType = sc.nextInt();

        switch (busType){
            case 1:
                this.prim = term==1 ? 4000 : 4500;
                break;

            case 2:
                this.prim = term==1 ? 5000 : 5500;
                break;

            default:
                System.out.println("Invalid entry !!");
                this.prim = 0;
                break;
        }
    }
}
