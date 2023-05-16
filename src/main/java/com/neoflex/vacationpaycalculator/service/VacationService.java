package com.neoflex.vacationpaycalculator.service;

import com.neoflex.vacationpaycalculator.exception.DataForCalculationNullException;
import org.springframework.stereotype.Service;
import com.neoflex.vacationpaycalculator.dto.VacationDTO;
import com.neoflex.vacationpaycalculator.dto.ResponseDTO;

import static com.neoflex.vacationpaycalculator.mapper.VocationPayMapper.*;

import com.neoflex.vacationpaycalculator.mapper.DaysMapper;
import com.neoflex.vacationpaycalculator.util.HolidaysDict;
import com.neoflex.vacationpaycalculator.util.HolidaysDictHardcoded;

@Service
public class VacationService {
    private static final double AVERAGE_NUMBER_DAYS_IN_MOUNT = 29.3;

    private final HolidaysDict holidaysDict = new HolidaysDictHardcoded();

    public ResponseDTO calculateByDays(VacationDTO vacationDTO) {
        if (vacationDTO.getAverageSalary() == null) {
            throw new DataForCalculationNullException();
        }
        ResponseDTO responseDTO = new ResponseDTO();
        Double vocationPay =
                vacationDTO.getAverageSalary() / AVERAGE_NUMBER_DAYS_IN_MOUNT
                        * vacationDTO.getVacationDays();
        responseDTO.setAmountOfVocationPay(mapMeaningDouble(vocationPay));
        return responseDTO;
    }

    public ResponseDTO calculateByDates(VacationDTO vacationDTO) {
        if (vacationDTO.getStartVacation() == null || vacationDTO.getEndVacation() == null)
            throw new DataForCalculationNullException();
        if (vacationDTO.getAverageSalary() == null) throw new DataForCalculationNullException();
        ResponseDTO responseDTO = new ResponseDTO();
        Double vocationPay =
                vacationDTO.getAverageSalary() / AVERAGE_NUMBER_DAYS_IN_MOUNT
                        * DaysMapper.mapDatesToDays(vacationDTO, holidaysDict);
        responseDTO.setAmountOfVocationPay(mapMeaningDouble(vocationPay));
        return responseDTO;
    }

    public ResponseDTO selectData(VacationDTO vacationDTO) {
        if (vacationDTO.getVacationDays() == null) {
            return calculateByDates(vacationDTO);
        } else return calculateByDays(vacationDTO);
    }

}
