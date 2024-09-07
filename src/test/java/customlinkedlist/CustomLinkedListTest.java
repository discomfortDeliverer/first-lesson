package customlinkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.discomfortDeliverer.customlinkedlist.CustomLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomLinkedListTest {
    @Test
    public void testAddEmptyList() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        assertEquals(1, list.size());
        assertEquals(10, (int) list.get(0));
    }

    @Test
    public void testAddMultipleElements() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(3, list.size());
        assertEquals(10, (int) list.get(0));
        assertEquals(20, (int) list.get(1));
        assertEquals(30, (int) list.get(2));
    }

    @Test
    public void testAddNullElement() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(null);
        assertEquals(1, list.size());
        assertNull(list.get(0));
    }

    @Test
    public void testAddDifferentTypes() {
        CustomLinkedList<Object> list = new CustomLinkedList<>();
        list.add(10);
        list.add("Hello");
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals("Hello", list.get(1));
    }

    @Test
    public void testAddLargeNumberOfElements() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(100, list.size());
        for (int i = 0; i < 100; i++) {
            assertEquals(i, (int) list.get(i));
        }
    }

    @Test
    public void testGetFromEmptyList() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        try {
            list.get(0);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected
        }
    }

    @Test
    public void testGetValidIndex() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        list.add(20);
        assertEquals(10, (int) list.get(0));
        assertEquals(20, (int) list.get(1));
    }

    @Test
    public void testGetInvalidIndex() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        try {
            list.get(1);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected
        }
    }

    @Test
    public void testGetNullElement() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(null);
        assertNull(list.get(0));
    }

    @Test
    public void testGetLargeList() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (int i = 0; i < 100; i++) {
            assertEquals(i, (int) list.get(i));
        }
    }

    @Test
    public void testRemoveFromEmptyList() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        try {
            list.remove(0);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected
        }
    }

    @Test
    public void testRemoveHead() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        list.add(20);
        assertEquals(10, (int) list.remove(0));
        assertEquals(1, list.size());
        assertEquals(20, (int) list.get(0));
    }

    @Test
    public void testRemoveTail() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        list.add(20);
        assertEquals(20, (int) list.remove(1));
        assertEquals(1, list.size());
        assertEquals(10, (int) list.get(0));
    }

    @Test
    public void testRemoveMiddle() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(20, (int) list.remove(1));
        assertEquals(2, list.size());
        assertEquals(10, (int) list.get(0));
        assertEquals(30, (int) list.get(1));
    }

    @Test
    public void testRemoveInvalidIndex() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        try {
            list.remove(1);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected
        }
    }

    @Test
    public void testContainsInEmptyList() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        assertFalse(list.contains(10));
    }

    @Test
    public void testContainsExistingElement() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        assertTrue(list.contains(10));
    }

    @Test
    public void testContainsNonExistingElement() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        assertFalse(list.contains(20));
    }

    @Test
    public void testContainsNullElement() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(null);
        assertTrue(list.contains(null));
    }

    @Test
    public void testContainsLargeList() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (int i = 0; i < 100; i++) {
            assertTrue(list.contains(i));
        }
    }

    @Test
    public void testAddAllEmptyList() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        List<Integer> toAdd = new ArrayList<>();
        list.addAll(toAdd);
        assertEquals(0, list.size());
    }

    @Test
    public void testAddAllValidList() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        List<Integer> toAdd = Arrays.asList(10, 20, 30);
        list.addAll(toAdd);
        assertEquals(3, list.size());
        assertEquals(10, (int) list.get(0));
        assertEquals(20, (int) list.get(1));
        assertEquals(30, (int) list.get(2));
    }

    @Test
    public void testAddAllNullList() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        List<Integer> toAdd = null;
        try {
            list.addAll(toAdd);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            // Expected
        }
    }

    @Test
    public void testAddAllLargeList() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        List<Integer> toAdd = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            toAdd.add(i);
        }
        list.addAll(toAdd);
        assertEquals(100, list.size());
        for (int i = 0; i < 100; i++) {
            assertEquals(i, (int) list.get(i));
        }
    }
}
