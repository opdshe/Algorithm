package 재귀;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class 트리순회 {
    static Map<String, Node> nodeTree = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] inputs = scanner.nextLine().split(" ");
            Node node = makeNode(inputs);
            nodeTree.put(inputs[0], node);
        }
        preorderTraversal(nodeTree.get("A"));
        System.out.println();
        inorderTraversal(nodeTree.get("A"));
        System.out.println();
        postorderTraversal(nodeTree.get("A"));
    }

    private static void preorderTraversal(Node root) {
        System.out.print(root.root);
        if (root.left != null) {
            preorderTraversal(nodeTree.get(root.left));
        }
        if (root.right != null) {
            preorderTraversal(nodeTree.get(root.right));
        }
    }

    private static void inorderTraversal(Node root) {
        if (root.left != null) {
            inorderTraversal(nodeTree.get(root.left));
        }
        System.out.print(root.root);
        if (root.right != null) {
            inorderTraversal(nodeTree.get(root.right));
        }
    }

    private static void postorderTraversal(Node root) {
        if (root.left != null) {
            postorderTraversal(nodeTree.get(root.left));
        }
        if (root.right != null) {
            postorderTraversal(nodeTree.get(root.right));
        }
        System.out.print(root.root);
    }

    private static class Node {
        String root = null;
        String left = null;
        String right = null;

        @Override
        public String toString() {
            return "Node{" +
                    "root='" + root + '\'' +
                    ", left='" + left + '\'' +
                    ", right='" + right + '\'' +
                    '}';
        }
    }

    private static Node makeNode(String[] inputs) {
        Node node = new Node();
        node.root = inputs[0];
        if (!inputs[1].equals(".")) {
            node.left = inputs[1];
        }
        if (!inputs[2].equals(".")) {
            node.right = inputs[2];
        }
        return node;
    }
}
