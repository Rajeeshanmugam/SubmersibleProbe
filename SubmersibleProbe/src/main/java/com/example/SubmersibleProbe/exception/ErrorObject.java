package com.example.SubmersibleProbe.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorObject {
    private String errorMessage;
    private String statusCode;

}
