public class CacheBlockQueueTest {
  public static void main(String[] args) {
    ///////////////////////////////////////////////////////////////
    System.out.println("Test initial conditions and constructor.");
    ///////////////////////////////////////////////////////////////

    CacheBlockQueue<String> rq = new CacheBlockQueue<String>();
    System.out.println(rq.front() == null); // true
    System.out.println(rq.dequeue() == null); // true
    System.out.println(rq.getSize()); // 0
    System.out.println(rq.frontOfLineRepeatCount()); // 0
    System.out.println(rq.isEmpty()); // true
    System.out.println(rq.dequeue() == null); // true
    System.out.println(rq.getSize()); // 0
    String tos = rq.toString();
    System.out.println(tos); // <nothing should be printed>
    System.out.println(tos.length()); // 0

    ///////////////////////////////////////////////
    System.out.println("Test non-CacheBlock behavior.");
    ///////////////////////////////////////////////

    rq.enqueue("apple");
    System.out.println(rq.isEmpty()); // false
    System.out.println(rq.getSize()); // 1
    System.out.println(rq.frontOfLineRepeatCount()); // 1
    System.out.println(rq.front()); // apple
    System.out.println(rq.toString()); // apple:1
    System.out.println("apple:1".equals(rq.toString())); // true

    rq.enqueue("banana");
    System.out.println(rq.isEmpty()); // false
    System.out.println(rq.getSize()); // 2
    System.out.println(rq.frontOfLineRepeatCount()); // 1
    System.out.println(rq.front()); // apple
    System.out.println(rq.toString()); // apple:1, banana:1
    System.out.println("apple:1, banana:1".equals(rq.toString())); // true

    System.out.println(rq.dequeue()); // apple
    System.out.println(rq.isEmpty()); // false
    System.out.println(rq.getSize()); // 1
    System.out.println(rq.frontOfLineRepeatCount()); // 1
    System.out.println(rq.front()); // banana
    System.out.println(rq.toString()); // banana:1
    System.out.println("banana:1".equals(rq.toString())); // true

    rq.enqueue("apple");
    rq.enqueue("pear");
    rq.enqueue("banana");
    System.out.println(rq.getSize()); // 4
    System.out.println(rq.front()); // banana
    System.out.println(rq.toString()); // banana:1, apple:1, pear:1, banana:1
    System.out.println("banana:1, apple:1, pear:1, banana:1".equals(rq.toString())); // true

    System.out.println(rq.dequeue()); // banana
    System.out.println(rq.dequeue()); // apple
    System.out.println(rq.dequeue()); // pear
    System.out.println(rq.dequeue()); // banana
    System.out.println(rq.front() == null); // true
    System.out.println(rq.dequeue() == null); // true
    System.out.println(rq.getSize()); // 0
    System.out.println(rq.frontOfLineRepeatCount()); // 0
    System.out.println(rq.isEmpty()); // true
    System.out.println(rq.dequeue() == null); // true
    System.out.println(rq.getSize()); // 0
    tos = rq.toString();
    System.out.println(tos); // <nothing should be printed>
    System.out.println(tos.length()); // 0

    rq.enqueue("apple");
    rq.enqueue("pear");
    System.out.println(rq.dequeue()); // apple
    System.out.println(rq.dequeue()); // pear
    System.out.println(rq.isEmpty()); // true

    ///////////////////////////////////////////
    System.out.println("Test CacheBlock behavior.");
    ///////////////////////////////////////////

    for (int i = 0; i < 10; i++) {
      rq.enqueue("apple");
    }
    for (int i = 0; i < 13; i++) {
      rq.enqueue("pear");
    }
    for (int i = 0; i < 4; i++) {
      rq.enqueue("apple");
    }
    for (int i = 0; i < 2; i++) {
      rq.enqueue("banana");
    }
    System.out.println(rq.front()); // apple
    System.out.println(rq.frontOfLineRepeatCount()); // 10
    System.out.println(rq.getSize()); // 29
    System.out.println(rq.toString()); // apple:10, pear:13, apple:4, banana:2

    for (int i = 0; i < 8; i++) {
      if (!rq.dequeue().equals("apple")) {
        System.out.println("Test fail - wrong dequue");
      }
    }
    System.out.println(rq.front()); // apple
    System.out.println(rq.frontOfLineRepeatCount()); // 2
    System.out.println(rq.getSize()); // 21
    System.out.println(rq.toString()); // apple:2, pear:13, apple:4, banana:2
    for (int i = 0; i < 2; i++) {
      if (!rq.dequeue().equals("apple")) {
        System.out.println("Test fail - wrong dequue");
      }
    }
    for (int i = 0; i < 12; i++) {
      if (!rq.dequeue().equals("pear")) {
        System.out.println("Test fail - wrong dequue");
      }
    }
    System.out.println(rq.front()); // pear
    System.out.println(rq.frontOfLineRepeatCount()); // 1
    System.out.println(rq.getSize()); // 7
    System.out.println(rq.toString()); // pear:1, apple:4, banana:2

    int count = 0;
    while (!rq.isEmpty()) {
      count++;
      rq.dequeue();
    }
    System.out.println(count); // 7
    rq.enqueue("banana");
    System.out.println(rq.dequeue()); // banana
  }
}
/*
 * 
 * Test initial conditions and constructor.
 * true
 * true
 * 0
 * 0
 * true
 * true
 * 0
 * 
 * 0
 * Test non-CacheBlock behavior.
 * false
 * 1
 * 1
 * apple
 * apple:1
 * true
 * false
 * 2
 * 1
 * apple
 * apple:1, banana:1
 * true
 * apple
 * false
 * 1
 * 1
 * banana
 * banana:1
 * true
 * 4
 * banana
 * banana:1, apple:1, pear:1, banana:1
 * true
 * banana
 * apple
 * pear
 * banana
 * true
 * true
 * 0
 * 0
 * true
 * true
 * 0
 * 
 * 0
 * apple
 * pear
 * true
 * Test CacheBlock behavior.
 * apple
 * 10
 * 29
 * apple:10, pear:13, apple:4, banana:2
 * apple
 * 2
 * 21
 * apple:2, pear:13, apple:4, banana:2
 * pear
 * 1
 * 7
 * pear:1, apple:4, banana:2
 * 7
 * banana
 */
