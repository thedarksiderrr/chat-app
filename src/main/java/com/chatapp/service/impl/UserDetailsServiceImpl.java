package com.chatapp.service.impl;

import com.chatapp.entities.UserEntity;
import com.chatapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userByUserName = userRepository.getUserByUserName(username);

        if (userByUserName == null) {
            throw new UsernameNotFoundException("Could not found user!!");
        }
        CustomUserDetails userDetails = new CustomUserDetails(userByUserName);

        return userDetails;
    }


}
