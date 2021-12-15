package ru.geekbrains.lesson2;

public class Test {
    public static void main(String[] args) {
        String[][] arr ={
                {"2", "5", "45", "7", "7"},
                {"2", "5", "45", "7"},
                {"2", "5", "45", "7"},
                {"2", "45", "7", "7"},

        };
        System.out.println(test(arr));
        System.out.println(isQuadratic(arr));

    }

    public static boolean isQuadratic(String[][] array) {
        for (String[] arr : array) {
            System.out.println(array.length);
            System.out.println(arr.length);
            if ( array.length != arr.length) {
                return false;
            }
        }
        return true;
    }



    public static boolean test(String[][] array) {
        for (int i = 0, j=0; i < array.length; i++, j++) {
            System.out.println(array.length);
            System.out.println(array[i].length);
            if (array.length != array[i].length) {
                return false;


//            for (int j = 0; j < array[j].length; j++) {
//                System.out.println(array.length);
//                System.out.println(array[i].length);
//                if (array.length != array[i].length) {
//                    return false;
//                }
            }
        }
        return true;
    }

}
