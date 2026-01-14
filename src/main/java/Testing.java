import model.Character;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
//        int[4] myInteger = {16, 25, 75, 13, 7};
//        System.out.println(myInteger[4]);


        ArrayList<Integer> myInteger = new ArrayList<Integer>();

        myInteger.add(16);
        myInteger.add(25);
        myInteger.add(75);
        myInteger.add(13);
        myInteger.add(7);

        int foundNumber16 = myInteger.stream().filter(p -> p == 16).toList().getFirst();

        System.out.println(foundNumber16);
    }
}
