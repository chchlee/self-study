/**
 * 레드블랙 트리를 구현하고 저장하라는 줄 알고 실수로 구현해버렸습니다.
 */
public class RedBlackTree {
    private static final int BLACK = 0;
    private static final int RED = 1;
    private Node root;

    private static class Node {
        private int value;
        private int color;
        Node left;
        Node right;
        Node parent;

        Node(int value) {
            this.value = value;
            color = BLACK;
            left = null;
            right = null;
            parent = null;
        }

        Node() {
            this(-1);
        }

        int getValue() {
            return value;
        }

        String getColor() {
            return color == RED ? "RED" : "BLACK";
        }

        void setColor(int color) {
            this.color = color;
        }
    }

    public void insertNode(int value) {
        Node node = new Node(value);

        if (root == null) {
            root = node;
        } else {
            Node parent = root;
            node.setColor(RED);

            while (true) {
                if (parent.getValue() < node.getValue()) {
                    if (parent.right == null) {
                        parent.right = node;
                        node.parent = parent;
                        break;
                    } else {
                        parent = parent.right;
                    }
                } else {
                    if (parent.left == null) {
                        parent.left = node;
                        node.parent = parent;
                        break;
                    } else {
                        parent = parent.left;
                    }
                }
            }
            recolorTree(node);
        }
    }

    private void recolorTree(Node node) {
        while (node.parent != null && "RED".equals(node.parent.getColor())) {
            Node next = null;

            if (node.parent == node.parent.parent.left) {
                next = node.parent.parent.right;

                if (next != null && "RED".equals(next.getColor())) {
                    node.parent.setColor(BLACK);
                    next.setColor(BLACK);
                    node.parent.parent.setColor(RED);
                    node = node.parent.parent;
                    continue;
                }

                if (node == node.parent.right) {
                    node = node.parent;

                    rotateLeft(node);
                }

                node.parent.setColor(BLACK);
                node.parent.parent.setColor(RED);

                rotateRight(node.parent.parent);
                break;
            } else {
                next = node.parent.parent.left;

                if (next != null && "RED".equals(next.getColor())) {
                    node.parent.setColor(BLACK);
                    next.setColor(BLACK);
                    node.parent.parent.setColor(RED);
                    node = node.parent.parent;
                    continue;
                }

                if (node == node.parent.left) {
                    node = node.parent;

                    rotateRight(node);
                }

                node.parent.setColor(BLACK);
                node.parent.parent.setColor(RED);

                rotateLeft(node.parent.parent);
                break;
            }
        }

        root.setColor(BLACK);
    }

    private void rotateLeft(Node node) {
        Node right = node.right;

        if (right == null)
            return;

        node.right = right.left;
        if (right.left != null)
            right.left.parent = node;
        right.parent = node.parent;
        if (node.parent == null)
            root = right;
        else if (node == node.parent.left)
            node.parent.left = right;
        else
            node.parent.right = right;
        right.left = node;
        node.parent = right;
    }

    private void rotateRight(Node node) {
        Node left = node.left;

        if (left == null)
            return;

        node.left = left.right;
        if (left.right != null)
            left.right.parent = node;
        left.parent = node.parent;
        if (node.parent == null)
            root = left;
        else if (node == node.parent.right)
            node.parent.right = left;
        else
            node.parent.left = left;
        left.right = node;
        node.parent = left;
    }


    public void printTree() {
        printTree(root);
    }

    private void printTree(Node node) {
        if (node == null)
            return;

        System.out.println(node.getValue() + "(" + node.getColor() + ")");
        printTree(node.left);
        printTree(node.right);
    }

    public void printDescending() {
        printDescending(root);
    }

    private void printDescending(Node node) {
        if (node == null)
            return;

        printDescending(node.right);
        System.out.print(node.getValue() + "("+node.getColor()+") ");
        printDescending(node.left);
    }


    public int sum() {
        return sum(root);
    }

    private int sum(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.getValue() + sum(node.left) + sum(node.right);
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.left) + size(node.right);
        }
    }

}

