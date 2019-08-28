package com.mowen.datastruct.tree;

/***
 * @desc  : 红黑树
 * @author: mowen
 * @create_time: 2019/8/10 9:42
 * @since:
 */
public class RedBlackTree<T extends Comparable> extends AbstractBalanceTree<T> implements ITree<T> {


    @Override
    public void insert(T t) {

    }

    @Override
    public void delete(T t) {

    }


    public static class RbTreeNode<T extends Comparable> extends BalTreeNode<T>{
        Color color;

        public RbTreeNode(){}

        public RbTreeNode(T t){
            super(t);
        }
        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }

    public static enum Color{
        RED,
        BLACK;
    }
}
