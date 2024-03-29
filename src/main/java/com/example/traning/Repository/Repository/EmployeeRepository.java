package com.example.traning.Repository.Repository;

import com.example.traning.Model.Entity.Employee;
import com.example.traning.Repository.RepositoryEx.EmployeeRepositoryEx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeRepositoryEx {
    public List<Employee> findAllByStatusIsTrue();
    Employee findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String gmail);

}
