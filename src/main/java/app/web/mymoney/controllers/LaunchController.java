package app.web.mymoney.controllers;

import app.web.mymoney.DTOs.request.LaunchRequestDTO;
import app.web.mymoney.DTOs.response.LaunchResponseDTO;
import app.web.mymoney.services.LaunchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/launch")
public class LaunchController {

    private final LaunchService launchService;

    @PostMapping
    public ResponseEntity<LaunchResponseDTO> createLaunch(@RequestBody LaunchRequestDTO launchRequestDTO) {

        LaunchResponseDTO launchResponseDTO = launchService.createLaunch(launchRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(launchResponseDTO);
    }
}
