import java.util.Scanner;

class Node {
    int id;
    Node left, right;

    Node(int id) {
        this.id = id;
    }
}

public class AVLTree {
    Node root;

    Node insert(Node node, int id) {
        if (node == null)
            return new Node(id);

        if (id < node.id)
            node.left = insert(node.left, id);
        else
            node.right = insert(node.right, id);

        return node;
    }

    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println("Participant ID: " + node.id);
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AVLTree tree = new AVLTree();

        System.out.print("Enter number of participants: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Participant ID: ");
            int id = sc.nextInt();
            tree.root = tree.insert(tree.root, id);
        }

        System.out.println("\nRegistered Participants:");
        tree.inorder(tree.root);
    }
}