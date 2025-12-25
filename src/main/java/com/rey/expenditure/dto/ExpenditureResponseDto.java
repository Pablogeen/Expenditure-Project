package com.rey.expenditure.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ExpenditureResponseDto {

    private Double tithe;
    private Double needs;
    private Double charity;
    private Double investment;
}
