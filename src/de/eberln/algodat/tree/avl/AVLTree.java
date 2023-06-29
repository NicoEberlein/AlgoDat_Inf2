package de.eberln.algodat.tree.avl;

import java.io.File;

import de.eberln.algodat.tree.BSTree;
import de.eberln.algodat.tree.PiDigitScanner;

public class AVLTree<T extends Comparable<? super T>> extends BSTree<T> {
    
    public AVLTree()
    {
        root = null;
    }
    
    public AVLTree(T value)
    {
        root = new AVLNode<T>(value);
    }

    private AVLNode<T> getRoot() {
        return (AVLNode<T>) root;
    }
    
    private AVLNode<T> leftRotate(AVLNode<T> root) {

        AVLNode<T> pivot = (AVLNode<T>) root.rightChild;
        root.rightChild = pivot.leftChild;
        pivot.leftChild = root;

        root.heigth = hoehe(root);
        pivot.heigth = hoehe(pivot);

        return (AVLNode<T>) pivot;

    }

    private AVLNode<T> rightRotate(AVLNode<T> root) {

        AVLNode<T> pivot = (AVLNode<T>) root.leftChild;
        root.leftChild = pivot.rightChild;
        pivot.rightChild = root;

        root.heigth = hoehe(root);
        pivot.heigth = hoehe(pivot);

        return (AVLNode<T>) pivot;

    }

    private AVLNode<T> leftRightRotate(AVLNode<T> root) {
        if(root.getLeftChild() == null) return root;
        root.leftChild = leftRotate((AVLNode<T>) root.leftChild);
        return rightRotate(root);
    }

    private AVLNode<T> rightLeftRotate(AVLNode<T> root) {
        if(root.getRightChild() == null) return root;
        root.rightChild = rightRotate((AVLNode<T>) root.rightChild);
        return leftRotate(root);
    }

    @Override
    public void insertRec(T value) {
        root = insertRecPrv(getRoot(), value);
    }

    private AVLNode<T> insertRecPrv(AVLNode<T> node, T value) {

        if(value.compareTo(node.getValue()) >= 0) {
            // Insert right

            if(node.getRightChild() == null) {
                node.rightChild = new AVLNode<T>(value);
            }else{
                node.rightChild = insertRecPrv(node.getRightChild(), value);
            }

        }else{ // node > value
            // Insert left

            if(node.getLeftChild() == null) {
                node.leftChild = new AVLNode<T>(value);
            }else{
                node.leftChild = insertRecPrv(node.getLeftChild(), value);
            }
        }

        // Height rekursiv neu berechnen
        node.heigth = hoehe(node);

        return balanceTree(node);

    }

    @Override
    public void deleteRec(T value) {
        root = deleteRecPrv(getRoot(), value);
    }
    

    private AVLNode<T> deleteRecPrv(AVLNode<T> node, T value) {

        if(node == null) return null;

        if(node.getValue().compareTo(value) == 0) {
            // Hier muss gelöscht werden

            if(node.getRightChild() == null) {
                return node.getLeftChild();
            }
            if(node.getLeftChild() == null) {
                return node.getRightChild();
            }
            
            //Knoten gefunden und er hat zwei Kindwer
            T replacement = getMinValueRec(node.rightChild);

            node.setValue(replacement);

            node.rightChild = deleteRecPrv(node.getRightChild(), replacement);

        }else{
            if(node.getValue().compareTo(value) > 0) {
                node.leftChild = deleteRecPrv(node.getLeftChild(), value);
            }else{
                node.rightChild = deleteRecPrv(node.getRightChild(), value);
            }
        }

        node.heigth = hoehe(node);

        return balanceTree(node);

    }

    private AVLNode<T> balanceTree(AVLNode<T> node) {

        if(node.calculateBalance() == -2) {
            // left or rightLeft rotation is needed
            
            if(node.getRightChild().calculateBalance() == -1) {
                node = leftRotate(node);
            }else if(node.getRightChild().calculateBalance() == 1) {
                node = rightLeftRotate(node);
            }

        }else if(node.calculateBalance() == 2) {
            // right or leftRight rotation is needed
            if(node.getLeftChild().calculateBalance() == 1) {
                node = rightRotate(node);
            }else if(node.getLeftChild().calculateBalance() == -1) {
                node = leftRightRotate(node);
            }
        
        }

        return node;

    }

    public static void main(String[] args) {
        
        AVLTree<Integer> tree = new AVLTree<Integer>(8);

        for(int i : PiDigitScanner.getDigitsFromFile(new File("files/pi.txt"), 1000)) {

            tree.insertRec(i);

        }

        System.out.println(tree.toString());

    }

}
