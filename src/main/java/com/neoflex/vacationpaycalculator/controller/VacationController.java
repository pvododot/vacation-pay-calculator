package com.neoflex.vacationpaycalculator.controller;

import com.neoflex.vacationpaycalculator.dto.ResponseDTO;
import com.neoflex.vacationpaycalculator.service.VacationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neoflex.vacationpaycalculator.dto.VacationDTO;

@RequiredArgsConstructor
@RestController
@RequestMapping("/calculate")
public class VacationController {
    @Autowired
    private final VacationService vacationService;

    @GetMapping
    public ResponseDTO getVocationPay(@RequestBody VacationDTO vacationDTO) {
        return vacationService.selectData(vacationDTO);
    }
}
