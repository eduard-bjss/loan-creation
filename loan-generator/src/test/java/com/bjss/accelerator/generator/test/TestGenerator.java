package com.bjss.accelerator.generator.test;

import com.bjss.accelerator.domain.Loan;
import com.bjss.accelerator.generator.Generator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class TestGenerator {
    public static void main(String[] args) throws IOException {
        Loan loan = Generator.generateLoan();

        System.out.println(loan.toJson());
    }
}
