package com.practice.SpringBootBackend.services;

import org.springframework.stereotype.Service;

import com.practice.SpringBootBackend.exceptions.InvalidRequestBodyException;
import com.practice.SpringBootBackend.models.Maze;
import com.practice.SpringBootBackend.models.MazeConstraints;

@Service
public class MazeService {
    
    public String generateMaze(MazeConstraints constraints) {
        if(!constraints.isValid()){
            throw new InvalidRequestBodyException(constraints.toString());
        }

        Maze maze = new Maze(constraints);

        return maze.getMazeLayout();
    }

}
