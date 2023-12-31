package com.example.healdeclaraionform.service.impl;

import com.example.healdeclaraionform.dao.IHealthDeclarationDao;
import com.example.healdeclaraionform.model.HealDeclaration;
import com.example.healdeclaraionform.service.IHealthDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthDeclarationService implements IHealthDeclarationService {
    @Autowired
    private IHealthDeclarationDao healthDeclarationDao;
    @Override
    public HealDeclaration get() {
        return healthDeclarationDao.get();
    }

    @Override
    public void update(HealDeclaration healDeclaration) {
        healthDeclarationDao.update(healDeclaration);
    }
}
