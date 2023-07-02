package pro.sky;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StringListImplTest {
    private StringList stringList;

    @BeforeEach
    void init () {
        stringList = new StringListImpl();
    }
    @Test
    void add() {
        assertEquals("cat", stringList.add("cat"));
        assertThrows(NullPointerException.class, () -> stringList.add(null));
    }

    @Test
    void addWithIndex() {
        assertEquals("cat", stringList.add(3, "cat"));
        assertThrows(NullPointerException.class, () -> stringList.add(3,null));
    }

    @Test
    void set() {
        stringList.add("cat");
        assertEquals("dog", stringList.set(0, "dog"));
        assertThrows(NoElementAtSuchIndexException.class, () -> stringList.set(1, "cow"));
    }

    @Test
    void remove() {
        stringList.add("cat");
        stringList.add("dog");
        stringList.add("cow");
        assertThrows(NoSuchItemException.class, () -> stringList.remove("horse"));
        assertEquals("dog", stringList.remove("dog"));
        assertEquals(2, stringList.size());
    }

    @Test
    void RemoveByIndex() {
        stringList.add("cat");
        stringList.add("dog");
        stringList.add("cow");
        assertEquals("dog", stringList.remove(1));
        assertEquals(2, stringList.size());

    }

    @Test
    void contains() {
        stringList.add("cat");
        assertTrue(stringList.contains("cat"));
        assertFalse(stringList.contains("dog"));
    }

    @Test
    void indexOf() {
        stringList.add("cat");
        stringList.add("dog");
        stringList.add("cow");
        assertEquals(2, stringList.indexOf("cow"));
        assertEquals(-1, stringList.indexOf("snake"));
    }

    @Test
    void lastIndexOf() {
        stringList.add("cat");
        stringList.add("dog");
        stringList.add("cat");
        assertEquals(2, stringList.lastIndexOf("cat"));
        assertEquals(-1, stringList.lastIndexOf("snake"));
    }

    @Test
    void get() {
        stringList.add("cat");
        stringList.add("dog");
        stringList.add("cow");
        assertEquals("dog", stringList.get(1));
        assertThrows(NoSuchItemException.class, () -> stringList.get(6));

    }

    @Test
    void testEquals() {
        stringList.add("cat");
        StringList otherArray = new StringListImpl();
        otherArray.add("cat");
        assertTrue(stringList.equals(otherArray));
    }

    @Test
    void size() {
        stringList.add("cat");
        stringList.add("dog");
        assertEquals(2, stringList.size());
    }

    @Test
    void isEmpty() {
        stringList.add("cat");
        assertFalse(stringList.isEmpty());
    }

    @Test
    void clear() {
        stringList.add("cat");
        stringList.clear();
        assertTrue(stringList.isEmpty());
    }

    @Test
    void toArray() {
        stringList.add("cat");
        stringList.add("cat");
        String[] otherArray = {"cat", "cat"};
        assertArrayEquals(otherArray, stringList.toArray());
    }
}