package com.codegym.service;

import com.codegym.model.User;
import com.codegym.repository.IRoleRepository;
import com.codegym.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService
{
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user==null){
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        System.out.println("Found User: " + user);
        List<String> roleNames = roleRepository.findRoleNamesByUserId(user.getId());
        List<GrantedAuthority> authorities = buildAuthorities(roleNames);

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );

        return userDetails;
    }
    private List<GrantedAuthority> buildAuthorities(List<String> roleNames) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (roleNames != null) {
            for (String roleName : roleNames) {
                authorities.add(new SimpleGrantedAuthority(roleName));
            }
        }
        return authorities;
    }
}
