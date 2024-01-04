package com.example.customerprovincemanagement.formatter;

import com.example.customerprovincemanagement.model.Province;
import com.example.customerprovincemanagement.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ProvinceFormatter implements Formatter<Province> {
    private final IProvinceService provinceService;

    @Autowired
    public ProvinceFormatter(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }


    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        Optional<Province> province = provinceService.findById(Long.valueOf(text));
        return province.orElse(null);
    }

    @Override
    public String print(Province object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }

}
