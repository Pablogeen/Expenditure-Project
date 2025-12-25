package com.rey.expenditure.service;

import com.rey.expenditure.dto.ExpenditureResponseDto;

public interface ServiceInterface {

    ExpenditureResponseDto calculateExpenditure(String income);
}
