package com.example.traning.Web.web;

import com.example.traning.Entity.Employee;
import com.example.traning.Repository.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee/")
public class EmployeeWeb {
    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("signup")
    public String showSignUpForm(Employee employee) {
        return "add-employee";
    }

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("employee", employeeRepository.findAllByStatusIsTrue());
        return "index";
    }

    @PostMapping("add")
    public String addStudent(@Valid Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-employee";
        }
        employeeRepository.save(employee);
        return "redirect:index";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        model.addAttribute("employee", employee);
        return "update-employee";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        employeeRepository.updateStatus(id);
        model.addAttribute("employee", employeeRepository.findAllByStatusIsTrue());
        return "index";
    }
}
