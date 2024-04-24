package utils;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    public T val;
    public int height;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T x) {
        val = x;
    }
    // Please refer to the serialization encoding rules:
    // https://www.hello-algo.com/chapter_tree/array_representation_of_tree/
    private static <T> TreeNode<T> listToTreeDFS(List<T> arr, int i) {
        if (i < 0 || i >= arr.size() || arr.get(i) == null) {
            return null;
        }
        TreeNode<T> root = new TreeNode<>(arr.get(i));
        root.left = listToTreeDFS(arr, 2 * i + 1);
        root.right = listToTreeDFS(arr, 2 * i + 2);
        return root;
    }

    /* Deserialize list into binary tree */
    public static <T> TreeNode<T> listToTree(List<T> arr) {
        return listToTreeDFS(arr, 0);
    }

    /* Serialize binary tree to list: recursion */

    private static <T> void treeToListDFS(TreeNode<T> root, int i, List<T> res) {
        if (root == null)
            return;
        while (i >= res.size()) {
            res.add(null);
        }
        res.set(i, root.val);
        treeToListDFS(root.left, 2 * i + 1, res);
        treeToListDFS(root.right, 2 * i + 2, res);
    }

    /* Serialize binary tree into list */
    public static <T> List<T> treeToList(TreeNode<T> root) {
        List<T> res = new ArrayList<>();
        treeToListDFS(root, 0, res);
        return res;
    }
}
