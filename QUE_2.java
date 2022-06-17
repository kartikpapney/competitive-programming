import java.util.*;
public class QUE_2 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void postOrderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        while(true) {
            while(root != null) {
                st.push(root);
                st.push(root);
                root = root.left;
            }
            if(st.isEmpty()) return;
            root = st.pop();
            if(!st.isEmpty() && root == st.peek()) root = root.right;
            else {
                System.out.println(root+"         @         "+root.val);
                root = null;
            }
        }
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new 
        TreeNode(7, new TreeNode(8, null, 
        new TreeNode(12, null, null)), 
        new TreeNode(9, null,
        null)), 
        new TreeNode(6, null, 
        new TreeNode(13, null, null)));
        postOrderTraversal(root);
    }
}
