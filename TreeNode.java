//exteds huffman to give it access to the symbol and frequency
public class TreeNode extends Huffman
{
  private TreeNode leftChild;
  private TreeNode rightChild;

  public TreeNode(char symbol, int frequency)
  {
    super(symbol,frequency);
    // Initializes tree node with item and no children.
    leftChild  = null;
    rightChild = null;
  }  // end constructor

  public TreeNode(char symbol, int frequency, TreeNode left, TreeNode right)
  {
  // Initializes tree node with item and
  // the left and right children references.
    super(symbol,frequency);
    leftChild  = left;
    rightChild = right;
  }  // end constructor

  public TreeNode getLeft()
  {
  // Returns the reference to the left child.
    return leftChild;
  }  // end getLeft

  public void setLeft(TreeNode left)
  {
  // Sets the left child reference to left.
    leftChild  = left;
  }  // end setLeft

  public TreeNode getRight()
  {
  // Returns the reference to the right child.
    return rightChild;
  }  // end getRight

  public void setRight(TreeNode right)
  {
  // Sets the right child reference to right.
    rightChild  = right;
  }  // end setRight
}  // end TreeNode