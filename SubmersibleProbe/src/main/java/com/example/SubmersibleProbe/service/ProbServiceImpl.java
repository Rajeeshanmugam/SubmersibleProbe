package com.example.SubmersibleProbe.service;


import com.example.SubmersibleProbe.exception.GlobalExceptionHandler;
import com.example.SubmersibleProbe.exception.ResourceNotFoundException;
import com.example.SubmersibleProbe.model.Direction;
import com.example.SubmersibleProbe.model.SubmersibleProbeRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProbServiceImpl {
    private ArrayList<String> visitedCoordinates = null;

    public ArrayList<String> executeCommands(SubmersibleProbeRequest request)  {
        visitedCoordinates = new ArrayList<>();
        System.out.println(request);
        try{
        if(request.getCommandsArrayList() != null){
            request.getCommandsArrayList().stream().forEach(command -> {
            if(command.getCommand().equalsIgnoreCase("Forward")){
                moveForward(command.getDirection(),command.getX(),command.getY());
            }else if(command.getCommand().equalsIgnoreCase("Backward")){
                moveBackward(command.getDirection(),command.getX(),command.getY());
            }else if(command.getCommand().equalsIgnoreCase("Left")){
                turnLeft(command.getDirection(),command.getX(),command.getY());
            }else if(command.getCommand().equalsIgnoreCase("Right")){
                turnRight(command.getDirection(),command.getX(),command.getY());
            }else if(command.getCommand().equalsIgnoreCase("Stay")){
                stayGrid(command.getDirection(),command.getX(),command.getY());
            }
        });
        }}catch (ResourceNotFoundException ex){
            throw new ResourceNotFoundException("No data found");
        }
        return visitedCoordinates;
    }
    private void moveForward(Direction direction, int x, int y) {
        String quadrant= null;
        switch (direction) {
            case NORTH:
                quadrant = "[" + (x+1) +"," + (y+1)+ "]";
                break;
            case EAST:
                quadrant =  "[" +(x+1) +"," + (y-1)+"]";
                break;
            case SOUTH:
                quadrant =  "[" +(x-1) +"," + (y-1)+"]";
                break;
            case WEST:
                quadrant =  "[" +(x-1) +"," + (y+1)+"]";
                break;
        }
        visitedCoordinates.add(quadrant);
    }
    private void moveBackward(Direction direction, int x, int y) {
        String quadrant= null;
        switch (direction) {
            case NORTH:
                quadrant =  "[" +(x-1) +"," + (y+1)+"]";
                break;
            case EAST:
                quadrant =  "[" +(x+1) +"," + (y+1)+"]";
                break;
            case SOUTH:
                quadrant =  "[" +(x+1) +"," + (y-1)+"]";
                break;
            case WEST:
                quadrant =  "[" +(x-1) +"," + (y-1)+"]";
                break;
        }
        visitedCoordinates.add(quadrant);
    }
    public void turnLeft(Direction direction, int x, int y) {
        String quadrant= null;
        switch (direction) {
            case NORTH:
                direction = Direction.WEST;
                quadrant = "["+(x-1) +"," + (y+1)+"]";
                break;
            case EAST:
                direction = Direction.NORTH;
                quadrant =  "[" +(x+1) +"," + (y+1)+"]";
                break;
            case SOUTH:
                direction = Direction.EAST;
                quadrant =   "[" +(x+1) +"," + (y-1)+"]";
                break;
            case WEST:
                direction = Direction.SOUTH;
                quadrant =  "[" +(x-1) +"," + (y-1)+"]";
                break;
        }
        visitedCoordinates.add(quadrant);
    }

    public void turnRight(Direction direction, int x, int y) {
        String quadrant= null;
        switch (direction) {
            case NORTH:
                direction = Direction.EAST;
                quadrant=   "[" +(x+1) +"," + (y+1)+"]";
                break;
            case EAST:
                direction = Direction.SOUTH;
                quadrant=   "[" +(x+1) +"," + (y-1)+"]";
                break;
            case SOUTH:
                direction = Direction.WEST;
                quadrant=   "[" +(x-1) +"," + (y-1)+"]";
                break;
            case WEST:
                direction = Direction.NORTH;
                quadrant=   "[" +(x-1) +"," + (y+1)+"]";
                break;
        }
        visitedCoordinates.add(quadrant);
    }

    private void stayGrid(Direction direction, int x, int y) {
        visitedCoordinates.add( "[" +x + "," + y +"]" );
    }
}
