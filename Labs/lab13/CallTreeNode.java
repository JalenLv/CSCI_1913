// Name: Qiming Lyu

/**
 * This class represents a node in a call tree.
 * Each node contains a name, and its first and second callees.
 */
public class CallTreeNode {
  private String name;
  private CallTreeNode first;
  private CallTreeNode second;

  /**
   * Constructors for CallTreeNode in the case of
   * no person is expected to be called.
   * 
   * @param name the name of the node
   */
  public CallTreeNode(String name) {
    this.name = name.trim();
    this.first = null;
    this.second = null;
  }

  /**
   * Constructors for CallTreeNode in the case of
   * one person is expected to be called.
   * 
   * @param name the name of the node
   * @param first the first child node
   */
  public CallTreeNode(String name, CallTreeNode first) {
    this.name = name.trim();
    this.first = first;
    this.second = null;
  }

  /**
   * Constructors for CallTreeNode in the case of
   * two people are expected to be called.
   * 
   * @param name the name of the node
   * @param first the first child node
   * @param second the second child node
   */
  public CallTreeNode(String name, CallTreeNode first, CallTreeNode second) {
    this.name = name.trim();
    this.first = first;
    this.second = second;
  }

  /**
   * Get the name of the node.
   * 
   * @return the name of the node
   */
  public String getName() {
    return name;
  }

  /**
   * Get the first child node.
   * 
   * @return the first child node
   */
  public CallTreeNode getFirst() {
    return first;
  }

  /**
   * Get the second child node.
   * 
   * @return the second child node
   */
  public CallTreeNode getSecond() {
    return second;
  }

  /**
   * Set the first child node.
   * 
   * @param first the first child node
   */
  public void setFirst(CallTreeNode first) {
    this.first = first;
  }

  /**
   * Set the second child node.
   * 
   * @param second the second child node
   */
  public void setSecond(CallTreeNode second) {
    this.second = second;
  }

  /**
   * Returns true if the node is a caller.
   *
   * @return true if the node is a caller
   */
  public boolean isCaller() {
    return first != null || second != null;
  }
}
