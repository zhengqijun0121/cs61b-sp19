import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class TestArrayDequeGold {
    @Test
    public void testAddFirst() {
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();

        for (int i = 0; i < 10; i++) {
            int random = StdRandom.uniform(100);
            ads.addLast(random);
            sad.addLast(random);
        }

        for (int i = 0; i < 10; i++) {
            Integer actual = ads.get(i);
            Integer expected = sad.get(i);
            assertEquals("Oh noooo!\nThis is bad in addLast():\n   Random number "
                         + actual + " not equal to " + expected + "!", expected, actual);
        }
    }

    @Test
    public void testAddLast() {
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();

        for (int i = 0; i < 10; i++) {
            int random = StdRandom.uniform(100);
            ads.addFirst(random);
            sad.addFirst(random);
        }

        for (int i = 0; i < 10; i++) {
            Integer actual = ads.get(i);
            Integer expected = sad.get(i);
            assertEquals("Oh noooo!\nThis is bad in addFirst():\n   Random number "
                         + actual + " not equal to " + expected + "!", expected, actual);
        }
    }

    @Test
    public void testRemoveFirst() {
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();

        for (int i = 0; i < 10; i++) {
            int random = StdRandom.uniform(100);
            ads.addFirst(random);
            sad.addFirst(random);
        }

        List<Integer> actualList = new ArrayList<>();
        List<Integer> expectedList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            actualList.add(ads.removeFirst());
            expectedList.add(sad.removeFirst());
        }

        for (int i = 0; i < 10; i++) {
            Integer actual = actualList.get(i);
            Integer expected = expectedList.get(i);
            assertEquals("Oh noooo!\nThis is bad in removeFirst():\n   Random number "
                         + actual + " not equal to " + expected + "!", expected, actual);
        }
    }

    @Test
    public void testRemoveLast() {
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();

        for (int i = 0; i < 10; i++) {
            int random = StdRandom.uniform(100);
            ads.addFirst(random);
            sad.addFirst(random);
        }

        List<Integer> actualList = new ArrayList<>();
        List<Integer> expectedList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            actualList.add(ads.removeLast());
            expectedList.add(sad.removeLast());
        }

        for (int i = 0; i < 10; i++) {
            Integer actual = actualList.get(i);
            Integer expected = expectedList.get(i);
            assertEquals("Oh noooo!\nThis is bad in removeLast():\n   Random number "
                         + actual + " not equal to " + expected + "!", expected, actual);
        }
    }
}
