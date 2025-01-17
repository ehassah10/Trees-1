// Time Complexity : O(n) where n is number of node in the binary tree
// Space Complexity : O(h)+ O(n) where h is height of binary tree. 
//                  in worst case the height of binary tree can be n, so space can be O(n) in that case. 
//                  And n space is used to store inorder array index mapping
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
public class BuildTree {
    public static void main(String[] args) {
        
    }
}
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }
        int len = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<len; i++){
            map.put(inorder[i], i);
        }
        int[] idx = new int[1];
        return helper(preorder, inorder, 0, len-1, idx, map);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end, int[] idx, Map<Integer, Integer> map){
        //base
        
        if(start > end){
            return null;
        }
        
        //logic
        //get the root from preorder
        int rootVal = preorder[idx[0]++];
        TreeNode root = new TreeNode(rootVal);
        
        //find location of root in inroder
        int rootPos = map.get(rootVal);
        
        //adjust the bounds in inorder to get left and right subtree
        root.left = helper(preorder, inorder, start, rootPos - 1, idx, map);  
        root.right = helper(preorder, inorder, rootPos + 1, end, idx, map);
        
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {
            
        }
        TreeNode(int val) { 
            this.val = val; 
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
