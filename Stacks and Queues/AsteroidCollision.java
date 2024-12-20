import java.util.*;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        // Stack to simulate the asteroid collisions
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            boolean destroyed = false;
            
            // Process the current asteroid
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                // Collision: stack.peek() is moving right, asteroid is moving left
                int top = stack.peek();
                
                if (Math.abs(asteroid) > Math.abs(top)) {
                    // The current asteroid is larger and destroys the stack's asteroid
                    stack.pop();
                    continue; // Check for further collisions
                } else if (Math.abs(asteroid) == Math.abs(top)) {
                    // Both asteroids are of the same size and destroy each other
                    stack.pop();
                }
                
                // The current asteroid is destroyed, no need to push it to the stack
                destroyed = true;
                break;
            }
            
            // If asteroid is not destroyed, push it onto the stack
            if (!destroyed) {
                stack.push(asteroid);
            }
        }
        
        // Convert the stack to an array for the result
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }

    public static void main(String[] args) {
        AsteroidCollision ac = new AsteroidCollision();
        int[] asteroids = {5, 10, -5}; // Example input
        int[] result = ac.asteroidCollision(asteroids);
        
        // Print the result
        for (int asteroid : result) {
            System.out.print(asteroid + " ");
        }
    }
}
