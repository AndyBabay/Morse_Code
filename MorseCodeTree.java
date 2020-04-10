import java.util.ArrayList;

/**
 * 
 * 
 * implementing the Tree class
 * 
 * @author AndyBabay
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	private TreeNode<String> root = null;

	private String retriever;

	/**
	 * Constructor -a simple call of the buildTree method
	 * 
	 */
	public MorseCodeTree() {
		buildTree();
	}

	/**
	 *
	 * This method addNodes a new node to a tree and it accounts for a variety of
	 * circumstnaces
	 * 
	 * @param root
	 *            the root of the tree
	 * 
	 * @param code
	 *            the code to change
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {

		TreeNode<String> focusNode = root;

		if (code.length() == 1) {
			if (code.equals(".")) {
				focusNode.leftChild = new TreeNode<String>(letter);
			} else if (code.equals("-")) {
				focusNode.rightChild = new TreeNode<String>(letter);
			}
			return;
		} else {
			if (code.substring(0, 1).equals(".")) {
				addNode(focusNode.leftChild, code.substring(1), letter);

			} else if (code.substring(0, 1).equals("-")) {
				addNode(focusNode.rightChild, code.substring(1), letter);

			}

		}
	}

	/**
	 * Returns a reference to the root
	 * 
	 * @return get the root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	/**
	 * set the root
	 * 
	 * @param newNode
	 *            the new node
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {

		root = newNode;

	}

	/**
	 * call the method addNode to insert a method
	 * 
	 * @param code
	 *            code that will be added
	 * @param letter
	 *            letter of the new node
	 * @return a reference to an object
	 */
	@Override
	public MorseCodeTree insert(String code, String letter) {
		addNode(root, code, letter);
		return this;
	}

	/**
	 * fetch the data
	 * 
	 * @param code
	 *            the code to fetch
	 * @return the letter to fetch
	 */
	@Override
	public String fetch(String code) {

		String fetcher = fetchNode(root, code);
		return fetcher;

	}

	/**
	 * recusrsively fetch a node in the tree
	 * 
	 * @param root
	 *            the root of the tree
	 * @param code
	 *            the code to traverse
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {

		TreeNode<String> focusNode = root;

		if (code.length() == 1) {
			if (code.equals(".")) {
				retriever = focusNode.leftChild.getData();
			} else if (code.equals("-")) {
				retriever = focusNode.rightChild.getData();
			}
		} else {
			if (code.substring(0, 1).equals(".")) //
			{
				fetchNode(focusNode.leftChild, code.substring(1));
			} else if (code.substring(0, 1).equals("-")) {
				fetchNode(focusNode.rightChild, code.substring(1));

			}
		}
		return retriever;
	}

	/**
	 * Returns an arrayList with LNR of a treet
	 * 
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<String>();

		LNRoutputTraversal(root, list);

		return list;
	}

	/**
	 * NOT SUPPORTED
	 * 
	 * @param data
	 *            data of node
	 * @return null nothing
	 */
	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		return null;
	}

	/**
	 * NOT SUPPORTED
	 * 
	 * @throws UnsupportedOperationException
	 *             not supported
	 * @return null nothing
	 */
	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		return null;
	}

	/**
	 * recursively traverse a tree in LNR
	 * 
	 * @param root
	 *            the root of the tree
	 * @param list
	 *            hold the contents in a list
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root != null) {

			TreeNode<String> focusNode = root;
			LNRoutputTraversal(focusNode.leftChild, list);
			list.add(focusNode.getData());
			LNRoutputTraversal(focusNode.rightChild, list);
		}

	}

	/**
	 * builds a tree with the alphabet corresponding to morse code
	 * 
	 */
	@Override
	public void buildTree() {

		root = new TreeNode<String>("");

		insert(".", "e");
		insert("-", "t");

		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");

		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");

		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

}
