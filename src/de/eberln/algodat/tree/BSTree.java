package de.eberln.algodat.tree;

import de.eberln.algodat.tree.avl.AVLTree;

public class BSTree<T extends Comparable<? super T>> {

    protected BinaryNode<T> root;

    public BSTree()
    {
        root = null;
    }

    public BSTree(T value)
    {
        root = new BinaryNode<T>(value);
    }

    public String toString()
    {
        return root.toString();
    }

    public int hoehe(BinaryNode<T> node) {
        if(node == null) {
            return -1;
        }else{
            return Math.max(hoehe(node.leftChild), hoehe(node.rightChild)) +1;
        }
    }

    protected T getMinValueRec(BinaryNode<T> node) {

        if(node.leftChild == null) {
            return node.getValue();
        }else{
            return getMinValueRec(node.leftChild);
        }

    }

    protected T getMinValue(BinaryNode<T> node) {

        while(node.leftChild != null) {
            node = node.leftChild;
        }

        return node.getValue();

    }

    public Boolean find(T value)
    {
        if(root == null) {
            return false;
        }

        BinaryNode<T> currentNode = root;

        boolean abortSearch = false;

        while(!abortSearch) {

            if(value.compareTo(currentNode.getValue()) == 0) {
                return true;
            }else if(value.compareTo(currentNode.getValue()) < 0) {
                if(currentNode.leftChild == null) {
                    abortSearch = true;
                }else{
                    currentNode = currentNode.leftChild;
                }
            }else if(value.compareTo(currentNode.getValue()) > 0) {
                if(currentNode.rightChild == null) {
                    abortSearch = true;
                }else{
                    currentNode = currentNode.rightChild;
                }
            }

        }

        return false;

    }

    // Allgemeine Methoden
    // =====================================================================================================================
    // BST Methoden

    public void insert(T value)
    {
        if(this instanceof AVLTree) {
            throw new UnsupportedOperationException();
        }

        BinaryNode<T> newNode = new BinaryNode<T>(value);
        BinaryNode<T> currentNode = root;

        if(root == null) {
            root = newNode;
            return;
        }

        BinaryNode<T> parent = null;
        while(currentNode != null) {
            if(value.compareTo(currentNode.getValue()) < 0) {
                parent = currentNode;
                currentNode = currentNode.leftChild;
            }else{
                parent = currentNode;
                currentNode = currentNode.rightChild;
            }
        }
        if(value.compareTo(parent.getValue()) < 0) {
            parent.leftChild = newNode;
        }else{
            parent.rightChild = newNode;
        }
        
    }

    public void insertRec(T value) {

        insertRecPrv(root, value);

    }

    private void insertRecPrv(BinaryNode<T> node, T value) {

        if(node.getValue().compareTo(value) <= 0) {
            // Insertvalue größer -> rechts einfügen

            if(node.rightChild != null) {
                insertRecPrv(node.rightChild, value);
            }else{
                node.rightChild = new BinaryNode<T>(value);
            }

        }else{
            // Insertvalue kleiner -> links einfügen

            if(node.leftChild != null) {
                insertRecPrv(node.leftChild, value);
            }else{
                node.leftChild = new BinaryNode<T>(value);
            }

        }
        

    }

    public void deleteRec(T value) {
        root = deleteRecPrv(root, value);
    }

    private BinaryNode<T> deleteRecPrv(BinaryNode<T> node, T value) {

        if( node == null ) return null;
        if( node.getValue().compareTo(value) == 0 ) {
            //Hier muss geloescht werden
            if( node.leftChild == null && node.rightChild == null ) {
                return null;
            }
            if(node.leftChild == null ) return node.rightChild;
            if(node.rightChild == null) return node.leftChild;
        
            //Knoten gefunden und er hat zwei Kindwer
            T replacement = getMinValueRec(node.rightChild);

            node.setValue(replacement);

            node.rightChild = deleteRecPrv(node.rightChild, replacement);
        
        }else if(node.getValue().compareTo(value) < 0) {
            node.rightChild = deleteRecPrv(node.rightChild, value);
        }else {
            node.leftChild = deleteRecPrv(node.leftChild, value);
        }

        return node;

    }

}
