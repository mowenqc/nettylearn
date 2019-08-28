package com.mowen.datastruct.tree;

/***
 * @desc  :  平衡树的抽象定义
 * @author: mowen
 * @create_time: 2019/8/9 17:58
 * @since:
 */
public abstract class AbstractBalanceTree<T extends Comparable> extends AbstractTree<T> implements ITree<T> {

    /**
     * 向左旋转
     */
    protected  void leftRote(BalTreeNode node){

    };

    /**
     * 向右旋转
     */
    protected  void rightRote(BalTreeNode node){

    };

    public static class BalTreeNode<T extends Comparable> extends TreeNode<T>{
        /**
         * 定义平衡因子，如果左右高度一致，则为0
         * 如果左高右低位正数， 1,2,3,表示高度的差值
         * 如果右高左低为负数，如-1表示右子树比左子树的高度高1， -2 表示高2
         * 自己定义的，无所谓怎么定义，只需要表示出来就可以
         */
        int balanceFactor = 0;
        public BalTreeNode(){}

        public BalTreeNode(T t){
            super(t);
        }
    }
}
