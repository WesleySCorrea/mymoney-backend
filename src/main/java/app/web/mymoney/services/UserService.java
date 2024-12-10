package app.web.mymoney.services;

import app.web.mymoney.DTOs.request.user.UserRequestDTO;
import app.web.mymoney.DTOs.response.user.UserResponseDTO;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
}
