package com.chatapp.service.impl;

import com.chatapp.dto.UserDTO;
import com.chatapp.entities.UserEntity;
import com.chatapp.repository.UserRepository;
import com.chatapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chatapp.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity user = dtoToEntity(userDTO);

        UserEntity saveUser = userRepository.save(user);

        return entityToDto(saveUser);

    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        userEntity.setUserName(userDTO.getUserName());
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());

        UserEntity updatedUser = userRepository.save(userEntity);
        UserDTO userDTO1 = entityToDto(updatedUser);
        return userDTO1;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        return entityToDto(userEntity);
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<UserEntity> allUsers = userRepository.findAll();

        List<UserDTO> collectAllUsers = allUsers.stream()
                .map(userEntity -> this.entityToDto(userEntity))
                .collect(Collectors.toList());

        return collectAllUsers;
    }

    @Override
    public void deleteUser(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userRepository.delete(userEntity);

    }

//------------------------------------------------------------------------

    private UserEntity dtoToEntity(UserDTO userDTO) {
        UserEntity userEntity = mapper.map(userDTO, UserEntity.class);

        return userEntity;
    }

    private UserDTO entityToDto(UserEntity userEntity) {
        UserDTO userDTO = mapper.map(userEntity, UserDTO.class);

        return userDTO;
    }
}
