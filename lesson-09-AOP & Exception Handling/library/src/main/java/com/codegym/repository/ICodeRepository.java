package com.codegym.repository;

import com.codegym.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICodeRepository extends JpaRepository<Code,Long> {
    List<Code> findAllByBook_Id(Long bookId);
    boolean existsByCodeAndStatus_StatusName(int code, String statusName);
    boolean existsByCode(int code);

}
