package com.example.traning.Repository.RepositoryExImpl;

import com.example.traning.Repository.RepositoryEx.EmployeeRepositoryEx;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class EmployeeRepositoryExImpl implements EmployeeRepositoryEx {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    @Transactional
    public int updateStatus(Long id) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("update employee e set e.status = false where 1=1 AND e.id=:id");
        Query query = entityManager.createQuery(stringBuilder.toString());
        query.setParameter("id", id);
        int rowsUpdated = query.executeUpdate();
        return rowsUpdated;
    }
}
