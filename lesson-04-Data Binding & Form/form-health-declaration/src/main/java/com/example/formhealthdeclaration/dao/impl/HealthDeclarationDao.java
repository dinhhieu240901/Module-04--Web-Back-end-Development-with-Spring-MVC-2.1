package com.example.formhealthdeclaration.dao.impl;

import com.example.formhealthdeclaration.dao.IHealthDeclarationDao;
import com.example.formhealthdeclaration.model.HealDeclaration;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class HealthDeclarationDao implements IHealthDeclarationDao {
    private HealDeclaration healDeclaration = new HealDeclaration();
    public HealthDeclarationDao(){
        Map<String ,Boolean> map = new LinkedHashMap<>();
        map.put("fever",false);
        map.put("cough",false);
        Map<String,Boolean> map1= new LinkedHashMap<>();
        map1.put("Animal exposure",false);
        map1.put("Covid patient exposure",false);
        healDeclaration.setSymptoms(map);
        healDeclaration.setExposureHistory(map1);
    }
    @Override
    public HealDeclaration get() {
        return  healDeclaration;
    }

    @Override
    public void update(HealDeclaration healDeclaration) {
        this.healDeclaration = healDeclaration;
    }
}
