package com.empmanage.controller;

import com.empmanage.entity.Employee;
import com.empmanage.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    public EmpService service;

    @GetMapping("/")
    public String home(Model m)
    {
        List<Employee> emp =service.getAllEmp();
        m.addAttribute("emp",emp);
        return "index";
    }

    @GetMapping("/add_emp")
    public String add()
    {
        return "add_emp";
    }

    @GetMapping("/search_emp")
    public String search_emp()
    {
        return "search_emp";
    }

    @PostMapping("/search_id")
    public String search_id(@Param("search_id") Integer search_id,Model m)
    {
        String namevalue=service.getEmpById(search_id).getName();

        System.out.println(namevalue);

        System.out.println(search_id);
        m.addAttribute("searched_name",namevalue);


        return "search_emp";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Employee e, HttpSession session)
    {
        System.out.println(e);
        service.addEmp(e);

        session.setAttribute("msg","Employee Added Successfully.......");

        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model m)
    {

       Employee e= service.getEmpById(id);
        m.addAttribute("emp",e);

        return "edit";
    }
    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee e)
    {
        service.addEmp(e);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id)
    {
        service.deleteEmp(id);
        return "redirect:/";
    }


    @PostMapping("/search_name")
    public String search_name(@Param("search_name") String search_name,Model m)
    {
        List<Employee> list=service.findByName(search_name);
        System.out.println(list);
        m.addAttribute("employee",new Employee());
        m.addAttribute("empByName",list);

        return "search_emp";
    }
}
