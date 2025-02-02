package app.web.mymoney.services.impl;

import app.web.mymoney.DTOs.request.transaction.BalanceRequestDTO;
import app.web.mymoney.DTOs.request.transaction.LaunchRequestDTO;
import app.web.mymoney.DTOs.request.user.UserInfoDTO;
import app.web.mymoney.DTOs.response.transaction.BalanceResponseDTO;
import app.web.mymoney.DTOs.response.transaction.LaunchResponseDTO;
import app.web.mymoney.entities.Launch;
import app.web.mymoney.repositories.LaunchRepository;
import app.web.mymoney.services.LaunchService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

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

    @Override
    public BalanceResponseDTO findBalanceByUserAndDate(Integer month, Integer year) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfoDTO userInfo = (UserInfoDTO) authentication.getDetails();

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());

        List<Object[]> object = launchRepository.findBalanceByUserAndDate(
        userInfo.getId(),
        startDate, endDate);

        List<Integer> years = launchRepository.findDistinctYears(userInfo.getId());

        return new BalanceResponseDTO(object.get(0), years);
    }
}
