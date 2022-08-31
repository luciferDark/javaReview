package com.ll.java.trees;

import com.ll.java.utils.Log;

import java.util.LinkedList;
import java.util.Queue;

public class TreeHelp {
    TreeNode root;
    public TreeHelp(){

    }
    public void init() {
        root = new TreeNode(50);
        TreeNode left1 = new TreeNode(3);
        TreeNode left2 = new TreeNode(1);
        TreeNode left3 = new TreeNode(55);
        TreeNode left4 = new TreeNode(13);

        TreeNode right1 = new TreeNode(67);
        TreeNode right2 = new TreeNode(34);
        TreeNode right3 = new TreeNode(23);

        root.left =  left1;
        root.right = right1;

        left1.left = left2;
        left1.right = right2;

        right1.left = left3;

        right2.left = left4;

        left4.right = right3;
    }

    public void start() {
        if (null != queue){
            queue.clear();
        }
        queue = new LinkedList<>();

        Log.log("========bfs=====");
        bfs(root);
        Log.log("========dfs_before=====");
        dfs_before(root);
        Log.log("========dfs_Center=====");
        dfs_Center(root);
        Log.log("========dfs_After=====");
        dfs_After(root);
    }

    private Queue<TreeNode> queue = new LinkedList<>();
    public void bfs(TreeNode root){
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
            Log.log(node.toString());
        }
    }


    public void dfs_before(TreeNode root){
        Log.log(root.toString());
        if (null != root.left){
            dfs_before(root.left);
        }
        if (null != root.right){
            dfs_before(root.right);
        }
    }

    public void dfs_After(TreeNode root){
        if (null != root.left){
            dfs_After(root.left);
        }
        if (null != root.right){
            dfs_After(root.right);
        }
        Log.log(root.toString());
    }

    public void dfs_Center(TreeNode root){
        if (null != root.left){
            dfs_Center(root.left);
        }
        Log.log(root.toString());
        if (null != root.right){
            dfs_Center(root.right);
        }
    }


    class TreeNode {
        public TreeNode(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value + "";
        }

        public int value;
        public TreeNode left;
        public TreeNode right;
    }
}
