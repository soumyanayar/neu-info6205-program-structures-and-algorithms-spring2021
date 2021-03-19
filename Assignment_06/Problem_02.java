package Assignment_06;

import java.util.Stack;

public class Problem_02 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            while (asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int topAsteroid = stack.pop();
                int left = topAsteroid + asteroid;
                if (left == 0) {
                    asteroid = 0;
                } else if (left > 0) {
                    asteroid = topAsteroid; // Pick the largest
                }
                // else asteroid doesnot change
            }

            // If something is left
            if (asteroid != 0) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; --i) {
            result[i] = stack.pop();
        }
        return result;
    }
}
