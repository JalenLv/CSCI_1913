// Name: Qiming Lyu

/**
 * CacheBlockQueueNode is a class that represents a node in a cache block queue.
 *
 * @param <T> the type of the data stored in the node
 */
public class CacheBlockQueueNode<T> {
  private T data;
  private int count;
  private CacheBlockQueueNode<T> next;

  /**
   * Constructor.
   */
  public CacheBlockQueueNode(T data, CacheBlockQueueNode<T> next) {
    this.data = data;
    this.next = next;
    count = 1;
  }

  /**
   * Get data of the node.
   */
  public T getData() {
    return data;
  }

  /**
   * Get count of the node.
   */
  public int getCount() {
    return count;
  }

  /**
   * Get next node.
   */
  public CacheBlockQueueNode<T> getNext() {
    return next;
  }

  /**
   * Set data of the node.
   *
   * @param data the new data to set
   */
  public void setData(T data) {
    this.data = data;
  }

  /**
   * Set count of the node.
   *
   * @param count the new count to set
   */
  public void setCount(int count) {
    this.count = count;
  }

  /**
   * Set next node.
   *
   * @param next the new next node to set
   */
  public void setNext(CacheBlockQueueNode<T> next) {
    this.next = next;
  }

  /**
   * Returns a string representation of the node.
   */
  @Override
  public String toString() {
    return data + ":" + count;
  }
}
