package bst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraversalExercises {

    // Iterative preorder using a stack
    public static <T extends Comparable<T>> List<T> preorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();

        // TODO: implement iterative preorder using Deque as a stack
        if (root == null) return result;
        Deque<TreeNode<T>> d = new ArrayDeque<>();
        d.push(root);

        while (!d.isEmpty()) {
            TreeNode<T> node = d.pop();
            result.add(node.getValue());

            if (node.getRight() != null) d.push(node.getRight());
            if (node.getLeft() != null) d.push(node.getLeft());

        }

        // Hint: push root; while stack not empty:
        //   pop node, visit it, then push right child, then left child
        return result;
    }

    // Iterative inorder using a stack
    public static <T extends Comparable<T>> List<T> inorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        // TODO: implement iterative inorder
        Deque<TreeNode<T>> d = new ArrayDeque<>();
        TreeNode<T> curr = root;
        while (curr != null || !d.isEmpty()) {
            while (curr != null) {
                d.addLast(curr);
                curr = curr.getLeft();
            }
            curr = d.pop();
            result.add(curr.getValue());

            curr.getRight();
            }
        // Hint: use a pointer 'curr' and a stack:
        //   while (curr != null || !stack.isEmpty()) { ... }
        return result;
    }

    // Optional / challenge: iterative postorder
    public static <T extends Comparable<T>> List<T> postorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        // TODO (challenge): implement iterative postorder
        // You may use two stacks, or one stack with a previous-node pointer.
        return result;
    }

    // Practice version of level-order
    public static <T extends Comparable<T>> List<T> levelOrderUsingQueue(TreeNode<T> root) {
        List<T> result = new ArrayList<>();

        if (root == null) return result;   // nothing to do

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);                   // start BFS with the root

        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.remove();
            result.add(node.getValue());   // visit node

            if (node.getLeft() != null) {  // enqueue left child
                queue.add(node.getLeft());
            }

            if (node.getRight() != null) { // enqueue right child
                queue.add(node.getRight());
            }
        }

        return result;
    }
}

