package com.example.emailconfiguration.dao;


import com.example.emailconfiguration.model.EmailSettings;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmailDao implements IEmailDao{
    private static List<EmailSettings> emailList ;
    static {
        emailList = new ArrayList<>();
        emailList.add(new EmailSettings(1,"English",5,false,"Hieu"));
        emailList.add(new EmailSettings(2,"English",5,true,"Thao"));
        emailList.add(new EmailSettings(3,"English",5,false,"Giang"));
        emailList.add(new EmailSettings(4,"English",5,true,"Viet"));
        emailList.add(new EmailSettings(5,"English",5,false,"Huy"));
    }
    @Override
    public List<EmailSettings> findAll() {
        return emailList;
    }

    @Override
    public EmailSettings findById(int id) {
        return emailList.get(id-1);
    }

    @Override
    public EmailSettings edit(EmailSettings emailSettings) {
        EmailSettings origin = findById(emailSettings.getId());
        origin.setLanguages(emailSettings.getLanguages());
        origin.setPageSize(emailSettings.getPageSize());
        origin.setSignature(emailSettings.getSignature());
        origin.setSpamFilter(emailSettings.isSpamFilter());
        return null;
    }

    @Override
    public List<String> languageList() {
        List<String> language = new ArrayList<>();
        language.add("English");
        language.add("Vietnamese");
        language.add("Japanese");
        language.add("Chinese");
        return language;
    }

    @Override
    public List<Integer> pageSize() {
        List<Integer> pageSize = new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);
        return pageSize;
    }
}
