// Name: Qiming Lyu

/**
 * The Trie class manages a trie data structure and
 * provides interface on data storage.
 */
public class Trie<T> {
  private TrieNode<T> root;

  /**
   * Constructor.
   */
  public Trie() {
    root = new TrieNode<T>();
  }

  /**
   * Returns the node given by the string.
   *
   * Since the function calls TrieNode.getChild(char letter),
   * it creates the nodes along the path if they do not exist.
   *
   * @param s the string representing the path to the node
   *
   * @return the node given by the string
   */
  private TrieNode<T> getNode(String s) {
    TrieNode<T> retVal = root;

    for (char c : s.toCharArray()) {
      retVal = retVal.getChild(c);
    }

    return retVal;
  }

  /**
   * Returns the data currently stored in the TrieNode given by the string.
   *
   * Since the function calls Trie.getNode(String s),
   * it creates the nodes along the path if they do not exist and returns null.
   *
   * @param s the string representing the path to the node
   *
   * @return the data stored in the given TrieNode
   */
  public T get(String s) {
    return getNode(s).getData();
  }

  /**
   * Sets the data in the TrieNode given by the string.
   *
   * Since the function calls Trie.getNode(String s),
   * it creates the nodes along the path if they do not exist.
   *
   * @param s the string representing the path to the node
   *
   * @return the data previously stored in the given TrieNode
   */
  public T put(String s, T data) {
    TrieNode<T> node = getNode(s);

    T retVal = node.getData();
    node.setData(data);

    return retVal;
  }
}
