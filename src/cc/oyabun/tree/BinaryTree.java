package cc.oyabun.tree;

/**
 * Created by yaboong on 2017. 7. 29..
 *
 *         EXAMPLE
 *           50
 *         /    \
 *        25    75
 *       / \    / \
 *     15  30  70 85
 *    /\   / \
 *   2 18 26 32
 */
public class BinaryTree {
    private Node root;

    private class Node {
        int key;

        Node leftChild;
        Node rightChild;

        Node(int key) {
            this.key = key;
        }

        public String toString() {
            return "key:" + this.key;
        }
    }

    public Node getRoot() {
        return this.root;
    }

    public void addNode(int key) {
        Node newNode = new Node(key);

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

    public boolean deleteNode(int key) {
        Node tmpNode = root;
        Node parent = root;

        boolean isLeftChild = true;

        // After this while loop, tmpNode will be the node that will be deleted except for the case when it's not found
        while(tmpNode.key != key) {
            parent = tmpNode;

            if(key < tmpNode.key) {
                isLeftChild = true;
                tmpNode = parent.leftChild;
            } else {
                isLeftChild = false;
                tmpNode = parent.rightChild;
            }

            // Not found
            if(tmpNode == null) {
                return false;
            }
        }


        /**
         * Below if statement is for after the tmpNode which will be deleted is being found.
         * At this point, variable 'parent' is a parent node of the tmpNode.
         */

        // if tmpNode has no children. (Draw a tree and just follow the code)
        if(tmpNode.leftChild == null && tmpNode.rightChild == null) {
            if (tmpNode == root) {
                root = null;
            } else if(isLeftChild) {
                parent.leftChild = null; // deleting tmpNode
            } else {
                parent.rightChild = null; // deleting tmpNode
            }
        }
        // if tmpNode has no right-side children. (Draw a tree and just follow the code)
        else if(tmpNode.rightChild == null) {
            if(tmpNode == root)
                root = tmpNode.leftChild;
            else if(isLeftChild) {
                parent.leftChild = tmpNode.leftChild;
            }
            else {
                parent.rightChild = tmpNode.leftChild;
            }
        }
        // if tmpNode has no left-side children. (Draw a tree and just follow the code)
        else if(tmpNode.leftChild == null) {
            if(tmpNode == root)
                root = tmpNode.rightChild;
            else if(isLeftChild) {
                parent.leftChild = tmpNode.rightChild;
            }
            else {
                parent.rightChild = tmpNode.rightChild;
            }
        }
        // if tmpNode has both left and right children
        else {
            Node replacement = getReplacementNode(tmpNode);

            if(tmpNode == root)
                root = replacement;
            else if(isLeftChild)
                parent.leftChild = replacement;
            else
                parent.rightChild = replacement;

            /**
             * Left-side child of the variable 'replacement' is always null,
             * because this method is designed to be acting like that.
             * Assign left-side childrent of the tmpNode (which will be deleted) to the 'replacement' node.
             */
            replacement.leftChild = tmpNode.leftChild;
        }

        return true;
    }

    /** The node which will be deleted will be replaced with the smallest node among the right-side children
     *
     *           50
     *         /    \
     *        25    75
     *       / \    / \
     *     15  30  70 85
     *    /\   / \
     *   2 18 26 32
     *
     *   If you want to delete 25, then 25 should be replaced with 26 because 26 is the smallest value of 25's right-side children.
     *   So, getReplacementNode() method will return node 26 with left child null and right child 30 - 32 like below
     *
     *      26
     *     /  \
     *   null 30
     *         \
     *         32
     */
    private Node getReplacementNode(Node willBeReplaced) {
        Node replacementParent = willBeReplaced;
        Node replacement = willBeReplaced;

        Node tmpNode = willBeReplaced.rightChild;

        while(tmpNode != null) {
            replacementParent = replacement;
            replacement = tmpNode;
            tmpNode = tmpNode.leftChild;
        }

        if(replacement != willBeReplaced.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = willBeReplaced.rightChild;
        }

        return replacement;
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
        // Creating BinaryTree
        BinaryTree bTree = new BinaryTree();

        // Adding nodes to the BinaryTree
        bTree.addNode(50);
        bTree.addNode(25);
        bTree.addNode(75);
        bTree.addNode(15);
        bTree.addNode(30);
        bTree.addNode(70);
        bTree.addNode(85);
        bTree.addNode(2);
        bTree.addNode(18);
        bTree.addNode(26);
        bTree.addNode(32);


        // Tree traversal
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


        // Deleting node
        System.out.println("\n--- Pre Order Before remove ---");
        bTree.preOrderTraverse(bTree.getRoot());

        bTree.deleteNode(25);
        System.out.println("--- Pre Order After remove ---");
        bTree.preOrderTraverse(bTree.getRoot());
    }
}
