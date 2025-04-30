// Name: Qiming Lyu

/**
 * CacheBlockQueue is a class that implements a queue of cache blocks.
 *
 * @param <T> the type of elements in this queue
 */
public class CacheBlockQueue<T> {
  private CacheBlockQueueNode<T> front;
  private CacheBlockQueueNode<T> rear;
  private int size;

  /**
   * Constructor
   */
  public CacheBlockQueue() {
    front = null;
    rear = null;
    size = 0;
  }

  /**
   * Enqueue a new element to the queue.
   *
   * @param data the data of element to be added
   */
  public void enqueue(T data) {
    // Add to an empty queue.
    if (size == 0) {
      CacheBlockQueueNode<T> newElement = new CacheBlockQueueNode<>(data, null);
      front = newElement;
      rear = newElement;
    } else {
      // Data of the rear node is the same as `data`.
      if (rear.getData() == data) {
        rear.setCount(rear.getCount() + 1);
      } else {
        // Data of the rear node is different from `data`.
        CacheBlockQueueNode<T> newElement = new CacheBlockQueueNode<>(data, null);
        rear.setNext(newElement);
        rear = newElement;
      }
    }

    // Update the size of the queue.
    size++;
  }

  /**
   * Returns the current front element of the queue without removing it.
   * Returns null if the queue is empty.
   */
  public T front() {
    return size == 0 ? null : front.getData();
  }

  /**
   * Dequeue the front element of the queue.
   * Returns null if the queue is empty.
   */
  public T dequeue() {
    // Dequeue from an empty queue.
    if (size == 0) {
      return null;
    }

    T data = front.getData();

    // Dequeue from a length-1 queue.
    if (size == 1) {
      front = null;
      rear = null;
    } else {
      // Dequeue from a queue whose first node has count = 1.
      if (front.getCount() == 1) {
        front = front.getNext();
      } else {
        // Dequeue from a queue whose first node has count > 1.
        front.setCount(front.getCount() - 1);
      }
    }

    // Update the size of the queue.
    size--;

    // Return the data of the dequeued node.
    return data;
  }

  /**
   * Returns the size of the cache block at the front of the queue.
   * Returns 0 if the queue is empty.
   */
  public int frontOfLineRepeatCount() {
    return size == 0 ? 0 : front.getCount();
  }

  /**
   * Returns the size of the queue.
   */
  public int getSize() {
    return size;
  }

  /**
   * Returns true if the queue is empty.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns a string representation of the queue.
   */
  @Override
  public String toString() {
    String retVal = "";
    CacheBlockQueueNode<T> current = front;

    while (current != null) {
      retVal += current.toString();
      current = current.getNext();
      if (current != null) {
        retVal += ", ";
      }
    }

    return retVal;
  }
}
