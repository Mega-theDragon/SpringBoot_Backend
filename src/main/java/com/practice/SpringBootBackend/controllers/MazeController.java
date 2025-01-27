package com.practice.SpringBootBackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.SpringBootBackend.models.Maze;
import com.practice.SpringBootBackend.models.MazeConstraints;
import com.practice.SpringBootBackend.services.MazeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/maze")
@AllArgsConstructor
public class MazeController {
    
    private MazeService mazeService;

    @RequestMapping("/generate")
    public String generateMaze(@RequestBody MazeConstraints constraints) throws Exception{
        return mazeService.generateMaze(constraints);
    }

}
