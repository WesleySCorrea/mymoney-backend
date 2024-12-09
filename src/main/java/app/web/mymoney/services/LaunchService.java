package app.web.mymoney.services;

import app.web.mymoney.DTOs.request.LaunchRequestDTO;
import app.web.mymoney.DTOs.response.LaunchResponseDTO;

public interface LaunchService {
    LaunchResponseDTO createLaunch(LaunchRequestDTO launchRequestDTO);
}
