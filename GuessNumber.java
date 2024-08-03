package PlayStore;
//

//public class GuessNumber {
//
//}

import java.util.Random;
import java.util.Scanner;

class NodeG {
    int data;
    NodeG left;
    NodeG right;

    public NodeG(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BST {
    private NodeG root;

    public BST() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private NodeG insertRec(NodeG root, int data) {
        if (root == null) {
            root = new NodeG(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(NodeG root, int data) {
        if (root == null) {
            return false;
        }

        if (data == root.data) {
            return true;
        }

        if (data < root.data) {
            return searchRec(root.left, data);
        }

        return searchRec(root.right, data);
    }
}

public class GuessNumber {
}