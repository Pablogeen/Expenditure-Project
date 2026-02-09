package com.rey.expenditure.service;

import com.rey.expenditure.dto.ExpenditureResponseDto;

import java.math.BigDecimal;

public interface ServiceInterface {

    ExpenditureResponseDto calculateExpenditure(BigDecimal income);
}
