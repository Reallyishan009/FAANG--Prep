package Stacks;

import java.util.Stack;

public class Q8LargestRectangleinHistogram {
    
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] NSL = new int[n]; 
        int[] NSR = new int[n]; 

        //NSL:
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            NSL[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        //NSR:
        stack.clear(); // Reuse the stack
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            NSR[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

       
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = NSR[i] - NSL[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights)); // Output: 10
    }
}


//T.C=O(n)
//S.C=O(n)