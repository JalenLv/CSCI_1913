// Name: Qiming Lyu

/**
 * TrieNode class represents a node in a trie data structure.
 */
public class TrieNode<T> {
  private T data;
  private TrieNode<T>[] children;

  /**
   * Constructor for TrieNode.
   */
  public TrieNode() {
    data = null;
    children = new TrieNode[26];
  }

  /**
   * Returns the data stored in this node.
   *
   * @return the data stored in this node
   */
  public T getData() {
    return data;
  }

  /**
   * Sets the data stored in this node.
   *
   * @param data the data to be stored in this node
   */
  public void setData(T data) {
    this.data = data;
  }

  /**
   * Returns the child node corresponding to the given letter.
   *
   * Returns null if given a letter that is not an lowercase English letter.
   * If the corresponding child node does not exist, it will be created.
   *
   * @param letter the letter associated with the child node
   *
   * @return the child node corresponding to the given letter
   */
  public TrieNode<T> getChild(char letter) {
    if (!isLetter(letter)) {
      return null;
    }

    int index = letter - 'a';
    if (children[index] == null) {
      children[index] = new TrieNode<T>();
    }
    return children[index];
  }

  /**
   * Returns the number of nodes in the sub-tree rooted at this node.
   *
   * @return the number of nodes in the sub-tree rooted at this node
   */
  public int getTreeSize() {
    int retVal = 1;

    for (TrieNode<T> child : children) {
      retVal += (child != null) ? child.getTreeSize() : 0;
    }

    return retVal;
  }

  /**
   * Checks if the character is an English alphabet letter (a-z or A-Z).
   *
   * @param c the character to check
   *
   * @return true if the character is a letter, false otherwise
   */
  private boolean isLetter(char c) {
    return (c >= 'a' && c <= 'z');
  }
}
