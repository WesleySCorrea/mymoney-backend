package app.web.mymoney.services;

import app.web.mymoney.DTOs.request.transaction.BalanceRequestDTO;
import app.web.mymoney.DTOs.request.transaction.LaunchRequestDTO;
import app.web.mymoney.DTOs.response.transaction.BalanceResponseDTO;
import app.web.mymoney.DTOs.response.transaction.LaunchResponseDTO;

public interface LaunchService {
    LaunchResponseDTO createLaunch(LaunchRequestDTO launchRequestDTO);
    BalanceResponseDTO findBalanceByUserAndDate(Integer month, Integer year);
}
