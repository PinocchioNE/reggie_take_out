import java.util.*;

public class Solution {
    int[] preorder;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;


        for(int i = 0; i < inorder.length; i++){
            hashMap.put(inorder[i],i);
        }

        return recur(0,0,inorder.length-1);
    }

    public TreeNode recur(int root, int left,int right){


        if(left > right) return null;// 说明没有节点了

        TreeNode treeroot = new TreeNode(preorder[root]); //找到前序中每一次递归的根节点索引

        int inordeRrootIndex = hashMap.get(preorder[root]); // 找到中序的根节点索引；

        treeroot.left = recur(root + 1, left, inordeRrootIndex-1);

        treeroot.right = recur(root+(inordeRrootIndex-left)+1, inordeRrootIndex+1, right);

        return treeroot;
    }

}
