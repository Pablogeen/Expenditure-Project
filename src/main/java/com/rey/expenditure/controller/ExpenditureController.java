package com.rey.expenditure.controller;

import com.rey.expenditure.dto.ExpenditureResponseDto;
import com.rey.expenditure.service.ServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/expenditures") 
@RequiredArgsConstructor
@Slf4j
public class ExpenditureController {

    private final ServiceInterface serviceInterface;

    @GetMapping
        public ResponseEntity<ExpenditureResponseDto>
                        calculateExpenditure(@RequestParam("income") String income){
            log.info("Request received to calculate expenditure: Income:{}",income);
            ExpenditureResponseDto calculatedExpenditure = serviceInterface.calculateExpenditure(income);
            log.info("Calculated the expenditure of the income: {} || expenditure: {}",
                                                income, calculatedExpenditure);
            return new ResponseEntity<>(calculatedExpenditure, HttpStatus.OK);
        }
}
