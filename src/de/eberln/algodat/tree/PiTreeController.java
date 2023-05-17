package de.eberln.algodat.tree;

import java.util.List;
import java.util.function.Consumer;

public class PiTreeController {
    
    List<Integer> piDigits = List.of(3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3,2,3,8,4,6,2,6,4,3,3,8,3,2,7,9,5,0,2,8,8,4,1,9,7,1,6,9,3,9,9,3,7,5,1,0,5,8,2);

    int currentPiDigit = 1;

    public static void main(String[] args) {
        new PiTreeController();
    }


    public PiTreeController() {

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

            }catch(ArrayIndexOutOfBoundsException e) {
                return;
            }

        }

    }

}
