package app.web.mymoney.controllers;

import app.web.mymoney.DTOs.request.transaction.LaunchRequestDTO;
import app.web.mymoney.DTOs.response.transaction.BalanceResponseDTO;
import app.web.mymoney.DTOs.response.transaction.LaunchResponseDTO;
import app.web.mymoney.services.LaunchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/balance")
    public ResponseEntity<BalanceResponseDTO> findBalance (@RequestParam Integer month, @RequestParam Integer year) {

        BalanceResponseDTO balanceResponseDTO = launchService.findBalanceByUserAndDate(month, year);

        return ResponseEntity.status(HttpStatus.OK).body(balanceResponseDTO);
    }
}
