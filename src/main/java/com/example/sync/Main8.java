package com.example.sync;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javafx.util.Pair;

public class Main8 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode("A");
        a.left = new TreeNode("B");
        a.right = new TreeNode("C");
        a.left.left = new TreeNode("D");
//        a.left.right = new TreeNode("E");
//        a.right.left = new TreeNode("F");
//        a.right.right = new TreeNode("G");
        System.out.println(handle(a));
        System.out.println(handle(a));
        System.out.println(handle(a));
        System.out.println(handle(a));
        System.out.println(handle(a));


    }

    public static int handle(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(node, 1));
        int maxWidth = 0;

        while (!stack.empty()) {
            int size = stack.size();
            int max = 0;
            int min = Integer.MAX_VALUE;
            List<Pair<TreeNode, Integer>> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pop = stack.pop();
                TreeNode treeNode = pop.getKey();
                Integer width = pop.getValue();
                max = Math.max(width, max);
                min = Math.min(width, min);
                if (treeNode.left != null) {
                    temp.add(new Pair<>(treeNode.left, width * 2 - 1));
                }
                if (treeNode.right != null) {
                    temp.add(new Pair<>(treeNode.right, width * 2));
                }
                maxWidth = Math.max(maxWidth, (max - min + 1));
            }
            temp.forEach(stack::push);
        }
        return maxWidth;
    }

    public static class TreeNode {
        String value;
        TreeNode left;
        TreeNode right;

        public TreeNode(String value) {
            this.value = value;
        }
    }


}

