package de.eberln.algodat.tree.avl;

import de.eberln.algodat.tree.BinaryNode;

public class AVLNode<T extends Comparable<? super T>> extends BinaryNode<T> {
    
    public int heigth;

    public AVLNode(T value) {

        super(value);
        heigth = 0;

    }

    public int leftHeight() {
        if(leftChild == null) {
            return -1;
        }else{
            return getLeftChild().heigth;
        }
    }

    public int rightHeight() {
        if(rightChild == null) {
            return -1;
        }else{
            return getRightChild().heigth;
        }
    }

    public int calculateBalance() {
        return leftHeight() - rightHeight();
    }

    public AVLNode<T> getRightChild() {
        return (AVLNode<T>) rightChild;
    }


    public AVLNode<T> getLeftChild() {
        return (AVLNode<T>) leftChild;
    }

}
