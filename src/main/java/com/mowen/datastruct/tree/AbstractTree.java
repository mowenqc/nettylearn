package com.mowen.datastruct.tree;

import java.io.Serializable;
import java.util.Objects;

/***
 * @desc  : 树的抽象
 * @author: mowen
 * @create_time: 2019/8/9 18:03
 * @since:
 */
public abstract class AbstractTree<T extends Comparable> implements ITree<T> {

    protected transient TreeNode<T> root;

    protected int size;

    @Override
    public T get(T t) {
        Objects.requireNonNull(t);
        TreeNode current = root;
        if(root == null){
            return null;
        }
        do {
            int compare = current.data.compareTo(t);

            if(compare == 0){//相等则返回
                return (T) current.data;
            }
            else if(compare > 0) {//小则走左边
                current = current.left;
            }
            else if(compare < 0){//大则走右边
                current = current.right;
            }
        }
        while (current != null);
        return null;
    }

    protected TreeNode<T> getTreeNode(T t){
        Objects.requireNonNull(t);
        TreeNode current = root;
        if(root == null){
            return null;
        }
        do {
            int compare = current.data.compareTo(t);

            if(compare == 0){//相等则返回
                return current;
            }
            else if(compare > 0) {//小则走左边
                current = current.left;
            }
            else if(compare < 0){//大则走右边
                current = current.right;
            }
        }
        while (current != null);
        return null;
    }

    protected void deleteLeafNode(TreeNode node){
        if(node.parent.left == node){
            node.parent.left = null;
        }
        if(node.parent.right == node){
            node.parent.right = null;
        }
    }


    /**
     * 这个过程找出最左边的节点
     *  1. 如果当前节点没有左节点，那么当前节点是最小的节点
     *  2.如果存在左节点，那么当前节点变为左节点
     * @return 最小节点
     */
    protected TreeNode checkMinNode(TreeNode node){
        TreeNode current = node;
        Objects.requireNonNull(node);
        if(current.left == null){
            return current;
        }
        else {
            return  checkMinNode(current.left);
        }

    }

    /**
     * 找到树种的最大的节点，最大节点通常是是右节点
     * @param node
     * @return
     */
    protected TreeNode checkMaxNode(TreeNode node){
        TreeNode current = node;
        Objects.requireNonNull(node);
        if(current.right == null){
            return current;
        }
        else {
            return  checkMaxNode(current.right);
        }
    }

    @Override
    public int size() {
        return size;
    }

    public static class TreeNode<T  extends Comparable> implements Comparable<T>, Serializable {

        private static final long serialVersionUID = 1L;
        /**
         * 父节点
         */
        T data;
        /**
         * 左节点
         */
        TreeNode left;
        /**
         * 右节点
         */
        TreeNode right;

        TreeNode leftBrother;

        TreeNode rightBrother;


        /**
         * 父节点
         */
        TreeNode parent;
        public TreeNode(){}
        public TreeNode(T data){
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }


        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

        public TreeNode getLeftBrother() {
            return leftBrother;
        }

        public void setLeftBrother(TreeNode leftBrother) {
            this.leftBrother = leftBrother;
        }

        public TreeNode getRightBrother() {
            return rightBrother;
        }

        public void setRightBrother(TreeNode rightBrother) {
            this.rightBrother = rightBrother;
        }

        @Override
        public int compareTo(T o) {
            //需要判断数据类型，否则比较
            return data.compareTo(o);
        }
    }
}
