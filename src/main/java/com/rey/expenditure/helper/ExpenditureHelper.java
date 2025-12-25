package com.rey.expenditure.helper;

import com.rey.expenditure.exception.InvalidIncomeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExpenditureHelper {

    Double incomeDouble;
    public void validateIncome(String income) {

        if(income == null || income.strip().isEmpty()){
            throw new InvalidIncomeException("INVALID INCOME");
        }
            try {
                incomeDouble = Double.parseDouble(income);
            }catch(NumberFormatException e){
                throw new InvalidIncomeException("INVALID INCOME");
            }

        if(incomeDouble < 1){
            throw new InvalidIncomeException("INVALID INCOME");
        }


    }

    public Double calculateTitheExpenditure(String income) {
        log.info("About to calculate tithe expenditure");

        incomeDouble = Double.parseDouble(income);

        Double titheExpenditure  = 0.1 * incomeDouble;
        log.info("Calculated tithe Expenditure: {}",titheExpenditure);

        return titheExpenditure;
    }

    public Double calculateNeedExpenditure(String income) {
        log.info("About to calculate need expenditure");
        incomeDouble = Double.parseDouble(income);

        Double needExpenditure  = 0.5 * incomeDouble;
        log.info("Calculated Need Expenditure: {}",needExpenditure);

        return needExpenditure;
    }

    public Double calculateCharityExpenditure(String income) {
        log.info("About to calculate charity expenditure");

        incomeDouble = Double.parseDouble(income);

        Double charityExpenditure  = 0.4 * incomeDouble;
        log.info("Calculated Charity Expenditure: {}",charityExpenditure);

        log.info("Calculated Charity Expenditure: {}",charityExpenditure);

        return charityExpenditure;
    }

    public Double calculateInvestmentExpenditure(String income) {
        log.info("About to calculate Investment expenditure");

        incomeDouble = Double.parseDouble(income);

        Double investmentExpenditure  = 0.4 * incomeDouble;
        log.info("Calculated Investment Expenditure: {}",investmentExpenditure);

        return investmentExpenditure;
    }



}
