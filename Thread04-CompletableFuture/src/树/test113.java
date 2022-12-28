package 树;

import tree.TreeNode;


public class test113 {

    public static void main(String[] args) {
         BinarySortTree a=new BinarySortTree();
         int[] b={1,4,3,5,7};
        for (int i = 0; i < 5; i++) {
           a.addNode1(b[i]);
        }
        BinarySortTree.infixOrder(a.root);//中序遍历输出
        System.out.printf("\n");
        a.deleteNode(3);//若含x的结点 则删除该节点
    }
}
 class BinarySortTree{

    TreeNode root;//根节点
    BinarySortTree(){

    }

    /**
     * 循环创建二叉树
     * @param val
     */
    public void addNode1(int val){
        if(root == null){
            root = new TreeNode(val);
            return;
        }
        TreeNode cur = root;
        while (cur!=null){
            if(val<=cur.val){
                if(cur.left==null){
                    cur.left = new TreeNode(val);
                    break;
                }else {
                    cur = cur.left;

                }
            }else {
                if(cur.right==null){
                    cur.right = new TreeNode(val);
                    break;
                }else {
                    cur = cur.right;
                }
            }
        }

    }

    /**
     * 递归创建二叉树
     * @param val
     */
    public void addNode2(int val){
        root = add2(root,val);
    }
    private TreeNode add2(TreeNode node,int val){
        if(node == null){
            return new TreeNode(val);
        }
        if(val<=node.val){
            node.left = add2(node.left,val);
        }else {
            node.right = add2(node.right,val);
        }
        return node;
    }

    /**
     * 删除二叉树中的任意节点
     * @param val
     */
    public void deleteNode(int val){
        if(root == null)
            return;
        TreeNode target = search(val);
        if(target == null)
            return ;
        if(root.left == null&&root.right == null){
            root = null;
            return;
        }

        TreeNode parent = searchParent(val);
        if(target.left == null&&target.right == null){
            if(target == parent.left)
                parent.left = null;
            else if(target == parent.right)
                parent.right = null;
        }else if(target.left!=null&&target.right!=null){
            int minVal = deleteRightTreeMin(target.right);//向右寻找最小值
            target.val = minVal;
        }else{
            if(target.left!=null){
                if(parent.left == target)
                    parent.left = target.left;
                else
                    parent.right = target.left;
            }else {
                if(parent.left == target)
                    parent.left = target.right;
                else
                    parent.right = target.right;
            }
        }
        BinarySortTree.infixOrder(root);
    }
    /**
     * 搜索待删除的目标节点
     * @param val
     * @return
     */
    public TreeNode search(int val){
        TreeNode cur = root;
        if(cur.val == val){
            return cur;
        }
        while(cur!=null){
            if(cur.val == val)
                return cur;
            else if(cur.val>val){
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        return null;
    }

    /**
     * 搜索待删除节点的父节点
     * @param val
     * @return
     */
    public TreeNode searchParent(int val){
        TreeNode cur = root;
        if((cur.left!=null&&cur.left.val==val)||(cur.right!=null&&cur.right.val==val)){
            return cur;
        }
        while(cur.left!=null||cur.right!=null){
            if((cur.left!=null&&cur.left.val==val)||(cur.right!=null&&cur.right.val==val)){
                return cur;
            }
            else if(cur.val>val&&cur.left!=null){
                cur = cur.left;
            }else if(cur.val<val&&cur.right!=null){
                cur = cur.right;
            }else
                return null;
        }
        return null;
    }

    /**
     * 从右子树出发寻找最小值并删除
     * @param node
     * @return
     */
    public int deleteRightTreeMin(TreeNode node){
        TreeNode target = node;
        while(target.left!=null){//向左寻找,因为最小值存储在左边
            target = target.left;
        }
        deleteNode(target.val);
        return target.val;
    }

    /**
     * 中序遍历二叉树,获得从小到大的数列
     * @param node
     */
    public static void infixOrder(TreeNode node){
        if(node == null)
            return;
        infixOrder(node.left);
        System.out.println(node.val);
        infixOrder(node.right);
    }
}


