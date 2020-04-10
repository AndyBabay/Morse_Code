
public class TreeNode<T> extends java.lang.Object {

	T dataNode;

	TreeNode<T> leftChild;
	TreeNode<T> rightChild;

	public TreeNode(T dataNode) {
		this.dataNode = dataNode;
		leftChild = null;
		rightChild = null;
	}

	public TreeNode(TreeNode<T> node) {
		new TreeNode<T>(node);

	}

	public T getData() {
		return dataNode;
	}

	public void setData(T data) {
		this.dataNode = data;
	}

}
