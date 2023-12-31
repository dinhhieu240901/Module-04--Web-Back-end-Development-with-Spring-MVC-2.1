package com.example.emailconfiguration.service;


import com.example.emailconfiguration.model.EmailSettings;

import java.util.List;

public interface IEmailService {
    List<EmailSettings> findAll();
    EmailSettings findById(int id);
    EmailSettings edit(EmailSettings emailSettings);

    List<String> languageList();
    List<Integer> pageSize();
}
