// Name: Qiming Lyu

public class CallTree {
  private CallTreeNode root;

  /**
   * Constructor for the CallTree class.
   *
   * @param rootName the name of the root node
   */
  public CallTree(String rootName) {
    this.root = new CallTreeNode(rootName);
  }

  /**
   * Finds a node by its `name` in the sub call tree given by `node`.
   *
   * @param name the name of the node to find
   *
   * @return the node if found, null otherwise
   */
  private CallTreeNode find(String name, CallTreeNode node) {
    // Marginal case
    if (node == null) {
      return null;
    }

    // Check itself
    if (node.getName().equals(name)) {
      return node;
    }

    // Check first child sub-tree
    CallTreeNode retVal = find(name, node.getFirst());
    if (retVal != null) {
      return retVal;
    }

    // Check second child sub-tree
    retVal = find(name, node.getSecond());
    return retVal;
  }

  /**
   * Finds a node by its `name` in the call tree.
   *
   * @param name the name of the node to find
   *
   * @return the node if found, null otherwise
   */
  private CallTreeNode find(String name) {
    return find(name, root);
  }

  /**
   * Checks if a person is in the call tree.
   *
   * @param person the name of the person to check
   *
   * @return true if the person is in the call tree, false otherwise
   */
  public boolean inCallTree(String person) {
    CallTreeNode node = find(person);
    return node != null;
  }

  /**
   * Helper function to check if a person is a caller.
   *
   * @param person the name of the person to check
   *
   * @return true if the person is a caller, false otherwise
   */
  private boolean isCaller(String person) {
    CallTreeNode node = find(person);
    return node.getFirst() != null || node.getSecond() != null;
  }

  /**
   * Adds two callees to a caller in the call tree given by `person`.
   *
   * @param person the name of the caller
   * @param first  the name of the first callee
   * @param second the name of the second callee
   *
   * @return true if the callees were added successfully, false otherwise.
   *         The operation fails if:
   *           - the caller is not in the call tree
   *           - the caller already has callee(s)
   *           - the callees are already in the call tree
   */
  public boolean shouldCall(String person, String first, String second) {
    // Check for failures
    if (!inCallTree(person)) {
      return false;
    }
    if (isCaller(person)) {
      return false;
    }
    if (inCallTree(first) || inCallTree(second)) {
      return false;
    }

    // Add callees
    CallTreeNode caller = find(person);
    if (first != null) {
      caller.setFirst(new CallTreeNode(first));
    }
    if (second != null) {
      caller.setSecond(new CallTreeNode(second));
    }

    return true;
  }

  /**
   * Looks up the first callee of the caller given by `name`
   *
   * @param name the name of the caller
   *
   * @return the name of the first callee if found, null otherwise
   *         The operation fails if:
   *           - the caller is not in the call tree
   *           - the named person is not a caller
   */
  public String getFirstCall(String name) {
    if (!inCallTree(name) || !isCaller(name)) {
      return null;
    }

    CallTreeNode node = find(name);
    String firstName = node.getFirst() != null ? node.getFirst().getName() : null;

    return firstName;
  }

  /**
   * Looks up the second callee of the caller given by `name`
   *
   * @param name the name of the caller
   *
   * @return the name of the second callee if found, null otherwise
   *         The operation fails if:
   *           - the caller is not in the call tree
   *           - the named person is not a caller
   */
  public String getSecondCall(String name) {
    if (!inCallTree(name) || !isCaller(name)) {
      return null;
    }

    CallTreeNode node = find(name);
    String secondName = node.getSecond() != null ? node.getSecond().getName() : null;

    return secondName;
  }

  /**
   * Helper function to calculates the height
   * of the sub call tree given by `node`.
   *
   * @param node the root of the sub call tree
   *
   * @return the height of the sub call tree
   */
  private int getHeight(CallTreeNode node) {
    if (node == null) {
      return -1;
    }

    return 1 + Math.max(
      getHeight(node.getFirst()),
      getHeight(node.getSecond())
    );
  }

  /**
   * Returns the number of rounds of calls before contacting the last person.
   */
  public int getCallCount() {
    int height = getHeight(root);
    return height;
  }

  /**
   * Helper function to count the number of terminal contacts
   * in the sub call tree given by `node`.
   *
   * @param node the root of the sub call tree
   *
   * @return the number of terminal contacts in the sub call tree
   */
  private int terminalContactCountHelper(CallTreeNode node) {
    if (node.getFirst() == null && node.getSecond() == null) {
      return 1;
    }

    return (node.getFirst() != null ? terminalContactCountHelper(node.getFirst()) : 0)
         + (node.getSecond() != null ? terminalContactCountHelper(node.getSecond()) : 0);
  }

  /**
   * Returns the number of terminal contacts in the call tree.
   */
  public int terminalContactCount() {
    int numLeaves = terminalContactCountHelper(root);
    return numLeaves;
  }







  /****************************************************
   * Main method for testing the private find method. *
   ****************************************************/
  public static void main(String[] args) {
    CallTreeNode ctn1 = new CallTreeNode("Coffee", null, null);
    CallTreeNode ctn2 = new CallTreeNode("Flute", null, null);
    CallTreeNode ctn3 = new CallTreeNode("Ready", null, null);
    CallTreeNode ctn4 = new CallTreeNode("Magic", ctn1, ctn2);
    CallTreeNode ctn5 = new CallTreeNode("Cookies", ctn3, null);
    CallTreeNode ctn6 = new CallTreeNode("Roast", ctn4, ctn5);
    CallTree ct = new CallTree("whatever");
    ct.root = ctn6;
    // all true .
    System.out.println(ctn1 == ct.find("Coffee"));
    System.out.println(ctn2 == ct.find("Flute"));
    System.out.println(ctn3 == ct.find("Ready"));
    System.out.println(ctn4 == ct.find("Magic"));
    System.out.println(ctn5 == ct.find("Cookies"));
    System.out.println(ctn6 == ct.find("Roast"));
    System.out.println(null == ct.find("Fire"));
  }
}
