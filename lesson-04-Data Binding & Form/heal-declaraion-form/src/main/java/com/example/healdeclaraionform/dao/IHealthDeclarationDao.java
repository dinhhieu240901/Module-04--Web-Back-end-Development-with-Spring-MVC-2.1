package com.example.healdeclaraionform.dao;

import com.example.healdeclaraionform.model.HealDeclaration;

public interface IHealthDeclarationDao {

    HealDeclaration get();
    void update(HealDeclaration healDeclaration);
}
