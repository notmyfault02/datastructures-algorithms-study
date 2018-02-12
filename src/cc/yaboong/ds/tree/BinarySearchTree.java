package cc.yaboong.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

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
public class BinarySearchTree {
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
            Node focusNode = root;
            Node parent;

            while(true) {
                parent = focusNode;

                if (key < parent.key) {
                    focusNode = parent.leftChild;

                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = parent.rightChild;

                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean deleteNode(int key) {
        // focusNode 와 parent 가 같을 수 있는 경우는 찾으려는 key 가 root 인 경우
        Node focusNode = root;
        Node parent = root;

        boolean isLeftChild = true;

        // while 문이 끝나고 나면 focusNode 는 삭제될 노드를 가리키고, parent 는 삭제될 노드의 부모노드를 가리키게 되고, 삭제될 노드가 부모노드의 left 인지 right 인지에 대한 정보를 가지게 된
        while(focusNode.key != key) {
            parent = focusNode;

            if(key < focusNode.key) {
                isLeftChild = true;
                focusNode = parent.leftChild;
            } else {
                isLeftChild = false;
                focusNode = parent.rightChild;
            }

            // Not found
            if(focusNode == null) {
                return false;
            }
        }


        /**
         * Below if statement is for after the focusNode which will be deleted is being found.
         * At this point, variable 'parent' is a parent node of the focusNode.
         */

        // if focusNode has no children. (Draw a tree and just follow the code)
        if(focusNode.leftChild == null && focusNode.rightChild == null) {
            if (focusNode == root) {
                root = null;
            } else if(isLeftChild) {
                parent.leftChild = null; // deleting focusNode
            } else {
                parent.rightChild = null; // deleting focusNode
            }
        }
        // if focusNode has no right-side children. (Draw a tree and just follow the code)
        else if(focusNode.rightChild == null) {
            if(focusNode == root)
                root = focusNode.leftChild;
            else if(isLeftChild) {
                parent.leftChild = focusNode.leftChild;
            }
            else {
                parent.rightChild = focusNode.leftChild;
            }
        }
        // if focusNode has no left-side children. (Draw a tree and just follow the code)
        else if(focusNode.leftChild == null) {
            if(focusNode == root)
                root = focusNode.rightChild;
            else if(isLeftChild) {
                parent.leftChild = focusNode.rightChild;
            }
            else {
                parent.rightChild = focusNode.rightChild;
            }
        }

        /** focusNode 가 leftChild, rightChild 모두 가지고 있을 경우
         * The node which will be deleted will be replaced with the smallest node among the right-side children
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
         *
         *           50
         *         /    \
         *       *26    75
         *       / \    / \
         *     15  30  70 85
         *    /\   / \
         *   2 18 *  32
         */
        else {
            Node rightSubTree = focusNode.rightChild;
            Node replacementNode = getRightMinNode(focusNode.rightChild);

            if (focusNode == root) {
                root = replacementNode;
            }
            else if (isLeftChild) {
                parent.leftChild = replacementNode;
            } else {
                parent.rightChild = replacementNode;
            }


            replacementNode.rightChild = rightSubTree;
            if (replacementNode.key == rightSubTree.key) {
                replacementNode.rightChild = null;
            }

            replacementNode.leftChild = focusNode.leftChild;
        }

        return true;
    }

    private Node getRightMinNode(Node rightChildRoot) {
        Node parent = rightChildRoot;
        Node focusNode = rightChildRoot;

        while (focusNode.leftChild != null) {
            parent = focusNode;
            focusNode = focusNode.leftChild;
        }

        parent.leftChild = null;
        return focusNode;
    }

    public void inOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverse(focusNode.leftChild);
            System.out.print(focusNode.key + " ");
            inOrderTraverse(focusNode.rightChild);
        }
    }

    public void preOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            System.out.print(focusNode.key + " ");
            preOrderTraverse(focusNode.leftChild);
            preOrderTraverse(focusNode.rightChild);
        }
    }

    public void postOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverse(focusNode.leftChild);
            postOrderTraverse(focusNode.rightChild);
            System.out.print(focusNode.key + " ");
        }
    }

    public Node findNode(int key) {
        Node focusNode = root;

        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }

            if (focusNode == null)
                return null;
        }

        return focusNode;
    }

    public void BFS()
    {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(n.key + " ");
            if (n.leftChild !=null)
                q.offer(n.leftChild);
            if (n.rightChild !=null)
                q.offer(n.rightChild);
        }
    }

    public static void main(String[] args) {
        // Creating BinarySearchTree
        BinarySearchTree bTree = new BinarySearchTree();

        // Adding nodes to the BinarySearchTree
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
        bTree.inOrderTraverse(bTree.getRoot());
        System.out.println("\n");

        System.out.println("---------- Pre Order Traversal ----------");
        bTree.preOrderTraverse(bTree.getRoot());
        System.out.println("\n");

        System.out.println("---------- Post Order Traversal ----------");
        bTree.postOrderTraverse(bTree.getRoot());
        System.out.println("\n");

        System.out.println("---------- Find Node ----------");
        Node found = bTree.findNode(25);
        System.out.println(found == null ? "not exists" : found);
        System.out.println("\n");

        // Deleting node
        System.out.println("---------- Delete Node Test ----------");
        bTree.deleteNode(15);
        bTree.BFS();
        System.out.println();
    }
}
