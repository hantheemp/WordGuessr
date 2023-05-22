package week01;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public int height(TreeNode node) {
        return (node == null) ?  -1 : node.getHeight();
    }

    public void newHeight(TreeNode node) {
        node.setHeight(1 + Math.max(height(node.getLeftChild()), height(node.getRightChild())));
    }

    int getBalance(TreeNode node) {
        return (node == null) ? 0 : height(node.getLeftChild()) - height(node.getRightChild());
    }
    public TreeNode rotateRight(TreeNode root) {
        TreeNode leftChild = root.getLeftChild();
        TreeNode rightOfLeft = leftChild.getRightChild();

        leftChild.setRightChild(root);
        root.setLeftChild(rightOfLeft);
        newHeight(root);
        newHeight(leftChild);
        return leftChild;
    }

    public TreeNode rotateLeft(TreeNode root) {
        TreeNode rightChild = root.getRightChild();
        TreeNode leftOfRight = rightChild.getLeftChild();

        rightChild.setLeftChild(root);
        root.setRightChild(leftOfRight);
        newHeight(root);
        newHeight(rightChild);
        return rightChild;
    }

    public TreeNode rebalance(TreeNode node) {
        newHeight(node);
        int balance = getBalance(node);

        if(balance > 1) {
            if(height(node.getLeftChild().getLeftChild()) > height(node.getLeftChild().getRightChild())) {
                rotateRight(node);
            }
            else {
                node.setLeftChild(rotateRight(node.getLeftChild()));
            }
        }
        else if (balance < -1) {
            if(height(node.getRightChild().getRightChild()) > height(node.getLeftChild().getLeftChild())) {
                rotateLeft(node);
            }
            else {
                node.setRightChild(rotateLeft(node.getRightChild()));
                rotateLeft(node);
            }

        }

        return node;

    }

    public TreeNode addNode(TreeNode node, int number) {
        if(node == null) return new TreeNode("null", "null", number);
        else if (node.getNumber() > number) {
            node.setRightChild(addNode(node.getRightChild(), number));
        }
        else if (node.getNumber() < number) {
            node.setLeftChild(addNode(node.getLeftChild(), number));
        }
        else throw new RuntimeException("Another node with the same number already exists.");

        return rebalance(node);
    }

    public TreeNode find(Tree tree, int number) {
        TreeNode current = tree.getRoot();
        while (current != null) {
            if (current.getNumber() == number) {
                break;
            }
            current = current.getNumber() < number ? current.getLeftChild() : current.getRightChild();
        }
        return current;
    }
}
