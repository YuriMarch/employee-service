package com.example.employeeservice.model;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
public class Paycheck {

    private Integer hoursWorked;
    private Double hourlyRate;
//    private boolean isPaycheckPaid = false;
}


