package org.example;

import java.util.Comparator;

/**
 * A class that provides a static method for sorting an ArrList using the quicksort.
 */
public class SortArrList {

    /**
     * Sorts the specified list into ascending order, according to the natural ordering of its elements.
     *
     * @param <E> the class of the objects in the list.
     * @param list is our ArrayList-like structure.
     */
    public static <E extends Comparable<? super E>> void quickSort(ArrList<E> list) {
        quickSort(list, Comparator.naturalOrder());
    }

    /**
     * Sorts the specified list according to the order induced by the specified comparator.
     *
     * @param <E> the class of the objects in the list.
     * @param list is our ArrayList-like structure.
     * @param comparator the comparator to determine the order of the list.
     */
    public static <E> void quickSort(ArrList<E> list, Comparator<? super E> comparator) {
        if (list.size() > 0) {
            quickSort(list, 0, list.size() - 1, comparator);
        }
    }

    /**
     *
     * @param list is our ArrayList-like structure.
     * @param from is the starting index of the current list of parts to be sorted.
     * @param to is the ending index of the current part of the list to be sorted.
     * @param comparator the comparator to determine the order of the list.
     * @param <E> the class of the objects in the list.
     */
    private static <E> void quickSort(ArrList<E> list, int from, int to, Comparator<? super E> comparator) {
        if (from < to) {
            int pivot = division(list, from, to, comparator);
            quickSort(list, from, pivot - 1, comparator);
            quickSort(list, pivot + 1, to, comparator);
        }
    }

    /**
     *
     * @param list is our ArrayList-like structure.
     * @param from is the starting index of the current list of parts to be sorted.
     * @param to is the ending index of the current part of the list to be sorted.
     * @param comparator the comparator to determine the order of the list.
     * @param <E> the class of the objects in the list.
     */
    private static <E> int division(ArrList<E> list, int from, int to, Comparator<? super E> comparator) {
        E pivot = list.get(to);
        int i = from - 1;
        for (int j = from; j < to; j++) {
            if (comparator.compare(list.get(j), pivot) <= 0) {
                i++;
                changeElements(list, i, j);
            }
        }
        changeElements(list, i + 1, to);
        return i + 1;
    }

    /**
     *
     * @param list is our ArrayList-like structure.
     * @param i is the first element to change.
     * @param j is the second element to change.
     * @param <E> the class of the objects in the list.
     */
    private static <E> void changeElements(ArrList<E> list, int i, int j) {
        E temp = list.get(i);
        list.elements[i] = list.get(j);
        list.elements[j] = temp;
    }
}