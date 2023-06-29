package de.eberln.algodat.tree;

import java.util.List;
import java.util.function.Consumer;

public class PiTreeController {

    int currentPiDigit = 1;
    List<Integer> piDigits = null;

    public void buildPiTree(List<Integer> piDigits) {

        this.piDigits = piDigits;

        TreeNode<Integer> root = new TreeNode<Integer>(piDigits.get(0));
        TreeNode<Integer> currentNode = root;
        
        int currentNodeIndex = 0;
        boolean setNewFirstNode = true;

        TreeNode<Integer> firstNodeOfCurrentLayer = root;

        while(currentPiDigit < piDigits.size()) {

            addNChildren(currentNode, currentNodeIndex, currentPiDigit);

            if(setNewFirstNode) {
                firstNodeOfCurrentLayer = firstNodeOfCurrentLayer.getChildren().get(0);
                setNewFirstNode = false;
            }

            if(root.getNextSibling(currentNode) == null) {
                currentNode = firstNodeOfCurrentLayer;
                setNewFirstNode = true;
                currentNodeIndex++;
            }else{
                currentNode = root.getNextSibling(currentNode);
                currentNodeIndex++;
            }

        }

        Consumer<Integer> visit = (a) -> System.out.println(a);
        root.layerForLayerTraversal(visit);

    }

    private void addNChildren(TreeNode<Integer> parentNode, int parentNodeIndex, int piDigitToStartIndex) {

        for(int i = 0; i < piDigits.get(parentNodeIndex); i++) {
            
            try{

                parentNode.addChildren(new TreeNode<Integer>(piDigits.get(piDigitToStartIndex + i)));
                currentPiDigit++;

            }catch(IndexOutOfBoundsException e) {
                return;
            }

        }

    }

}
