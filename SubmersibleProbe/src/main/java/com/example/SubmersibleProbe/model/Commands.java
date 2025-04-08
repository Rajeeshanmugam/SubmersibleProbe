package com.example.SubmersibleProbe.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Commands {
    private int x;
    private int y;
    private Direction direction;
    private String command;
}
