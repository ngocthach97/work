package com.example.traning.Repository.Repository;

import com.example.traning.Entity.Department;
import com.example.traning.Repository.RepositoryEx.DepartmentRepositoryEx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>, DepartmentRepositoryEx {
}
