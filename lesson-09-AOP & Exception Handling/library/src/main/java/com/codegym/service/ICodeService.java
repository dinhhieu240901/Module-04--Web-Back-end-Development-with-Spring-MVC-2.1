package com.codegym.service;

import com.codegym.model.Code;

import java.util.List;

public interface ICodeService {
    List<Code> findAll();
    Code findById(Long id);
    Code save(Code code);
    void delete(Long id);
    List<Code> findAllCodesByBookId(Long bookId);
    List<Code> findAvailableCodesByBookId(Long bookId);
    boolean existsByCodeAndStatus_StatusName(int code, String statusName);
    boolean existsByCode(int code);

}
