package com.example.customerprovincemanagement.service.province;

import com.example.customerprovincemanagement.model.Province;
import com.example.customerprovincemanagement.repository.IProvinceRepository;
import com.example.customerprovincemanagement.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepository provinceRepository;
    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public void remove(Long id) {

        provinceRepository.deleteById(id);
    }
}
