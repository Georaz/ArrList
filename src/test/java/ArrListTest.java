import org.example.ArrList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrListTest {

    @Test
    void givenEmptyList_whenAddElement_thenSizeIncreases() {
        // Given: an empty list
        ArrList<Integer> list = new ArrList<>();

        // When: elements are added
        list.add(1);
        list.add(7);
        list.add(4);

        // Then: the list size should increase
        assertEquals(3, list.size());
    }

    @Test
    void givenListWithElements_whenGetElement_thenCorrectElementReturned() {
        // Given: a list with elements
        ArrList<Integer> list = new ArrList<>();
        list.add(34);
        list.add(56);
        list.add(78);

        // When: an element is retrieved by index
        Integer element = list.get(2);

        // Then: the correct element should be returned
        assertEquals(78, element);
    }

    @Test
    void givenListWithElements_whenRemoveElement_thenCorrectElementRemoved() {
        // Given: a list with elements
        ArrList<Integer> list = new ArrList<>();
        list.add(567);
        list.add(23);
        list.add(60);

        // When: an element is removed by index
        Integer removedElement = list.remove(0);

        // Then: the correct element should be removed and size should decrease
        assertEquals(567, removedElement);
        assertEquals(2, list.size());
    }

    @Test
    void givenListWithElements_whenClear_thenListIsEmpty() {
        // Given: a list with elements
        ArrList<Integer> list = new ArrList<>();
        list.add(12);
        list.add(23);
        list.add(34);

        // When: the list is cleared
        list.clear();

        // Then: the list should be empty
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void givenEmptyList_whenGetElement_thenThrowsException() {
        // Given: an empty list
        ArrList<Integer> list = new ArrList<>();

        // When getting an element from an empty list
        // Then should be thrown an exception
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }
}