package com.mowen.datastruct.tree;

import java.util.Objects;

/***
 * @desc  : 二叉树， 一个二叉排序树的简单实现
 * @author: mowen
 * @create_time: 2019/8/10 9:36
 * @since:
 */
public class BinaryTree<T extends Comparable> extends AbstractTree<T> implements ITree<T>  {

    @Override
    public void insert(T t) {
        Objects.requireNonNull(t);
        TreeNode<T> node = new TreeNode<>(t);
        if(root == null){
            root = node;
            return;
        }
        TreeNode current = root;
        do{
            if(current.data.equals(t)){
                break;
            }
            int compare = current.data.compareTo(t);
            if(compare < 0){
                if(current.right == null){
                    current.right = node;
                    node.parent = current;
                    size++;
                    break;
                }
                else {
                    current = current.right;
                }
            }
            else if(compare > 0) {
                if(current.left == null){
                    current.left = node;
                    node.parent = current;
                    size++;
                    break;
                }
                else {
                    current = current.left;
                }
            }
        }while (current != null);
    }
    /**
     * 注意删除节点用节点数据替换的方式，否则非常麻烦
     */
    @Override
    public void delete(T t) {
        Objects.requireNonNull(t);
        if(root == null){
            return;
        }
        //1. 找到要删除的节点
        TreeNode<T> treeNode = getTreeNode(t);
        //如果节点不存在，直接返回
        if(treeNode == null){
            return;
        }
        //2. 如果是是叶子节点，如果是根节点需要单独处理
        if(treeNode.left == null && treeNode.right == null){
            if(treeNode == root){
                root = null;
            }
            else if(treeNode.parent.left == treeNode){
                //如果是左节点，则将父的左节点置空
                treeNode.parent.left = null;
            }
            else if(treeNode.parent.right == treeNode){
                //如果是右节点，则将父节点的右节点置空
                treeNode.parent.right = null;
            }
            size--;
            return;
        }

        //3.如果右节点不空，则找出右节点中的最小节点来替换需要删除的节点
        if(treeNode.right != null){//如果其右节点不为空， 找到这个节点，并进行替换，然后删除这个最小的节点
            TreeNode minNode = checkMinNode(treeNode.right);
            treeNode.data = (T) minNode.data;
            //如果是叶子界面直接删除
            if(minNode.left == null && minNode.right == null){
                deleteLeafNode(minNode);
            }
            if(minNode.right != null){
                if(minNode.parent.left == minNode){//如果最小的节点属于左节点
                    minNode.right.parent = minNode.parent;
                    minNode.parent.left = minNode.right;
                }
            }
            size--;
            return;
        }
        else {//4. 如treeNode 的右节点为空，左节点不为空，那么只能找到，左节点中的最大节点，替换treeNode中的节点
            TreeNode maxNode = checkMaxNode(treeNode.left);
            treeNode.data = (T) maxNode.data;//替换数据
            //如果左节点的最大节点是叶子节点，直接删除
            if(maxNode.left == null && maxNode.right == null){
                deleteLeafNode(maxNode);
            }
            //如果max还存在左节点，则将左节点左节点与此节点替换
            if(maxNode.left != null){
                if(maxNode.parent.left == maxNode){
                    maxNode.parent.left = maxNode.left;

                }
                else if(maxNode.parent.right == maxNode){
                    maxNode.parent.right = maxNode.left;

                }
                maxNode.left.parent = maxNode.parent;
            }
            size--;
        }
    }
}
