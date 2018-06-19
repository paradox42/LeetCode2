import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraverse {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        Solution s = new Solution();
        List<Integer> result = s.preorderTraversal(root);

        System.out.println(result);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root != null){
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return this.result;
    }
}
