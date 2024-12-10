package app.web.mymoney.services;

import app.web.mymoney.DTOs.request.launch.LaunchRequestDTO;
import app.web.mymoney.DTOs.response.launch.LaunchResponseDTO;

public interface LaunchService {
    LaunchResponseDTO createLaunch(LaunchRequestDTO launchRequestDTO);
}
