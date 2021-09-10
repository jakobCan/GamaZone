package com.example.gamazone_backend.web.security.service;

import com.example.gamazone_backend.data.model.User;
import com.example.gamazone_backend.repository.UserRepository;
import com.example.gamazone_backend.web.security.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(s);

        if (null == user) {
            throw new UsernameNotFoundException(s);
        }
        return new CustomUserDetails(user);
    }
}
