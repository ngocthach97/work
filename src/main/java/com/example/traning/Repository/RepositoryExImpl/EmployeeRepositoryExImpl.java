package com.example.traning.Repository.RepositoryExImpl;

import com.example.traning.Common.Constant;
import com.example.traning.Common.Constraints.Validation;
import com.example.traning.Common.Payload.Request.Search;
import com.example.traning.Model.DTO.EmployeeDTO;
import com.example.traning.Model.Entity.Employee;
import com.example.traning.Repository.RepositoryEx.EmployeeRepositoryEx;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepositoryExImpl implements EmployeeRepositoryEx {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public boolean updateEmployee(Employee employee) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Object> map = new HashMap<>();
        stringBuilder.append("UPDATE EMPLOYEE E SET");
        if (Validation.isNotNull(employee.getStatus())) {
            stringBuilder.append(" E.STATUS = :STATUS,");
            map.put("STATUS", employee.getStatus());
        }
        if (map.isEmpty()) {
            return false;
        }
        char value = stringBuilder.charAt(stringBuilder.length() - 1);
        if (Validation.isComma(value)) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        stringBuilder.append(" WHERE 1=1");
        if (Validation.isNotNull(employee.getId())) {
            stringBuilder.append(" AND E.ID = :ID");
            map.put("ID", employee.getId());
        }
        Query query = entityManager.createNativeQuery(stringBuilder.toString());
        map.forEach(query::setParameter);
        int result = query.executeUpdate();
        if (result > 0) {
            return true;
        }
        return false;
    }

    public List<Object> getOrSearchEmployee(Search search) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Object> map = new HashMap<>();
        stringBuilder.append("SELECT E.NAME,E.PHONE,E.EMAIL FROM EMPLOYEE E WHERE 1=1");
        if (Validation.isNotNull(search.getProvinceCode())) {
            stringBuilder.append(" AND E.PROVINCE_CODE=:PROVINCE_CODE");
            map.put("PROVINCE_CODE", search.getProvinceCode());
        }
        if (Validation.isNotNull(search.getDistrictCode())) {
            stringBuilder.append(" AND E.DISTRICT_CODE=:DISTRICT_CODE");
            map.put("DISTRICT_CODE", search.getDistrictCode());
        }
        if (Validation.isNotNull(search.getWardCode())) {
            stringBuilder.append(" AND E.WARD_CODE=:WARD_CODE");
            map.put("WARD_CODE", search.getWardCode());
        }
        if (Validation.isNotNull(search.getEmployeeID())) {
            stringBuilder.append(" AND E.ID=:ID");
            map.put("ID", search.getEmployeeID());
        }
        stringBuilder.append(" AND E.STATUS=1");
        Query query = entityManager.createNativeQuery(stringBuilder.toString(),"EmployeeResult");
        if (!map.isEmpty()) {
            map.forEach(query::setParameter);
        }
        if (Validation.isNull(search.getEmployeeID())) {
            if (search.getSize() <= 0) {
                query.setFirstResult(0);
                query.setMaxResults(Constant.maxSize);
            } else {
                query.setFirstResult(search.getSize() * search.getPage());
                query.setMaxResults(search.getSize());
            }
        }
        List<Object> list = query.getResultList();
        return list;
    }
}
