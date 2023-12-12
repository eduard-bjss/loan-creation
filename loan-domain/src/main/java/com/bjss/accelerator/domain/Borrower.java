package com.bjss.accelerator.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;


@Builder
public class Borrower {
    @Getter
    @JsonProperty("loan-id")
    private long loanId;

    @JsonProperty("first-name")
    private String fName;

    @JsonProperty("last-name")
    private String lName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("address")
    private String address;

    @JsonProperty("date-of-birth")
    private String dob;
}
