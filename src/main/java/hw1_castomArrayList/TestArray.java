package hw1_castomArrayList;

import java.util.Comparator;

public class TestArray {
    public static void main(String[] args) {
        MyArrayList<String> strings = new MyArrayList<>();
        strings.add(0, "2");
        strings.add(1, "3");
        strings.add(2, "4");
        strings.add(3, "5");
        strings.add(4, "10");
        strings.add(5, "8");
        strings.add(6, "4");
        strings.add(7, "1");

        MyArrayList<String> strings1 = new MyArrayList<>();
        strings1.add(0, "2");
        strings1.add(1, "3");
        strings1.add(2, "4");
        strings1.add(3, "5");
        strings1.add(4, "10");
        strings1.add(5, "8");
        strings1.add(6, "4");
        strings1.add(7, "1");




        strings.mergeSort(Comparator.naturalOrder());
        strings.addAll(strings1);

    }

}
