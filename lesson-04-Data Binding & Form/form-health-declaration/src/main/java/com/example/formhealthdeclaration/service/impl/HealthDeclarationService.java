package com.example.formhealthdeclaration.service.impl;

import com.example.formhealthdeclaration.dao.IHealthDeclarationDao;
import com.example.formhealthdeclaration.model.HealDeclaration;
import com.example.formhealthdeclaration.service.IHealthDeclarationService;
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
