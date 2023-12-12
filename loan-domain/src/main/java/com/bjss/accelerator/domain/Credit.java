package com.bjss.accelerator.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;


@Builder
public class Credit {
    @JsonProperty("credit-score")
    private int score;

    @JsonProperty("credit-history")
    private String history;

    @JsonProperty("credit-utilization")
    private double utilization;

    @JsonProperty("monthly-income")
    private int income;
}
