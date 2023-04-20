public class TreeNode {
    private String word;
    private String treeAnswer;
    private TreeNode LeftChild;
    private TreeNode RightChild;
    private int height;

    public  TreeNode(String word, String treeAnswer) {
        this.word = word;
        this.treeAnswer = treeAnswer;
        this.height = 1;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTreeAnswer() {
        return treeAnswer;
    }

    public void setTreeAnswer(String treeAnswer) {
        this.treeAnswer = treeAnswer;
    }

    public TreeNode getLeftChild() {
        return LeftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        LeftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return RightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        RightChild = rightChild;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
