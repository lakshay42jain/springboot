package com.empmanage.controller;
import com.empmanage.entity.Employee;

import com.empmanage.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController2 {

    @Autowired
    public EmpService service;

    @PostMapping("/add_emp")
    public String add(@RequestBody Employee e)
    {
        service.addEmp(e);
        return e.toString();
    }

    @PostMapping("/add_emp_mul")
    public String add_mul(@RequestBody List<Employee> e)
    {
        e.forEach(s->service.addEmp(s));
        return "Success Ful";
    }

    @GetMapping("/listall")
    public List<Employee> getAll(){
        return service.getAllEmp();
    }


    @PutMapping("/update/{id}")
    public String update(@PathVariable Integer id,@RequestBody Employee e){

        Employee emp=service.getEmpById(id);
        emp.setName(e.getName());
        emp.setPhone(e.getPhone());
        emp.setAddress(e.getAddress());
        emp.setSalary(e.getSalary());
        emp.setEmail(e.getEmail());
        service.addEmp(emp);
        return emp.toString();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id)
    {
        service.deleteEmp(id);
        return id+" successfully deleted";
    }



}
