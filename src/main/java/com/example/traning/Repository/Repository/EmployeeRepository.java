package com.example.traning.Repository.Repository;

import com.example.traning.Entity.Employee;
import com.example.traning.Repository.RepositoryEx.EmployeeRepositoryEx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeRepositoryEx {
    public List<Employee> findAllByStatusIsTrue();
}
