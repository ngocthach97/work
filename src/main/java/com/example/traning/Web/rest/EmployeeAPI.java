package com.example.traning.Web.rest;

import com.example.traning.Common.Payload.Request.Login;
import com.example.traning.Common.Payload.Request.Search;
//import com.example.traning.Common.Security.Config.CustomUserDetailService;
//import com.example.traning.Common.Security.Config.CustomUserDetails;
//import com.example.traning.Common.Security.JWT.JwtCommon;
import com.example.traning.Model.Entity.Employee;
import com.example.traning.Repository.Repository.EmployeeRepository;
import com.example.traning.Repository.Repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employee")
public class EmployeeAPI {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeAPI.class);

//    @Autowired
//    private AuthenticationManager authenticationManager;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProductRepository productRepository;
//    @Autowired
//    private PasswordEncoder encoder;
//    @Autowired
//    JwtCommon jwtCommon;

    @PostMapping(value = "/update")
    public ResponseEntity<Boolean> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Boolean>(employeeRepository.updateEmployee(employee), HttpStatus.OK);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<List<Object>> searchEmployee(@RequestBody Search search) {
        List<Object> list = employeeRepository.getOrSearchEmployee(search);
        return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
    }

//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(HttpServletRequest request,
//                                              HttpServletResponse response,
//                                              @RequestBody Login login) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            String jwt = jwtCommon.CreateToken(authentication);
//            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
//            return ResponseEntity.ok(jwt);
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return ResponseEntity.ok("faild");
//        }
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<Object> registerUser(@RequestBody Employee employee) {
//        if (employeeRepository.existsByUsername(employee.getUsername())) {
//            return new ResponseEntity<Object>("Username is already in use !", HttpStatus.BAD_REQUEST);
//        }
//        if (employeeRepository.existsByEmail(employee.getEmail())) {
//            return new ResponseEntity<Object>("Email is already in use !", HttpStatus.BAD_REQUEST);
//        }
//        employee.setPassword(encoder.encode(employee.getPassword()));
//        employeeRepository.save(employee);
//        return new ResponseEntity<Object>("success", HttpStatus.OK);
//    }
}
