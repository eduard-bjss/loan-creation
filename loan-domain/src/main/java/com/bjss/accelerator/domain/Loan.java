package com.bjss.accelerator.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class Loan implements JsonSource{
    @JsonProperty("borrower")
    private Borrower borrower;

    @JsonProperty("loan-details")
    private LoanDetails details;

    @JsonProperty("credit")
    private Credit credit;

    public long getLoanId() {
        return borrower != null ? borrower.getLoanId() : -1;
    }
}
