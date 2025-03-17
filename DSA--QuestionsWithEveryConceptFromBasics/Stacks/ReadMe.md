# Stack Basics in Java

A stack is a linear data structure that follows the Last-In-First-Out (LIFO) principle. This means the element added last is the first one to be removed. Think of it like a stack of plates - you add and remove from the top.

## Core Stack Operations

- **push()**: Adds an element to the top
- **pop()**: Removes and returns the top element
- **peek()**: Returns the top element without removing it
- **isEmpty()**: Checks if stack is empty
- **size()**: Returns the number of elements

## Implementation in Java

Java provides two main ways to implement stacks:

### 1. Using the Stack class

```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.push(20);
int top = stack.pop(); // Returns 20
```

### 2. Using ArrayDeque (recommended)

```java
import java.util.ArrayDeque;

ArrayDeque<Integer> stack = new ArrayDeque<>();
stack.push(10);
stack.push(20);
int top = stack.pop(); // Returns 20
```

Note: Java's `Stack` class is considered legacy. `ArrayDeque` is more efficient for stack operations.

## Advanced Stack Concepts

### Custom Stack Implementation

```java
public class CustomStack<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    
    public CustomStack() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    
    public void push(T element) {
        ensureCapacity();
        elements[size++] = element;
    }
    
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T element = (T) elements[--size];
        elements[size] = null; // Help GC
        return element;
    }
    
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return (T) elements[size - 1];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
```

### Thread-Safe Stacks

For concurrent applications, consider:

```java
import java.util.concurrent.ConcurrentLinkedDeque;

ConcurrentLinkedDeque<Integer> threadSafeStack = new ConcurrentLinkedDeque<>();
threadSafeStack.push(10);
Integer top = threadSafeStack.pop();
```

## Use Cases for Stacks

1. **Function call management**: Used in program execution (call stack)
2. **Expression evaluation**: Parsing arithmetic expressions
3. **Undo mechanisms**: Tracking operations for undo functionality
4. **Backtracking algorithms**: Like maze solving or game tree exploration
5. **Browser history**: Back button implementation
6. **Parentheses matching**: Validating balanced expressions
7. **Depth-First Search**: Graph traversal implementation

## Important Stack Problems

### Beginner Level
1. **Valid Parentheses**: Check if parentheses in a string are balanced
2. **Reverse a String/Array**: Using a stack to reverse elements
3. **Evaluate Postfix Expression**: Calculate result of postfix notation
4. **Next Greater Element**: Find next greater element for each array element
5. **Stock Span Problem**: Calculate how many consecutive days stock price was less than or equal to current

### Intermediate Level
1. **Infix to Postfix/Prefix Conversion**: Convert between notation forms
2. **Minimum Element in Stack**: Design stack with constant time min operations
3. **Implement Queue using Stacks**: Use two stacks to simulate queue behavior
4. **Sort a Stack**: Sort elements in a stack using only stack operations
5. **Redundant Brackets**: Check if expression contains redundant brackets

### Advanced Level
1. **Largest Rectangle in Histogram**: Find largest rectangular area in a histogram
2. **Maximum Area Rectangle in Binary Matrix**: Find largest rectangle with all 1's
3. **Celebrity Problem**: Find the person known by everyone but knows no one
4. **Longest Valid Parentheses**: Find length of longest valid substring
5. **Rain Water Trapping**: Calculate how much water can be trapped between bars

## FAANG Company Stack Questions

### Amazon
1. **Min Stack**: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time
2. **Baseball Game**: Calculate points based on operations stored in a stack
3. **Maximum Frequency Stack**: Design a stack-like data structure that pushes most frequent elements to the top

### Facebook/Meta
1. **Exclusive Time of Functions**: Calculate exclusive time of functions in a single-threaded CPU
2. **Binary Tree Right Side View**: Return values visible from right side using DFS with stack
3. **Simplify Path**: Convert a file path to canonical form

### Apple
1. **Valid Parentheses**: Validate string containing parentheses, brackets, and braces
2. **Daily Temperatures**: Find days until warmer temperature
3. **Flatten Nested List Iterator**: Flatten a nested list of integers

### Netflix
1. **Design Browser History**: Implement forward and backward navigation
2. **Decode String**: Decode string with repeated substrings
3. **Remove All Adjacent Duplicates**: Remove all adjacent duplicate characters

### Google
1. **Basic Calculator**: Implement calculator with +, -, (, and )
2. **Evaluate Reverse Polish Notation**: Evaluate expressions in postfix notation
3. **Next Greater Element**: Find next greater element for each element

When approaching these problems, remember the key stack properties:
- Only access the top element directly
- Keep track of elements in reverse order of insertion
- Most problems involve pushing elements until a condition is met, then popping

# Stack vs ArrayDeque in Java

A Stack and ArrayDeque are both data structures that can implement similar functionality, but they have important differences:

## Stack
- Based on Vector class (legacy collection)
- LIFO (Last-In-First-Out) operations
- Thread-safe but with performance overhead
- Primary methods: push(), pop(), peek()
- Less efficient due to synchronization on all operations

## ArrayDeque
- Double-ended queue implementation
- Can function as both LIFO stack and FIFO queue
- Not thread-safe but more efficient
- Methods for stack usage: addFirst()/push(), removeFirst()/pop(), peekFirst()/peek()
- Resizable array implementation with better performance

## When to use Stack:
- When thread safety is required (multiple threads accessing same collection)
- When maintaining legacy code that already uses Stack

## When to use ArrayDeque:
- For better performance in single-threaded environments
- When you need both stack and queue operations
- When you need operations on both ends of the collection
- For most new development (ArrayDeque is the recommended approach)

ArrayDeque is generally preferred in modern Java applications due to its efficiency and flexibility, unless you specifically need thread safety without adding your own synchronization.


Thread safety refers to the property of code that ensures it functions correctly when executed by multiple threads simultaneously. Here's what it means:

A thread-safe program, class, or data structure guarantees that:

- Multiple threads can access and modify shared data concurrently
- The program always maintains correct behavior and data integrity
- No unexpected results, corruption, or race conditions occur

When code isn't thread-safe, the following problems can happen:

1. **Race conditions**: When the outcome depends on the sequence or timing of threads
2. **Data corruption**: When multiple threads modify data simultaneously and overwrite each other's changes
3. **Deadlocks**: When threads wait indefinitely for resources held by each other
4. **Inconsistent states**: When an operation that should be atomic gets interrupted halfway through

Thread safety can be achieved through various mechanisms:

- **Synchronization**: Using keywords like `synchronized` in Java
- **Locks**: Manual locking mechanisms (ReentrantLock, ReadWriteLock, etc.)
- **Atomic classes**: Special classes designed for thread-safe operations
- **Immutable objects**: Objects that cannot be modified after creation
- **Thread-safe collections**: Collections specifically designed to be safe for concurrent access
- **Thread confinement**: Restricting data access to a single thread

In the case of Stack vs ArrayDeque, Stack is thread-safe because it synchronizes all its methods, making it slower but safe for multi-threaded use. ArrayDeque has no built-in synchronization, making it faster in single-threaded scenarios but requiring external synchronization if used concurrently by multiple threads.

# Thread Safety Explained Simply

Thread safety means your program works correctly when multiple parts of it are running at the same time. Let me explain with some everyday examples:

## A Non-Thread-Safe Example: Shared Bathroom

Imagine a bathroom in your house with no lock:
- Person 1 opens the door and starts using it
- Person 2 doesn't know it's occupied and walks in
- Chaos and embarrassment ensue!

This is like code that isn't thread-safe. Multiple threads (people) try to use the same resource (bathroom) at the same time, causing problems.

## A Thread-Safe Example: Bank Line

Think of a bank with a ticket system:
- Each person takes a numbered ticket
- Only one person approaches the teller at a time
- Everyone gets served in order without confusion

This is like thread-safe code. The system ensures orderly access to a shared resource.

## Real Programming Examples

**Non-Thread-Safe:**
```java
// Shared counter without protection
int counter = 0;

// Thread 1 runs this:
counter = counter + 1;

// Thread 2 runs this at the same time:
counter = counter + 1;
```

The final value might be 1 instead of 2 because both threads might read the original value (0) before either updates it.

**Thread-Safe:**
```java
// Using synchronization for protection
synchronized void incrementCounter() {
    counter = counter + 1;
}

// Thread 1 calls incrementCounter()
// Thread 2 must wait until Thread 1 finishes
```

## Real-World Applications

- **Online shopping cart**: If not thread-safe, two people using the same account might overwrite each other's items
- **Banking app**: Thread safety ensures your balance doesn't get corrupted when multiple transactions happen at once
- **Airline booking system**: Prevents two people from booking the same seat simultaneously

In simple terms, thread safety is like having traffic lights at an intersection - it prevents crashes when multiple operations try to happen at the same time.