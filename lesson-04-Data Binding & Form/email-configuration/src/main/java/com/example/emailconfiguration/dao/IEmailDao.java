package com.example.emailconfiguration.dao;


import com.example.emailconfiguration.model.EmailSettings;

import java.util.List;

public interface IEmailDao {
    List<EmailSettings> findAll();
    EmailSettings findById(int id);
    EmailSettings edit(EmailSettings emailSettings);

    List<String> languageList();
    List<Integer> pageSize();
 }
