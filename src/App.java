import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.PrintUtil;
import utils.TreeNode;

public class App<T> {
    public static List<Object> list = new ArrayList<>();

    public static <T> void main(String[] args) throws Exception {

        TreeNode<String> root = new TreeNode<>("-");
        root.left = new TreeNode<>("/");
        root.left.left = new TreeNode<>("x");
        root.left.right = new TreeNode<>("+");
        root.left.right.left = new TreeNode<>("-");
        root.left.right.right = new TreeNode<>("2");
        root.left.right.left.left = new TreeNode<>("9");
        root.left.right.left.right = new TreeNode<>("5");

        root.left.left.left = new TreeNode<>("+");
        root.left.left.right = new TreeNode<>("3");
        root.left.left.left.left = new TreeNode<>("3");
        root.left.left.left.right = new TreeNode<>("1");

        root.right = new TreeNode<>("+");
        root.right.left = new TreeNode<>("x");
        root.right.left.left = new TreeNode<>("3");
        root.right.left.right = new TreeNode<>("-");
        root.right.left.right.left = new TreeNode<>("7");
        root.right.left.right.right = new TreeNode<>("4");
        root.right.right = new TreeNode<>("6");

        preOrder(root);

        PrintUtil.printTree(root);

        System.out.println(list);
    }

    // Access priority: root node -> left subtree -> right subtree
    static <T> void preOrder(TreeNode<T> root) {
        if (root == null)
            return;

        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // Access priority: left subtree -> right subtree -> root node
    static <T> void inOrder(TreeNode<T> root) {
        if (root == null)
            return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    static <T> void postOrder(TreeNode<T> root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
    }
}