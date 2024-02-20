package training.btree;

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

class Solution {
    private int shiftCount = 0;

    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length - 1);
    }

    TreeNode toBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        var middleVal = nums[mid];
        var root = new TreeNode(middleVal);
        System.out.println(middleVal);

        root.left = toBST(nums, start, mid - 1);
        root.right = toBST(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        new Solution().sortedArrayToBST(new int[]{1,2,3,4,5,6,7,8,9,10});
    }
}