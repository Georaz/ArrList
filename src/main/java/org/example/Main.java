package org.example;

public class Main {
    public static void main(String[] args) {

        ArrList<Integer> arrList = new ArrList<>();
        Integer[] arr = new Integer[] {777, 888, 999};

        arrList.add(12);
        arrList.add(23);
        arrList.add(10);
        arrList.add(456);
        for(int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
        }
        System.out.println("--- Added 4 elements to the list ---");

        arrList.addAll(arr);
        for(int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
        }
        System.out.println("--- Added an array to the list ---");

        arrList.add(2, 1256);
        for(int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
        }
        System.out.println("--- Added an element 1256 by index 2 ---");

        arrList.remove(arrList.size() - 1);
        arrList.remove(arrList.size() - 1);
        for(int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
        }
        System.out.println("--- Remove two last elements by index ---");

        arrList.clear();
        if (arrList.isEmpty()) {
            System.out.println("ArrList is empty");
        } else {
            System.out.println("ArrList is not empty");
        }
    }
}