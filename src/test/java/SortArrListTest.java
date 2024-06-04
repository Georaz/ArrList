import org.example.ArrList;
import org.example.SortArrList;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SortArrListTest {

    @Test
    void givenUnsortedList_whenQuickSort_thenListIsSorted() {
        // Given: an unsorted list
        ArrList<Integer> list = new ArrList<>();
        list.add(456);
        list.add(23);
        list.add(1);
        list.add(789);
        list.add(2370);
        list.add(12);

        // When: the list is sorted using quicksort
        SortArrList.quickSort(list);

        // Then: the list should be sorted in ascending order
        assertEquals(1, list.get(0));
        assertEquals(12, list.get(1));
        assertEquals(23, list.get(2));
        assertEquals(456, list.get(3));
        assertEquals(789, list.get(4));
        assertEquals(2370, list.get(5));
    }

    @Test
    void givenUnsortedListWithComparator_whenQuickSort_thenListIsSorted() {
        // Given: an unsorted list with a custom comparator
        ArrList<String> list = new ArrList<>();
        list.add("Asia");
        list.add("Europe");
        list.add("South America");
        list.add("North America");
        list.add("Australia");
        list.add("Africa");

        // When: the list is sorted using quicksort with a natural order comparator
        SortArrList.quickSort(list, Comparator.naturalOrder());

        // Then: the list should be sorted in ascending order
        assertEquals("Africa", list.get(0));
        assertEquals("Asia", list.get(1));
        assertEquals("Australia", list.get(2));
        assertEquals("Europe", list.get(3));
        assertEquals("North America", list.get(4));
        assertEquals("South America", list.get(5));
    }
}