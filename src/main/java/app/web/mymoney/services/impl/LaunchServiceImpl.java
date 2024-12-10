package app.web.mymoney.services.impl;

import app.web.mymoney.DTOs.request.launch.LaunchRequestDTO;
import app.web.mymoney.DTOs.response.launch.LaunchResponseDTO;
import app.web.mymoney.entities.Launch;
import app.web.mymoney.repositories.LaunchRepository;
import app.web.mymoney.services.LaunchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LaunchServiceImpl implements LaunchService {

    private final LaunchRepository launchRepository;
    @Override
    public LaunchResponseDTO createLaunch(LaunchRequestDTO launchRequestDTO) {

        Launch launch = launchRequestDTO.toEntity();

        launch = launchRepository.save(launch);

        return new LaunchResponseDTO(launch);
    }
}
