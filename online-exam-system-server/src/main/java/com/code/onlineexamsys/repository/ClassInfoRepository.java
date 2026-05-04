package com.code.onlineexamsys.repository;

import com.code.onlineexamsys.entity.ClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassInfoRepository extends JpaRepository<ClassInfo, Integer> {
    ClassInfo findNameById(Integer classId);
}