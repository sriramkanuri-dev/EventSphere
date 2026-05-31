import java.util.Scanner;

class Node {
    int id, height;
    Node left, right;

    Node(int id) {
        this.id = id;
        height = 1;
    }
}

public class AVLTree {

    Node root;

    int h(Node n) {
        return n == null ? 0 : n.height;
    }

    int balance(Node n) {
        return n == null ? 0 : h(n.left) - h(n.right);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node t = x.right;

        x.right = y;
        y.left = t;

        y.height = Math.max(h(y.left), h(y.right)) + 1;
        x.height = Math.max(h(x.left), h(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node t = y.left;

        y.left = x;
        x.right = t;

        x.height = Math.max(h(x.left), h(x.right)) + 1;
        y.height = Math.max(h(y.left), h(y.right)) + 1;

        return y;
    }

    Node insert(Node node, int id) {

        if (node == null)
            return new Node(id);

        if (id < node.id)
            node.left = insert(node.left, id);

        else if (id > node.id)
            node.right = insert(node.right, id);

        node.height =
                1 + Math.max(
                        h(node.left),
                        h(node.right)
                );

        int b = balance(node);

        if (b > 1 && id < node.left.id)
            return rightRotate(node);

        if (b < -1 && id > node.right.id)
            return leftRotate(node);

        if (b > 1 && id > node.left.id) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (b < -1 && id < node.right.id) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void inorder(Node n) {
        if (n != null) {
            inorder(n.left);
            System.out.print(n.id + " ");
            inorder(n.right);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AVLTree t = new AVLTree();

        System.out.print("Participants: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.print("Participant ID: ");
            int id = sc.nextInt();

            t.root = t.insert(t.root, id);
        }

        t.inorder(t.root);
    }
}