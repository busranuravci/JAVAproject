package lambda;

import java.util.ArrayList;
import java.util.List;

public class Lambda01 {

    public static void main(String[] args) {




    //1)Create a method to print the list elements on the console in the "same line" with a space between two consecutive elements.(Structured--classical way--)

    List<Integer> nums = new ArrayList<>();

        nums.add(12);
        nums.add(9);
        nums.add(131);
        nums.add(14);
        nums.add(9);
        nums.add(10);
        nums.add(4);
        nums.add(12);
        nums.add(15);


    printElements1(nums);


        System.out.println();

    //2)Create a method to print the list elements on the console in the "same line" with a space between two consecutive elements.(Fuctional way)

    printElements2(nums);

        System.out.println();


    //3)Create a method to print the "even" list elements on the console in the "same line" with a space between two consecutive elements.(Structured)

    printEvenElements1(nums);

        System.out.println();


    //4)Create a method to print the "even" list elements on the console in the "same line" with a space between two consecutive elements.(Functional)

    printEvenElements2(nums);

        System.out.println();


    //5)Create a method to print the square of odd list elements on the console in the same line with a space between two consecutive elements

    SquareOfOddElements(nums);

        System.out.println();



    //6)Create a method to print the "cube" of "distinct" "odd" list elements on the console in the same line with a space between two consecutive elements.

    CubeOfDistinctOddElements(nums);

        System.out.println();



    //7)Create a method to calculate the "sum" of the "squares" of "distinct" "even" elements

    SumOfSquareOfDistinctEvenElements(nums);



    //8)Create a method to calculate the "product" of the "square" of "distinct" "even" elements

    ProductOfSquareOfDistinctElements(nums);



    //9)Create a method to find the "maximum value" from the list elements

    getMaxValue(nums);
    getMaxValue2(nums);



    //10)Create a method to find the "minimum value" from the list elements

    getMinValue(nums);
    getMinValue2(nums);


    // 11)   7 'den büyük en küçük çift sayıyı yazdır.

    getMinGraterThanSevenEven(nums);



}

    public static void printElements1(List<Integer> nums){

        for (Integer w: nums) {

            System.out.print(w +" ");

        }
    }


    public static void printElements2(List<Integer> nums){

        nums.stream().forEach(t -> System.out.print(t + " "));


    }


    public static void printEvenElements1(List<Integer> nums){

        for (Integer w: nums) {

            if (w %2==0) {
                System.out.print(w + " ");
            }
        }

    }

    public static void printEvenElements2(List<Integer> nums){

        nums.
                stream().
                filter(t->t%2==0).
                forEach(t-> System.out.print(t + " "));



    }



    public static void SquareOfOddElements (List<Integer> nums){

        nums.
                stream().
                filter(t->t%2!=0).
                map(t->t*t).
                forEach(t-> System.out.print(t + " "));


    }


    public static void CubeOfDistinctOddElements (List<Integer> nums){

        nums.
                stream().
                distinct().
                filter(t->t%2!=0).
                map(t->t*t*t).
                forEach(t-> System.out.print(t+ " "));


    }

    public static void SumOfSquareOfDistinctEvenElements (List<Integer> nums){

        Integer sum =  nums.
                stream().
                distinct().
                filter(t->t%2==0).
                map(t->t*t).
                reduce(0, Integer::sum);


        System.out.println(sum);
    }


    public static void ProductOfSquareOfDistinctElements (List<Integer> nums){

        Integer product = nums.
                stream().
                distinct().
                filter(t->t%2==0).
                map(t->t*t).
                reduce(1,(t,u)->t*u);

        System.out.println(product);
    }



    // 1. WAY :::
    public static void getMaxValue (List<Integer> nums){

        Integer maxResult = nums.
                stream().
                distinct().
                reduce(Integer.MIN_VALUE,(t,u)->t>u ? t : u);

        System.out.println(maxResult);


    }


    // 2. WAY :::

    public static void getMaxValue2 (List<Integer> nums) {

        Integer maxResult2 = nums.
                stream().
                distinct().
                sorted().
                reduce((t, u) -> u).
                get();

        System.out.println( maxResult2);


    }


    //1. WAY ::
    public static void getMinValue (List<Integer> nums) {

        Integer minResult = nums.
                stream().
                distinct().
                reduce(Integer.MAX_VALUE, (t, u) -> t > u ? u : t);

        System.out.println( minResult);
    }

    //2. WAY ::
    public static void getMinValue2 (List<Integer> nums) {

        Integer minResult2 = nums.
                stream().
                distinct().
                sorted().
                reduce((t, u) -> t).
                get();

        System.out.println( minResult2);

    }

    public static void getMinGraterThanSevenEven (List<Integer> nums) {

        Integer min7 =  nums.
                stream().
                filter(t -> t > 7 && t % 2 == 0).
                sorted().
                reduce((t, u) -> t).get();

        System.out.println( min7);


    }
}
