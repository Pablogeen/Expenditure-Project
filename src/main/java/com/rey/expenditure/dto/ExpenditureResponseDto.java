package com.rey.expenditure.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Component
public class ExpenditureResponseDto {

    private BigDecimal tithe;
    private BigDecimal needs;
    private BigDecimal charity;
    private BigDecimal investment;
}
