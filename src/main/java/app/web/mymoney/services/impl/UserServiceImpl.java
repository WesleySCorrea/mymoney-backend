package app.web.mymoney.services.impl;

import app.web.mymoney.DTOs.request.user.UserRequestDTO;
import app.web.mymoney.DTOs.response.user.UserResponseDTO;
import app.web.mymoney.entities.Users;
import app.web.mymoney.repositories.UserRepository;
import app.web.mymoney.services.AccountService;
import app.web.mymoney.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountService accountService;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {

        Users user = userRequestDTO.toEntity();

        user = userRepository.save(user);

        accountService.createAccount("Carteira", user.getId(), BigDecimal.ZERO);

        return new UserResponseDTO(user);
    }
}
