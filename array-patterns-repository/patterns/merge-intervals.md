Concept

The Merge Intervals pattern is used to deal with overlapping intervals. This pattern is commonly used when solving problems related to scheduling, merging ranges, or identifying free time slots.

When to Use?

Merging overlapping intervals (e.g., meeting times, reservations).
Finding gaps between intervals (e.g., free time in schedules).
Detecting interval conflicts in reservations or bookings.
### Template Code
```java
import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        
        // Step 1: Sort intervals based on start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            // If merged list is empty or no overlap, add the interval
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Merge overlapping intervals
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}

```

### Example Problems

Leetcode 56 - Merge Intervals
Leetcode 57 - Insert Interval
Leetcode 435 - Non-overlapping Intervals
Leetcode 252 - Meeting Rooms
