package com.bjss.accelerator.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class LoanDetails {
    @JsonProperty("loan-amount")
    private float amount;

    @JsonProperty("loan-type")
    private String type;

    @JsonProperty("term-months")
    private int length;

    @JsonProperty("application-date")
    private String aDate;

    @JsonProperty("disbursement-date")
    private String dDate;
}
