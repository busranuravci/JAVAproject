package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Lambda02 {

    public static void main(String[] args) {


// EXP :: create a method to find the half of the elements greater than 5, distinct, reverse order "in a list."

        List<Double> myList = new ArrayList<>();
        myList.add(12.0);
        myList.add(4.0);
        myList.add(7.0);
        myList.add(3.6);
        myList.add(26.8);
        myList.add(26.8);
        myList.add(38.4);


        List<Double> half = getHalfOfElementsGreaterFiveDistinctReverse(myList);
        System.out.println(half);



        // EXP :: create a method to use with uppercase, sort and distinct (not add in list)

        List<String> list = new ArrayList<>();
        list.add("Cecil");
        list.add("Jim");
        list.add("Angelina");
        list.add("Tom");
        list.add("John");
        list.add("Tom");
        list.add("Brad");


        printAllAlphabeticallyUpperDistinct(list);



        // EXP :: create a method to use with lowercase , reverse order and distinct

        System.out.println();
        printAllAlphabeticallyLowerDistinct(list);



        // EXP :: Print all list elements in uppercase, in ascending order of length, without repetition

        System.out.println();
        printAllSortWithLengthUpperDistinct(list);



        // EXP :: Print all list elements in uppercase, in "descending order" according to their last letter, without repetition

        System.out.println();
        printAllSortWithLastCharUpperDistinct(list);
        System.out.println();
        printAllSortWithLastCharUpperDistinct2(list);



        // EXP :: Print all list elements in uppercase, in ascending order of length, without repetition
        //   Let elements of the same length be in alphabetical order

        System.out.println();
        printAllSortWithLengthUpperDistinctSameLengthsInAlphabeticalOrder(list);



        // EXP :: delete elements with more than 5 characters and put the rest in the list and print.

        System.out.println(removeElementIfTheLengthGreaterThanFive(list));



        // EXP :: Delete elements starting with "a" or ending with "d" (close the method of the problem above, the two will be mixed when printing this)


        System.out.println(removeElementIfStartsWithAorEndsWithd(list));



        // EXP :: square the character numbers of the elements and add them to the list

        System.out.println(printLenghtSquare(list));


        //EXP ::  the list elements with an even number of characters to the screen in a list

        System.out.println(printElementLengthEven(list));





    }

    public static List<Double> getHalfOfElementsGreaterFiveDistinctReverse (List<Double> myList){

        return myList.
                stream().
                distinct().
                filter(t->t>5).
                map(t->t/2).
                sorted(Comparator.reverseOrder()).
                        collect(Collectors.toList());



    }

    public static void  printAllAlphabeticallyUpperDistinct ( List<String> list){

        list.
                stream().
                distinct().
                map(String::toUpperCase).
                sorted().
                forEach(t-> System.out.print(t + " "));

    }


    public static void  printAllAlphabeticallyLowerDistinct ( List<String> list){

        list.
                stream().
                distinct().
                map(String::toLowerCase).
                sorted(Comparator.reverseOrder()).
                forEach(t-> System.out.print(t + " "));


    }



    public static void printAllSortWithLengthUpperDistinct(List<String>list){

        list.
                stream().
                distinct().
                map(String:: toUpperCase).
                sorted(Comparator.comparing(String::length)).
                forEach(t-> System.out.print(t + " "));
    }


    /// 1.way --
    public static void printAllSortWithLastCharUpperDistinct(List<String>list){

        list.
                stream().
                distinct().
                map(String::toUpperCase).
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).
                forEach(t-> System.out.print(t + " "));


    }

    ///2.way --
    public static void printAllSortWithLastCharUpperDistinct2(List<String>list){

        list.
                stream().
                distinct().
                map(String::toUpperCase).
                sorted(Comparator.comparing(Lambda_Util :: getLastChar).reversed()).
                forEach(Lambda_Util :: printSameLineWithSpace);


    }


    public static void printAllSortWithLengthUpperDistinctSameLengthsInAlphabeticalOrder(List<String>list){

        list.
                stream().
                distinct().
                map(String::toUpperCase).
                sorted(Comparator.comparing(String :: length).
                        thenComparing(Comparator.naturalOrder())).
                forEach( System.out :: println);

    }



    public static List<String> removeElementIfTheLengthGreaterThanFive (List<String>list){

        list.removeIf(t->t.length()>5);

        return list;


    }


    public static List<String>removeElementIfStartsWithAorEndsWithd(List<String>list) {


        list.removeIf(t -> t.startsWith("A") || t.endsWith("d"));
        return list.stream().distinct().collect(Collectors.toList());

    }



    public static List<Integer> printLenghtSquare (List<String> list) {


        return  list.
                stream().
                map(Lambda_Util :: getLengthSquare).
                collect(Collectors.toList());


    }



    public static List<String> printElementLengthEven (List<String> list){

        return list.stream().filter(Lambda_Util ::isLengthEven).collect(Collectors.toList());


    }


    }

