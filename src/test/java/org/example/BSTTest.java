package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {
    BST<Character> test;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        test = new BST();
        test.add('D');
        test.add('B');
        test.add('F');
        test.add('A');
        test.add('C');
        test.add('E');
        test.add('H');
        test.add('G');
        test.add('I');
    }

    @org.junit.jupiter.api.Test
    void getRoot() {
        assertEquals('D', test.getRoot().getData());
    }

    @org.junit.jupiter.api.Test
    void getHeight() {
        assertEquals(test.getHeight(), 4);
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(test.size(), 9);
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertFalse(test.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        test.clear();
        assertTrue(test.isEmpty());
        assertNull(test.getRoot());
    }

    @org.junit.jupiter.api.Test
    void contains() {
        assertTrue(test.contains('D'));
        assertFalse(test.contains('Z'));
    }

    @org.junit.jupiter.api.Test
    void search() {
        assertEquals(test.search('I').getData(), 'I');
        assertNull(test.search('Z'));
    }

    @org.junit.jupiter.api.Test
    void add() {
        assertTrue(test.add('Z'));
        assertTrue(test.contains('Z'));
    }

    @org.junit.jupiter.api.Test
    void removeMin() {
        test.removeMin();
        assertFalse(test.contains('A'));
    }

    @org.junit.jupiter.api.Test
    void removeMax() {
        test.removeMax();
        assertFalse(test.contains('I'));
    }

    @org.junit.jupiter.api.Test
    void inorderIterator() {
        Character[] in = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        int counter = 0;
        Iterator it = test.inorderIterator();
        while (it.hasNext())
        {
            assertEquals(it.next(), in[counter++]);
        }

    }

    @org.junit.jupiter.api.Test
    void preorderIterator() {
        Character[] in = {'D', 'B', 'A', 'C', 'F', 'E', 'H', 'G', 'I'};
        int counter = 0;
        Iterator it = test.preorderIterator();
        while (it.hasNext())
        {
            assertEquals(it.next(), in[counter++]);
        }
    }

    @org.junit.jupiter.api.Test
    void postorderIterator() {
        Character[] in = {'A', 'C', 'B', 'E', 'G', 'I', 'H', 'F', 'D'};
        int counter = 0;
        Iterator it = test.postorderIterator();
        while (it.hasNext())
        {
            assertEquals(it.next(), in[counter++]);
        }
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        test.clear();
    }
}