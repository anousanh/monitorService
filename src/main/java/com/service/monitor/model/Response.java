package com.service.monitor.model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Response {
    private Long id;
    private String claimNo;
    private String surveyId;
    private String totalScore;
    private String qType;
    private Date expDate;
    private String certNo;
    private String policyNo;
    private Date creDate;
}
