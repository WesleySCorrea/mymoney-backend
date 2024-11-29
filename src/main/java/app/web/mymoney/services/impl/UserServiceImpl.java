package app.web.mymoney.services.impl;

import app.web.mymoney.DTOs.request.UserRequestDTO;
import app.web.mymoney.DTOs.response.UserResponseDTO;
import app.web.mymoney.entities.Users;
import app.web.mymoney.repositories.UserRepository;
import app.web.mymoney.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {

        Users user =userRequestDTO.toEntity(userRequestDTO);

        user = userRepository.save(user);

        return new UserResponseDTO(user);
    }
}
