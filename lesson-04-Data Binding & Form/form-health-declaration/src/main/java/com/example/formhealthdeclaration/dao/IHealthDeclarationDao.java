package com.example.formhealthdeclaration.dao;

import com.example.formhealthdeclaration.model.HealDeclaration;

public interface IHealthDeclarationDao {
    HealDeclaration get();
    void update(HealDeclaration healDeclaration);
}
