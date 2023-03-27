//package com.example.traning.Common.Security.Config;
//
//import com.example.traning.Model.Entity.Employee;
//import com.example.traning.Repository.Repository.EmployeeRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.NoResultException;
//
//@Component
//
//public class CustomUserDetailService implements UserDetailsService {
//    @Autowired
//    EmployeeRepository employeeRepository;
//
//    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Employee employee = new Employee();
//        try {
//            employee = employeeRepository.findByUsername(username);
//            return new CustomUserDetails(employee);
//        } catch (NoResultException e) {
//            logger.error("NoResultException:", e.getMessage());
//        } finally {
//            return new CustomUserDetails(employee);
//        }
//    }
//}
