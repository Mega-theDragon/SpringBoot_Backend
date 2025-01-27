package com.practice.SpringBootBackend.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import lombok.Data;

public class Maze {

    private final int width;
    private final int height;
    private int[][] maze;
    private Random rng;

    public Maze(MazeConstraints constraints){
        width = constraints.getWidth();
        height = constraints.getHeight();
        maze = new int[width][height];
        rng = new Random();

        generateMaze();
    }

    private void generateMaze(){
        Stack<int[]> path = new Stack<>();
        int x = 0;
        int y = 0;

        maze[x][y] = 1;

        List<int[]> availableDirections;
        do {
            availableDirections = findAvailableDirections(x, y);
            while (availableDirections.isEmpty()) {
                if (path.isEmpty()) {
                    return;
                }
                int[] previousCords = path.pop();
                x = previousCords[0];
                y = previousCords[1];

                availableDirections = findAvailableDirections(x, y);
            }

            int[] direction = availableDirections.get(rng.nextInt(availableDirections.size()));

            maze[x + direction[0]][y + direction[1]] = 1;
            maze[x + direction[0] * 2][y + direction[1] * 2] = 1;

            path.add(new int[]{x, y});
            x += direction[0] * 2;
            y += direction[1] * 2;
        } while (!path.isEmpty());
    }

    private List<int[]> findAvailableDirections(int x, int y){
        List<int[]> availableDirections = new ArrayList<>();

        if(y + 2 < height && maze[x][y + 2] == 0){
            availableDirections.add(new int[]{0, 1});
        }
        if(x + 2 < width && maze[x + 2][y] == 0){
            availableDirections.add(new int[]{1, 0});
        }
        if(y - 2 >= 0 && maze[x][y - 2] == 0){
            availableDirections.add(new int[]{0, -1});
        }
        if(x - 2 >= 0 && maze[x - 2][y] == 0){
            availableDirections.add(new int[]{-1, 0});
        }

        return availableDirections;
    }

    public String getMazeLayout(){
        String mazeLayout = "[\n";

        for(int y = 0; y < height; y++){
            mazeLayout += "    [";
            for(int x = 0; x < width; x++){
                mazeLayout += maze[x][y];
                mazeLayout += (x < width - 1) ? ", " : "";
            }
            mazeLayout += "]";
            mazeLayout += (y < height - 1) ? ", " : "";
            mazeLayout += "\n";
        }
        mazeLayout += "]";

        return mazeLayout;
    }

}
