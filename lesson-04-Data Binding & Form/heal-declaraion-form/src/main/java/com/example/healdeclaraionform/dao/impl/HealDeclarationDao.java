package com.example.healdeclaraionform.dao.impl;

import com.example.healdeclaraionform.dao.IHealthDeclarationDao;
import com.example.healdeclaraionform.model.HealDeclaration;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;
@Repository
public class HealDeclarationDao  implements IHealthDeclarationDao {
    private HealDeclaration healDeclaration = new HealDeclaration();
    public HealDeclarationDao(){
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
