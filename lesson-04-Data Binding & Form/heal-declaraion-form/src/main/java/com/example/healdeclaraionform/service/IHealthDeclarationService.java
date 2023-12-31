package com.example.healdeclaraionform.service;

import com.example.healdeclaraionform.model.HealDeclaration;

public interface IHealthDeclarationService {
    HealDeclaration get();
    void update(HealDeclaration healDeclaration);
}
