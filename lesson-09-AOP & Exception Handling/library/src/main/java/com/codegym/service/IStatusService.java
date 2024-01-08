package com.codegym.service;



import com.codegym.model.Status;

import java.util.List;

public interface IStatusService {
    List<Status> findAll();
    Status findById(Long id);
    Status save(Status status);
    void delete(Long id);
    Status findByStatusName(String statusName);

}
