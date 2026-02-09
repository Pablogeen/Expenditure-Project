package com.rey.expenditure.helper;

import com.rey.expenditure.exception.InvalidIncomeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@Slf4j
public class ExpenditureHelper {


    public BigDecimal calculateTitheExpenditure(BigDecimal income) {
        log.info("About to calculate tithe expenditure");

        BigDecimal titheExpenditure =
                income.multiply(BigDecimal.valueOf(0.1)).setScale(2, RoundingMode.HALF_UP);
        log.info("Calculated tithe Expenditure: {}",titheExpenditure);

        return titheExpenditure;
    }

    public BigDecimal calculateNeedExpenditure(BigDecimal  income) {
        log.info("About to calculate need expenditure");

        BigDecimal needExpenditure =
                income.multiply(BigDecimal.valueOf(0.5)).setScale(2, RoundingMode.HALF_UP);

        log.info("Calculated Need Expenditure: {}",needExpenditure);

        return needExpenditure;
    }

    public BigDecimal calculateCharityExpenditure(BigDecimal income) {
        log.info("About to calculate charity expenditure");

       BigDecimal charityExpenditure =
               income.multiply(BigDecimal.valueOf(0.2)).setScale(2, RoundingMode.HALF_UP);

        log.info("Calculated Charity Expenditure: {}",charityExpenditure);

        return charityExpenditure;
    }

    public BigDecimal calculateInvestmentExpenditure(BigDecimal income) {
        log.info("About to calculate Investment expenditure");

        BigDecimal investmentExpenditure =
                income.multiply(BigDecimal.valueOf(0.2)).setScale(2, RoundingMode.HALF_UP);

        log.info("Calculated Investment Expenditure: {}",investmentExpenditure);

        return investmentExpenditure;
    }



}