# **Important Syntax Used in Java**

1. `Arrays.stream(numbers).sum();` is a Java statement that calculates the sum of all elements in an array using Java Streams. Let's break it down:

## Explanation

1. `Arrays.stream(numbers)`
    - Converts the array `numbers` into an `IntStream` (if `numbers` is an `int[]`).
    - If `numbers` is a `double[]` or `long[]`, it produces a `DoubleStream` or `LongStream`, respectively.

2. `sum()`
    - Computes the sum of all elements in the stream.

## Example Usage

```java
import java.util.Arrays;

public class Main {
     public static void main(String[] args) {
          int[] numbers = {1, 2, 3, 4, 5};
          int sum = Arrays.stream(numbers).sum();
          System.out.println("Sum: " + sum); // Output: Sum: 15
     }
}
```

## Key Points

- Works only for primitive type arrays (`int[]`, `double[]`, `long[]`).
- For `Integer[]` (wrapper class), you need to use `.mapToInt(Integer::intValue)`.

### Example:

```java
Integer[] numbers = {1, 2, 3, 4, 5};
int sum = Arrays.stream(numbers).mapToInt(Integer::intValue).sum();
```
2. `replace()` : use to replace two numbers at two different indexes

3. 
 