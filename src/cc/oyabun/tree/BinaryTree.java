package cc.oyabun.tree;

/**
 * Created by yaboong on 2017. 7. 29..
 *
 *         EXAMPLE
 *           50
 *         /    \
 *        25    75
 *       / \     \
 *      15 30    85
 *
 */
public class BinaryTree {
    private Node root;

    private class Node {
        int key;
        String name;

        Node leftChild;
        Node rightChild;

        Node(int key, String name) {
            this.key = key;
            this.name = name;
        }

        public String toString(){
            return "key:" + this.key + " value:" + this.name;
        }
    }

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
        } else {
            Node tmpRoot = root;
            Node parent;

            while(true) {
                parent = tmpRoot;

                if (key < parent.key) {
                    tmpRoot = parent.leftChild;

                    if (tmpRoot == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    tmpRoot = parent.rightChild;

                    if (tmpRoot == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverse(Node tmpNode) {
        if (tmpNode != null) {
            inOrderTraverse(tmpNode.leftChild);
            System.out.println(tmpNode.key);
            inOrderTraverse(tmpNode.rightChild);
        }
    }

    public void preOrderTraverse(Node tmpNode) {
        if (tmpNode != null) {
            System.out.println(tmpNode.key);
            preOrderTraverse(tmpNode.leftChild);
            preOrderTraverse(tmpNode.rightChild);
        }
    }

    public void postOrderTraverse(Node tmpNode) {
        if (tmpNode != null) {
            postOrderTraverse(tmpNode.leftChild);
            postOrderTraverse(tmpNode.rightChild);
            System.out.println(tmpNode.key);
        }
    }

    public Node findNode(int key) {
        Node tmpNode = root;

        while(tmpNode.key != key) {
            if (key < tmpNode.key) {
                tmpNode = tmpNode.leftChild;
            } else {
                tmpNode = tmpNode.rightChild;
            }

            if (tmpNode == null)
                return null;
        }

        return tmpNode;
    }

    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();

        bTree.addNode(50, "JT");
        bTree.addNode(25, "YB");
        bTree.addNode(15, "Teen");
        bTree.addNode(30, "SK");
        bTree.addNode(75, "Mongshu");
        bTree.addNode(85, "Boss");

        System.out.println("---------- In Order Traversal ----------");
        bTree.inOrderTraverse(bTree.root);

        System.out.println("---------- Pre Order Traversal ----------");
        bTree.preOrderTraverse(bTree.root);

        System.out.println("---------- Post Order Traversal ----------");
        bTree.postOrderTraverse(bTree.root);

        System.out.println("---------- Find Node ----------");
        Node found = bTree.findNode(25);
        if (found == null) System.out.println("Not Exists");
        else               System.out.println(found);
    }
}
