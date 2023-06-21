package de.eberln.algodat.stack;

public class Main {
    
    public static void main(String[] args) {
        
        Stack<Integer> s = new ArrayStack<>();

        s.push(3);
        s.push(4);
        s.push(8);
        s.push(1);
        s.push(-55);
        s.push(45);
        s.push(44);
        s.push(34);

        s.print();

        System.out.println(s.peek());

        System.out.println(s.pop());

        System.out.println(s.pop());

        System.out.println(s.pop());

        s.push(3333);

        s.print();

    }

}
