package com.example.SubmersibleProbe.controller;

import com.example.SubmersibleProbe.exception.GlobalExceptionHandler;
import com.example.SubmersibleProbe.exception.ResourceNotFoundException;
import com.example.SubmersibleProbe.model.SubmersibleProbeRequest;

import com.example.SubmersibleProbe.service.ProbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/probe")
public class ProbeController {

    @Autowired
    private ProbServiceImpl probService;
    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> controlProbe(@RequestBody SubmersibleProbeRequest request) throws ResourceNotFoundException {
         ArrayList<String> summaryVisit = probService.executeCommands(request);
        return new ResponseEntity(summaryVisit, HttpStatus.CREATED);
    }
}
