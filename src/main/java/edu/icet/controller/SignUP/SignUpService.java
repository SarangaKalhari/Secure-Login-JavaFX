package edu.icet.controller.SignUP;

import edu.icet.model.dto.UserDTO;

public interface SignUpService {

    int addRegister(UserDTO dto); // returns generated id
}
