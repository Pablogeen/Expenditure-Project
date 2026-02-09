package com.rey.expenditure.controller;

import com.rey.expenditure.dto.ExpenditureResponseDto;
import com.rey.expenditure.service.ServiceInterface;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/v1/expenditures") 
@RequiredArgsConstructor
@Slf4j
@Validated
public class ExpenditureController {

    private final ServiceInterface serviceInterface;

    @GetMapping
        public ResponseEntity<ExpenditureResponseDto>
                        calculateExpenditure(@RequestParam("income")
                                             @NotNull(message="Income is Required")
                                             @Positive(message ="Income must be greater than zero")
                                             @Digits(integer = 15, fraction = 2,
                                                     message = "Income can have max 15 integer with 2 decimal digits") BigDecimal income){
            log.info("Request received to calculate expenditure: Income:{}",income);
            ExpenditureResponseDto calculatedExpenditure = serviceInterface.calculateExpenditure(income);
            log.info("Calculated the expenditure of the income: {} || expenditure: {}",
                                                income, calculatedExpenditure);
            return new ResponseEntity<>(calculatedExpenditure, HttpStatus.OK);
        }
}
