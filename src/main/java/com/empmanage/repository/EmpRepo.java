package com.empmanage.repository;

import com.empmanage.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer> {

//    List<Employee> findAllByName(String name);

    List<Employee> findByNameContaining(String name);

}

