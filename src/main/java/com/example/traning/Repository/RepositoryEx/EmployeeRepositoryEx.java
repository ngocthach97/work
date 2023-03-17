package com.example.traning.Repository.RepositoryEx;

import com.example.traning.Common.Payload.Request.Search;
import com.example.traning.Model.Entity.Employee;

import java.util.List;

public interface EmployeeRepositoryEx {
    public List<Object> getOrSearchEmployee(Search search);
    public boolean updateEmployee(Employee employee);
}
