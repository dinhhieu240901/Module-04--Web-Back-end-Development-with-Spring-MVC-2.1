package com.example.customerprovincemanagement.repository;

import com.example.customerprovincemanagement.model.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepository extends CrudRepository<Province,Long> {
}
