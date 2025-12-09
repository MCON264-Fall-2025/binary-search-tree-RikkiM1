package bst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private TreeNode<T> insertRecursive(TreeNode<T> node, T value) {
        if (node == null) {
            return new TreeNode<>(value);
        }
        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            node.left = insertRecursive(node.left, value);
        } else if (cmp > 0) {
            node.right = insertRecursive(node.right, value);
        }
        // ignore duplicates for this assignment
        return node;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    // --------- Recursive Traversals ----------

    public List<T> preorderRecursive() {
        List<T> result = new ArrayList<>();
        preorderRecursive(root, result);
        return result;
    }

    private void preorderRecursive(TreeNode<T> node, List<T> out) {
        // TODO: implement Preorder: Root -> Left -> Right
        if(node == null) return;
            out.add(node.getValue());
            preorderRecursive(node.getLeft(), out);
            preorderRecursive(node.getRight(), out);

        // hint: check for null, then visit node, then recurse on left and right
    }

    public List<T> inorderRecursive() {
        List<T> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }

    private void inorderRecursive(TreeNode<T> node, List<T> out) {
        // TODO: implement Inorder: Left -> Root -> Right
        if(node != null) {
            inorderRecursive(node.getLeft(), out);
            out.add(node.getValue());
            inorderRecursive(node.getRight(), out);
        }

    }

    public List<T> postorderRecursive() {
        List<T> result = new ArrayList<>();
        postorderRecursive(root, result);
        return result;
    }

    private void postorderRecursive(TreeNode<T> node, List<T> out) {
        // TODO: implement Postorder: Left -> Right -> Root
        if(node != null) {
            postorderRecursive(node.getLeft(), out);
            postorderRecursive(node.getRight(), out);
            out.add(node.getValue());
        }
    }

    // --------- Level-order (Breadth-First) ----------

    public List<T> levelOrder() {
        List<T> result = new ArrayList<>();
        // TODO: implement level-order using a Queue<TreeNode<T>>
        Queue<TreeNode<T>> q = new ArrayDeque<>();

        // 1. if root is null, return empty list
        if (root == null) {
            return result;
        }
        // 2. enqueue root
        q.add(root);
        // 3. while queue not empty:
        while(!q.isEmpty()) {
            //      - dequeue node
            TreeNode<T> node = q.remove();
            //      - add node.value to result
            result.add(node.getValue());
            //      - enqueue children if not null (left then right)
            if (node.getLeft() != null) {

                q.add(node.getLeft());
            }
            if (node.getRight() != null) {
                q.add(node.getRight());
            }
        }
                return result;
    }

    // --------- Unified API via TraversalType ----------

    public List<T> getByTraversal(TraversalType type) {
        return switch (type) {
            case PREORDER -> preorderRecursive();
            case INORDER -> inorderRecursive();
            case POSTORDER -> postorderRecursive();
            case LEVEL_ORDER -> levelOrder();
        };
    }
}
