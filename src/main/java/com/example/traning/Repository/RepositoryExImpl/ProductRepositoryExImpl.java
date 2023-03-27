package com.example.traning.Repository.RepositoryExImpl;

import com.example.traning.Common.Constant;
import com.example.traning.Common.Constraints.Validation;
import com.example.traning.Common.Payload.Request.Search;
import com.example.traning.Model.Entity.Product;
import com.example.traning.Repository.RepositoryEx.ProductRepositoryEx;
import oracle.jdbc.OracleTypes;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryExImpl implements ProductRepositoryEx {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Object> searchProduct(Search search) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Object> map = new HashMap<>();
        stringBuilder.append("SELECT P.NAME AS name,P.DESCRIBE AS describe,P.PRICE AS price,P.DISCOUNT AS discount,P.UNIT AS unit,I.NAME AS nameImage FROM PRODUCT P");
        stringBuilder.append(" INNER JOIN IMAGE I ON P.ID = I.PRODUCTID");
        stringBuilder.append(" WHERE 1=1");
        if (Validation.isNotNull(search.getProductID())) {
            stringBuilder.append(" AND P.ID=:ID");
            map.put("ID", search.getProductID());
        }
        if (Validation.isNotNull(search.getCategoryID())) {
            stringBuilder.append(" AND P.CATEGORYID=:CATEGORYID");
            map.put("CATEGORYID", search.getCategoryID());
        }
        stringBuilder.append(" ORDER BY");
        if (Validation.isNotNull(search.getIsDiscount())) {
            if (search.getIsDiscount() == true) {
                stringBuilder.append(" P.DISCOUNT DESC,");
            }
        }
        if (Validation.isNotNull(search.getIsPrice())) {
            if (search.getIsDiscount() == true) {
                stringBuilder.append(" P.PRICE DESC,");
            } else {
                stringBuilder.append(" P.PRICE ASC,");
            }
        }
        char value = stringBuilder.charAt(stringBuilder.length() - 1);
        if (Validation.isComma(value)) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else {
            int start = stringBuilder.length() - 8;
            int end = stringBuilder.length();
            stringBuilder.replace(start, end, " ");
        }
        Query query = entityManager.createNativeQuery(stringBuilder.toString(), "ProductResult");
        if (Validation.isNotNull(search.getProductID())) {
            if (search.getSize() > 0) {
                query.setFirstResult(search.getSize() * search.getPage());
                query.setFirstResult(search.getSize());
            } else {
                query.setFirstResult(0);
                query.setFirstResult(Constant.maxSize);
            }
        }
        List<Object> list = query.getResultList();
        return list;
    }

    @Override
    public Long getCountDistrict(String districtCode) {
        Long count = 0L;
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("GET_DISTRICT");
        storedProcedureQuery.registerStoredProcedureParameter("provinceID", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("countDistrict", Long.class, ParameterMode.OUT);
        storedProcedureQuery.setParameter("provinceID", districtCode);
        storedProcedureQuery.execute();
        count = (Long) storedProcedureQuery.getOutputParameterValue("countDistrict");
        return count;
    }

    @Override
    public List<Product> getProduct() {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("GET_PRODUCT", Product.class);
        storedProcedureQuery.registerStoredProcedureParameter("refcursor", void.class,ParameterMode.REF_CURSOR);
        storedProcedureQuery.execute();
        List<Product> resultList = storedProcedureQuery.getResultList();
        return resultList;
    }
}
