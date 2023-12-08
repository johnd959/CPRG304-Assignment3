package org.example;


public class Main {
    public static void main(String[] args) {
        BST<Integer> test = new BST();
        test.add('D');
        test.add('B');
        test.add('F');
        test.add('A');
        test.add('C');
        test.add('E');
        test.add('H');
        test.add('G');
        test.add('I');
        System.out.println("Height" + test.getHeight());
        Iterator it = test.postorderIterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        System.out.println(test.contains('A'));
        System.out.println(test.search('B').getData());
    }
}