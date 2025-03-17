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

3. * Why Use Character.toUpperCase() Instead of String.toUpperCase()? *
- `String.toUpperCase()` converts the entire string to uppercase.
- `Character.toUpperCase()` converts only one character, which is useful for capitalizing just the first letter.

4. `stream()`
-This line converts an `ArrayList<Integer>` (`result`) into a primitive `int[]` array in Java.

### Step-by-Step Explanation:

1️⃣ **result.stream()**

- Converts the `ArrayList<Integer>` into a `Stream<Integer>`.
- A stream is a sequence of elements that supports functional-style operations (e.g., mapping, filtering).

2️⃣ **.mapToInt(i -> i)**

- `mapToInt(i -> i)` is a mapping function that converts each `Integer` to `int`.
- Java’s Stream API does not directly support conversion from `Stream<Integer>` to `int[]`.
- The `.mapToInt(i -> i)` function transforms the `Stream<Integer>` into an `IntStream` (specialized stream for `int` values).

**Why do we need mapToInt?**

- `Stream<Integer>` contains `Integer` objects (wrapper class).
- `.mapToInt(i -> i)` unwraps the `Integer` objects into primitive `int` values.
- This removes unnecessary boxing and unboxing, making it memory efficient.

3️⃣ **.toArray()**

- Converts the `IntStream` into a primitive `int[]` array.
- Unlike `List.toArray()` (which returns an `Object[]`), this method gives a direct `int[]` output.

### Example Breakdown

**Example Input:**


