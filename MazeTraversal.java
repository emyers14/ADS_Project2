/*
 * Name: Ethan Myers
 * Instructor: Dr. Young J Kim
 * Course: Algorithms and Data Structures
 * Due Date: 09/25/2024
 */

package com.example.mazetraversal;

import java.util.ArrayList;
import java.util.List;

public class MazeTraversal {
    
    // Method to traverse the maze starting from (0, 0) to (numRows - 1, numCols - 1)
    public static List<Integer> location(int[][] grid) {
        List<Integer> path = new ArrayList<>();
        
        // Starting position of the robot (top-left corner)
        int row = 0;
        int col = 0;

        // Traverse the grid until reaching the bottom-right corner
        while (row < grid.length - 1 || col < grid[0].length - 1) {
            // Add the current location value to the path
            path.add(grid[row][col]);
            
            // Check if the robot can move down and right
            if (row < grid.length - 1 && col < grid[0].length - 1) {
                // Compare the values of the below neighbor and the right neighbor
                if (grid[row + 1][col] < grid[row][col + 1]) {
                    row++; // Move down
                } else {
                    col++; // Move right
                }
            } 
            // If the robot can only move down (last column)
            else if (row < grid.length - 1) {
                row++; // Move down
            } 
            // If the robot can only move right (last row)
            else if (col < grid[0].length - 1) {
                col++; // Move right
            }
        }
        
        // Add the value of the bottom-right corner to the path
        path.add(grid[row][col]);
        
        // Return the complete path
        return path;
    }

    // Method to initiate the maze traversal and return the path
    public static List<Integer> startTraversal() {
        // Example grid provided in the problem
        int[][] grid = {
            {27, 4, 22, 3, 10, 16},
            {35, 6, 33, 12, 15, 17},
            {8, 9, 1, 7, 14, 25},
            {11, 18, 2, 20, 26, 24},
            {19, 23, 3, 28, 30, 32}
        };

        // Call the location method and return the path
        return location(grid);
    }

    public static void main(String[] args) {
        List<Integer> path = startTraversal();
        
       
        System.out.println(path);
    }
}

