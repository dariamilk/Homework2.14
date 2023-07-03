package pro.sky;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class IntegerListImplTest {
    private IntegerList integerList;

    @BeforeEach
    void init () {
        integerList = new IntegerListImpl();
    }
    @Test
    void add() {
        assertEquals(5, integerList.add(5));
        assertThrows(NullPointerException.class, () -> integerList.add(null));
    }

    @Test
    void addWithIndex() {
        assertEquals(4, integerList.add(3, 4));
        assertThrows(NullPointerException.class, () -> integerList.add(3,null));
    }

    @Test
    void set() {
        integerList.add(5);
        assertEquals(1, integerList.set(0, 1));
        assertThrows(NoElementAtSuchIndexException.class, () -> integerList.set(1, (Integer) 6));
    }

    @Test
    void remove() {
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        assertThrows(NoSuchItemException.class, () -> integerList.remove((Integer) 4));
        assertEquals(1, integerList.remove((Integer) 1));
        assertEquals(2, integerList.size());
    }

    @Test
    void RemoveByIndex() {
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        assertEquals(2, integerList.remove(1));
        assertEquals(2, integerList.size());

    }

    @Test
    void contains() {
        integerList.add(1);
        integerList.add(7);
        integerList.add(96);
        assertTrue(integerList.contains(1));
        assertFalse(integerList.contains(22));
    }

    @Test
    void indexOf() {
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        assertEquals(2, integerList.indexOf(3));
        assertEquals(-1, integerList.indexOf(44));
    }

    @Test
    void lastIndexOf() {
        integerList.add(1);
        integerList.add(2);
        integerList.add(1);
        assertEquals(2, integerList.lastIndexOf(1));
        assertEquals(-1, integerList.lastIndexOf(11));
    }

    @Test
    void get() {
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        assertEquals(2, integerList.get(1));
        assertThrows(NoSuchItemException.class, () -> integerList.get(6));

    }

    @Test
    void testEquals() {
        integerList.add(1);
        IntegerList otherList = new IntegerListImpl();
        otherList.add(1);
        assertTrue(integerList.equals(otherList));
    }

    @Test
    void size() {
        integerList.add(11);
        integerList.add(22);
        assertEquals(2, integerList.size());
    }

    @Test
    void isEmpty() {
        integerList.add(22);
        assertFalse(integerList.isEmpty());
    }

    @Test
    void clear() {
        integerList.add(111);
        integerList.clear();
        assertTrue(integerList.isEmpty());
    }

    @Test
    void toArray() {
        integerList.add(22);
        integerList.add(33);
        Integer[] otherArray = {22, 33};
        assertArrayEquals(otherArray, integerList.toArray());
    }
}