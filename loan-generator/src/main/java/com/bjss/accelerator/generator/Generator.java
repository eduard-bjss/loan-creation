package com.bjss.accelerator.generator;

import com.bjss.accelerator.domain.Borrower;
import com.bjss.accelerator.domain.Credit;
import com.bjss.accelerator.domain.Loan;
import com.bjss.accelerator.domain.LoanDetails;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Generator {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private static final String LOAN_TYPE = "Auto Loan";
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 80;
    private static final int LOAN_MIN = 20000;
    private static final int LOAN_MAX = 50000;
    private static final int TERM_MIN = 12;
    private static final int TERM_MAX = 80;
    private static final int SCORE_MIN = 601;
    private static final int SCORE_MAX = 820;
    private static final Faker faker = new Faker();
    private static final IntInRangeNumberGenerator loanAmountGenerator = new IntInRangeNumberGenerator(LOAN_MIN, LOAN_MAX);
    private static final IntInRangeNumberGenerator loanTermGenerator = new IntInRangeNumberGenerator(TERM_MIN, TERM_MAX);
    private static final IntInRangeNumberGenerator creditScoreGenerator = new IntInRangeNumberGenerator(SCORE_MIN, SCORE_MAX);
    private static final DoubleInRangeNumberGenerator creditUtilizationGenerator = new DoubleInRangeNumberGenerator(0.28, 0.39);
    private static final IntInRangeNumberGenerator incomeGenerator = new IntInRangeNumberGenerator(3000, 10000);

    public static Loan generateLoan() {
        return Loan.builder()
                .borrower(generateBorrower())
                .credit(generateCreditDetails())
                .details(generateLoanDetails())
                .build();
    }

    private static Borrower generateBorrower() {
        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        String email = fName + "." + lName + "@example.com";
        return Borrower.builder()
                .loanId(System.currentTimeMillis())
                .fName(fName)
                .lName(lName)
                .email(email)
                .address(faker.address().fullAddress())
                .phone(faker.phoneNumber().phoneNumber())
                .dob(faker.date().birthday(MIN_AGE, MAX_AGE, "MM/dd/YYYY"))
                .build();
    }

    private static LoanDetails generateLoanDetails() {
        LocalDate currentDate = LocalDate.now();
        LocalDate disbursementDate = currentDate.plusDays(15);
        return LoanDetails.builder()
                .amount(loanAmountGenerator.nextInt())
                .type(LOAN_TYPE)
                .length(loanTermGenerator.nextInt())
                .aDate(DATE_FORMATTER.format(currentDate))
                .dDate(DATE_FORMATTER.format(disbursementDate))
                .build();
    }

    private static Credit generateCreditDetails() {
        return Credit.builder()
                .score(creditScoreGenerator.nextInt())
                .utilization(creditUtilizationGenerator.nextDouble())
                .history("CCCCCCCCCCCCCCCCCC")
                .income(incomeGenerator.nextInt())
                .build();

    }

}
