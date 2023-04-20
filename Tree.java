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
        return (node == null) ?  0 : node.getHeight();
    }

    int getBalance(TreeNode node) {
        return (node == null) ? 0 : height(node.getLeftChild()) - height(node.getRightChild());
    }

    public void addNode(TreeNode node) {


    }

}
