package com.rey.expenditure.service;

import com.rey.expenditure.dto.ExpenditureResponseDto;
import com.rey.expenditure.helper.ExpenditureHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceImpl implements ServiceInterface {

    private final ExpenditureHelper helper;
    private final ExpenditureResponseDto expenditureResponseDto;

    @Override
    public ExpenditureResponseDto calculateExpenditure(BigDecimal income) {
       log.info("About to calculate for the income: {}",income);


       BigDecimal titheExpenditure = helper.calculateTitheExpenditure(income);
       expenditureResponseDto.setTithe(titheExpenditure);
       log.info("Tithe's expenditure: {}",titheExpenditure);

        BigDecimal needsExpenditure = helper.calculateNeedExpenditure(income);
        expenditureResponseDto.setNeeds(needsExpenditure);
        log.info("Needs's expenditure: {}",needsExpenditure);

        BigDecimal charityExpenditure = helper.calculateCharityExpenditure(income);
        expenditureResponseDto.setCharity(charityExpenditure);
        log.info("Charity's expenditure: {}",charityExpenditure);

        BigDecimal investmentExpenditure = helper.calculateInvestmentExpenditure(income);
        expenditureResponseDto.setInvestment(investmentExpenditure);
        log.info("Investment's expenditure: {}",investmentExpenditure);

        return expenditureResponseDto;
    }
}
