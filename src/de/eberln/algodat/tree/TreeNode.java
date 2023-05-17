package de.eberln.algodat.tree;

import java.util.ArrayList;
import java.util.function.Consumer;

import de.eberln.algodat.queue.ArrayQueue;
import de.eberln.algodat.queue.Queue;

public class TreeNode<T> {
    
    private ArrayList<TreeNode<T>> children;
    private T value;

    public TreeNode(T value) {
        this.children = new ArrayList<>();
        this.value = value;
    }

    public void addChildren(TreeNode<T> node) {
        children.add(node);
    }

    public void deepFirstTraversal(Consumer<T> visit) {

        visit.accept(value);

        for(TreeNode<T> t : children) {
            t.deepFirstTraversal(visit);
        }

    }

    public void layerForLayerTraversal(Consumer<T> visit) {

        ArrayList<TreeNode<T>> queue = new ArrayList<>(children.size());
        queue.add(this);

        while(!queue.isEmpty()) {
            TreeNode<T> currentNode = queue.remove(0);
            visit.accept(currentNode.getValue());

            for(var t : currentNode.children) {
                queue.add(t);
            }
        }

    }

    public TreeNode<T> getNextSibling(TreeNode<T> node) {

        ArrayList<TreeNode<T>> queue = new ArrayList<>(children.size());
        queue.add(this);

        while(!queue.isEmpty()) {
            TreeNode<T> currentNode = queue.remove(0);

            if(currentNode.getChildren().contains(node)) {
                try{
                    return currentNode.getChildren().get(currentNode.getChildren().indexOf(node) + 1);
                }catch(IndexOutOfBoundsException e) {
                    return null;
                }
            }

            for(var t : currentNode.children) {
                queue.add(t);
            }
        }

        return null;

    }

    public T getValue() {
       return value;
    }

    public ArrayList<TreeNode<T>> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return value.toString();
    }


}
