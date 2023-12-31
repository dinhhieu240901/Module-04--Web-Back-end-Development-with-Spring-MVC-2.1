package com.example.formhealthdeclaration.service;

import com.example.formhealthdeclaration.model.HealDeclaration;

public interface IHealthDeclarationService {
    HealDeclaration get();
    void update(HealDeclaration healDeclaration);
}
