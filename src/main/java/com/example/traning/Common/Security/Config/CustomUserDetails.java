//package com.example.traning.Common.Security.Config;
//
//import com.example.traning.Model.Entity.Employee;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.Collections;
//
//@Data
//@NoArgsConstructor
//@Component
//public class CustomUserDetails  implements UserDetails {
//    @Autowired
//    private Employee employee;
//
//    public CustomUserDetails(Employee employee) {
//        this.employee = employee;
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(new SimpleGrantedAuthority(employee.getRole()));
//    }
//
//    @Override
//    public String getPassword() {
//        return employee.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return employee.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
