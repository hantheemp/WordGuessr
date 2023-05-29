package week01;

public class TreeNode {
	private String word;
	private String treeAnswer;
	private TreeNode LeftChild;
	private TreeNode RightChild;

	private int number;
	private int height;

	public TreeNode(String word, String treeAnswer, int number) {
		this.word = word;
		this.treeAnswer = treeAnswer;
		this.height = 1;
		this.number = number;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
