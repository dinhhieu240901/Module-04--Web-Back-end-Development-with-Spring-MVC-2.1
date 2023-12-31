package com.example.emailconfiguration.service;


import com.example.emailconfiguration.dao.IEmailDao;
import com.example.emailconfiguration.model.EmailSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmailService implements IEmailService{
    @Autowired
    IEmailDao emailDao;
    @Override
    public List<EmailSettings> findAll() {
        return emailDao.findAll();
    }

    @Override
    public EmailSettings findById(int id) {
        return emailDao.findById(id);
    }

    @Override
    public EmailSettings edit(EmailSettings emailSettings) {
        return emailDao.edit(emailSettings);
    }

    @Override
    public List<String> languageList() {
        return emailDao.languageList();
    }

    @Override
    public List<Integer> pageSize() {
        return emailDao.pageSize();
    }
}
