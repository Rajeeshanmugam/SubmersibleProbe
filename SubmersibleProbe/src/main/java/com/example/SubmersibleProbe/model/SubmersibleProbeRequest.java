package com.example.SubmersibleProbe.model;




import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmersibleProbeRequest {
    private ArrayList<Commands> commandsArrayList;
}
