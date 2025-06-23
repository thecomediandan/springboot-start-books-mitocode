package com.ardadev.mitocodeexample.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ardadev.mitocodeexample.models.Employee;
import com.ardadev.mitocodeexample.repository.EmployeeRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmployeeService implements UserDetailsService {

    private final EmployeeRepo employeeRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepo.findByUsername(username);
        UserDetails user = User.builder()
            .username(employee.getUsername())
            .password(employee.getPassword())
            .roles(employee.getRol())
            .build();
        return user;
    }
    
}
