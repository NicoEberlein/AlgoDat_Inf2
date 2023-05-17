package de.eberln.algodat.tree;

import java.util.function.Consumer;

public class TreeController {
    
    public static void main(String[] args) {
        
        TreeNode<String> a = new TreeNode<String>("a");
        TreeNode<String> b = new TreeNode<String>("b");
        TreeNode<String> c = new TreeNode<String>("c");
        TreeNode<String> d = new TreeNode<String>("d");
        TreeNode<String> e = new TreeNode<String>("e");
        TreeNode<String> f = new TreeNode<String>("f");
        TreeNode<String> g = new TreeNode<String>("g");
        TreeNode<String> h = new TreeNode<String>("h");
        TreeNode<String> i = new TreeNode<String>("i");


        a.addChildren(b);
        a.addChildren(c);
        a.addChildren(d);
        c.addChildren(e);
        d.addChildren(f);
        d.addChildren(g);
        b.addChildren(h);
        g.addChildren(i);

        Consumer<String> visit = (x) -> System.out.println(x);
        a.layerForLayerTraversal(visit);

        System.out.println(a.getNextSibling(f));

    }

}
