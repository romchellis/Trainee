package ex.training.btree;


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

    public void insert(int val) {

    }

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hel" + "lo";
        String str3 = str2.intern();
        String str4 = str2 + ", " + "world";
        String str5 = str2.intern() + ", " + "world";

        System.out.println(str1 == str2); // true
        System.out.println(str1 == str3); // true
        System.out.println(str4 == "Hello, world");
        System.out.println(str5 == "Hello, world");
        System.out.println(str5.intern() == "Hello, world"); //true
    }
}

