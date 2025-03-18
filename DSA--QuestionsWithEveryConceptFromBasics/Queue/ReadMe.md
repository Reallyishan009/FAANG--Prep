# Queue Data Structure in Java

A queue is a fundamental data structure that follows the First-In-First-Out (FIFO) principle, where the first element added is the first one to be removed. Let's explore queues in Java in detail.

## Core Queue Concepts

### Basic Definition
A queue represents a collection of elements maintained in a sequence, where elements are inserted at one end (rear) and removed from the other end (front).

### Key Operations
- **Enqueue (add)**: Insert an element at the rear
- **Dequeue (remove)**: Remove an element from the front
- **Peek (element)**: View the front element without removing it
- **isEmpty**: Check if the queue is empty
- **isFull**: Check if the queue is full (for bounded queues)
- **size**: Get the number of elements in the queue

### Queue Interface in Java
In Java, `Queue` is an interface that extends the `Collection` interface. The primary methods include:
- `add(E e)`: Adds element, throws exception if full
- `offer(E e)`: Adds element, returns false if full
- `remove()`: Removes and returns head, throws exception if empty
- `poll()`: Removes and returns head, returns null if empty
- `element()`: Retrieves head, throws exception if empty
- `peek()`: Retrieves head, returns null if empty

## Implementation Types

### Array-based Implementation
Uses an array to store elements with variables tracking the front and rear positions.

```java
public class ArrayQueue<E> {
    private Object[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
    
    public int size() {
        return size;
    }
    
    public void enqueue(E item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }
    
    @SuppressWarnings("unchecked")
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        E item = (E) queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        size--;
        return item;
    }
    
    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return (E) queue[front];
    }
}
```

### Linked List Implementation
Uses a linked list to store elements, naturally supporting dynamic sizing.

```java
public class LinkedListQueue<E> {
    private static class Node<E> {
        E data;
        Node<E> next;
        
        Node(E data) {
            this.data = data;
        }
    }
    
    private Node<E> front;
    private Node<E> rear;
    private int size;
    
    public LinkedListQueue() {
        front = null;
        rear = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public void enqueue(E item) {
        Node<E> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }
    
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        E item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return item;
    }
    
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }
}
```

### Java Standard Library Implementations

1. **LinkedList**: Implements both `Queue` and `Deque`
   ```java
   Queue<String> queue = new LinkedList<>();
   ```

2. **ArrayDeque**: More efficient than LinkedList for queue operations
   ```java
   Queue<String> queue = new ArrayDeque<>();
   ```

3. **PriorityQueue**: Elements processed according to natural ordering or Comparator
   ```java
   Queue<Integer> priorityQueue = new PriorityQueue<>();
   ```

4. **ConcurrentLinkedQueue**: Thread-safe implementation without locks
   ```java
   Queue<String> concurrentQueue = new ConcurrentLinkedQueue<>();
   ```

5. **BlockingQueue** implementations:
   - `ArrayBlockingQueue`: Bounded queue backed by array
   - `LinkedBlockingQueue`: Optionally bounded queue backed by linked nodes
   - `PriorityBlockingQueue`: Priority queue with blocking retrieval
   - `DelayQueue`: Queue of delayed elements
   - `SynchronousQueue`: Each insert operation waits for a corresponding remove

## Special Queue Types

### Circular Queue
An optimized array-based implementation that reuses array space. When the array appears full but elements have been removed from the front, the queue "wraps around" to reuse those spaces.

```java
public class CircularQueue<E> {
    private Object[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    // Implementation similar to ArrayQueue with circular logic
}
```

### Deque (Double-Ended Queue)
Allows insertion and deletion at both ends.

```java
Deque<String> deque = new ArrayDeque<>();
deque.addFirst("First");
deque.addLast("Last");
String first = deque.removeFirst();
String last = deque.removeLast();
```

### Priority Queue
Orders elements according to their natural ordering or by a supplied Comparator.

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
// or with custom comparator
PriorityQueue<Task> taskQueue = new PriorityQueue<>(
    (t1, t2) -> t1.getPriority() - t2.getPriority()
);
```

## Practice Problems (Basic to Advanced)

### Basic Problems

1. **Implement a Queue using Arrays**
   - Create basic enqueue, dequeue operations
   - Handle queue overflow and underflow

2. **Implement a Queue using Linked List**
   - Focus on maintaining front and rear pointers
   - Handle empty queue cases properly

3. **Implement a Circular Queue**
   - Implement with wrap-around technique
   - Handle full/empty state detection

4. **Implement Stack using Queues**
   - Use two queues to implement stack operations
   - Optimize push or pop operation

5. **Reverse a Queue**
   - Without using other data structures
   - Using recursion or stack

### Intermediate Problems

6. **Generate Binary Numbers from 1 to n**
   - Use a queue to generate binary representations
   - Example: For n=5, generate ["1", "10", "11", "100", "101"]

7. **Implement k Queues in a Single Array**
   - Efficiently implement multiple queues in one array
   - Minimize wasted space

8. **Level Order Traversal of Binary Tree**
   - Using queue to process nodes level by level
   - Return result as list of levels

9. **Sliding Window Maximum**
   - Find maximum in each sliding window of size k
   - Use a deque for efficient tracking

10. **Rotting Oranges**
    - Simulate rot spreading using a queue
    - Find minimum time for all oranges to rot

### Advanced Problems

11. **Queue Reconstruction by Height**
    - Given people's heights and number of people in front who are taller
    - Reconstruct the queue

12. **Design a Hit Counter**
    - Track hits in last 5 minutes
    - Support efficient operations under high throughput

13. **Design a LRU Cache**
    - Implement get and put operations with O(1) complexity
    - Use queue to track least recently used items

14. **Implement a Circular Deque**
    - Support insertFront, insertLast, deleteFront, deleteLast
    - Handle circular wraparound efficiently

15. **Task Scheduler**
    - Schedule tasks with cooldown period between same-task executions
    - Minimize total time needed

## FAANG Queue Interview Questions

### Amazon
1. **Design a First Non-Repeating Character Stream**
   - Process a stream of characters
   - At any point, find the first non-repeating character

2. **Maximum of All Subarrays of Size K**
   - Find maximum element in each sliding window of size k
   - Optimize using a deque

### Google
1. **Design Snake Game**
   - Use queue to track snake body positions
   - Handle movement and growth

2. **Design File System**
   - Use queues for breadth-first traversal
   - Support path operations efficiently

### Facebook (Meta)
1. **Serialize and Deserialize Binary Tree**
   - Use level-order traversal with queue
   - Handle null nodes properly

2. **Continuous Median Handler**
   - Design a system to find median of numbers processed so far
   - Use priority queues (min-heap and max-heap)

### Apple
1. **Design a Moving Average Data Structure**
   - Calculate moving average of last n integers
   - Maintain a queue of size n

2. **Course Schedule**
   - Given prerequisite relationships, find a valid course order
   - Use queue for topological sort

### Netflix
1. **Rate Limiter**
   - Design a rate limiter to restrict API calls
   - Use queue to track request timestamps

2. **Recent API Calls Counter**
   - Count calls made in last few seconds
   - Use queue to manage sliding window efficiently

### Microsoft
1. **Binary Tree Right Side View**
   - Return values visible from right side of tree
   - Use level-order traversal with queue

2. **Design Twitter**
   - Implement a simplified Twitter with follow and newsfeed
   - Use priority queues for top tweets

## Time and Space Complexity Analysis

### Array-based Queue
- Enqueue/Dequeue: O(1) time
- Space: O(n) where n is capacity
- Drawback: Fixed size

### Linked List Queue
- Enqueue/Dequeue: O(1) time
- Space: O(n) where n is number of elements
- Advantage: Dynamic size

### Priority Queue
- Enqueue/Dequeue: O(log n) time
- Space: O(n)
- Heap-based implementation ensures efficient priority management

## Common Queue Applications

1. **BFS (Breadth-First Search)**
   - Traversal of graphs and trees level by level

2. **CPU Scheduling**
   - Managing processes based on priority

3. **IO Buffers**
   - Managing data transfer between devices

4. **Producer-Consumer Problems**
   - Using BlockingQueue for thread synchronization

5. **Web Server Request Management**
   - Handling concurrent client requests

