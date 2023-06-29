package de.eberln.algodat.tree;

import java.util.function.Consumer;

public class BinaryNode<T extends Comparable<? super T>> {
    
    private T value;
    public BinaryNode<T> leftChild;
    public BinaryNode<T> rightChild;

    public BinaryNode(T v) {
        value = v;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T v) {
        value = v;
    }

    public String toString() {
        return desc(this, "", "", "");
    }

    // Inspired by Knuth
    private String desc(BinaryNode<T> node, String top, String root, String bottom) {
        if (node == null) return root + "null\n";

        if ((node.leftChild == null) && (node.rightChild == null))
            return root + node.value + "\n";

        return desc(node.rightChild,
                top + " ",
                top + "┌──",
                top + "│ ") +
                root + node.value + "\n" +
                desc(node.leftChild,
                        bottom + "| ",
                        bottom + "└──",
                        bottom + " ");
    }

    // #####     #####    #####     #####     #####     #####     #####     #####
    //      #####     #####    #####     #####     #####     #####     #####
    // #####    #####     #####     #####     #####     #####     #####     #####

    void traversalPreOrder(Consumer<BinaryNode<T>> visit)
    {
        visit.accept(this);
        if (leftChild != null) leftChild.traversalPreOrder(visit);
        if (rightChild != null) rightChild.traversalPreOrder(visit);
    }

    void traversalInOrder(Consumer<BinaryNode<T>> visit)
    {
        if (leftChild != null) leftChild.traversalInOrder(visit);
        visit.accept(this);
        if (rightChild != null) rightChild.traversalInOrder(visit);

    }

    void traversalPostOrder(Consumer<BinaryNode<T>> visit)
    {
        if (leftChild != null) leftChild.traversalPostOrder(visit);
        if (rightChild != null) rightChild.traversalPostOrder(visit);
        visit.accept(this);
    }

}