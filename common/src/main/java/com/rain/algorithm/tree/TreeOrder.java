package com.rain.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyu on 2017/3/13.
 *  二叉树遍历
 *  URL:http://f.hiphotos.baidu.com/baike/s%3D220/sign=28c7398a3af33a879a6d0718f65d1018/e61190ef76c6a7ef33e5129cfdfaaf51f2de664d.jpg
 */
public class TreeOrder {

    /**
     * 先序遍历
     * @param root 根节点
     */
    public static  List<String> preOrder(TreeNode root){
        List<String> list = new ArrayList<>();
        list.add(root.value);
        if(root.left!=null){
            list.addAll(preOrder(root.left));
        }
        if(root.right!=null){
            list.addAll(preOrder(root.right));
        }
        return list;
    }


    /**
     * 中序遍历
     * @param root 根节点
     */
    public static List<String> inOrder(TreeNode root){
        List<String> list = new ArrayList<>();
        if(root.left!=null){
            list.addAll(inOrder(root.left));
        }
        list.add(root.value);
        if(root.right!=null){
            list.addAll(inOrder(root.right));
        }
        return list;
    }


    /**
     * 后序遍历
     * @param root 根节点
     */
    public static List<String> postOrder(TreeNode root){
        List<String> list = new ArrayList<>();

        if(root.right!=null){
            list.addAll(postOrder(root.right));
        }
        if(root.left!=null){
            list.addAll(postOrder(root.left));
        }
        list.add(root.value);
        return list;
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        TreeNode c = new TreeNode("C");
        TreeNode f = new TreeNode("F");

        a.left=b;
        a.right=c;

        b.father=a;
        b.left=d;
        b.right=e;

        d.father=b;
        e.father=b;

        c.father=a;
        c.left=f;

        f.father=c;

        System.out.printf("先序遍历 ："+preOrder(a));

        System.out.printf("\n ---------------------------------------------------   ");
        System.out.printf("\n中序遍历 ："+inOrder(a));

        System.out.printf("\n ---------------------------------------------------   ");
        System.out.printf("\n后序遍历 ："+postOrder(a));
    }

}
