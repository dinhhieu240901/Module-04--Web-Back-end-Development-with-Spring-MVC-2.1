package com.codegym.service;

import com.codegym.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserService  {
    void save(User user);
    User findById(Long id);
}
