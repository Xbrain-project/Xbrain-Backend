package com.Xbrain.BackendXbrain.repository;

import com.Xbrain.BackendXbrain.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
