package com.practice.SpringBootBackend.models;

import lombok.Data;

@Data
public class MazeConstraints {
    
    private final int width;
    private final int height;

    public boolean isValid(){
        return width > 0 && height > 0;
    }

}
