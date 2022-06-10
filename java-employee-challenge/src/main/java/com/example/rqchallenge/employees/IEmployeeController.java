package com.example.rqchallenge.employees;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rqchallenge.vo.EmployeeVO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public interface IEmployeeController {

    @GetMapping()
    ResponseEntity<List<EmployeeVO>> getAllEmployees() throws IOException;

    @GetMapping("/search/{searchString}")
    ResponseEntity<List<EmployeeVO>> getEmployeesByNameSearch(@PathVariable String searchString);

    @GetMapping("/{id}")
    ResponseEntity<EmployeeVO> getEmployeeById(@PathVariable String id);

    @GetMapping("/highestSalary")
    ResponseEntity<Integer> getHighestSalaryOfEmployees();

    @GetMapping("/topTenHighestEarningEmployeeNames")
    ResponseEntity<List<String>> getTopTenHighestEarningEmployeeNames();

    @PostMapping()
    ResponseEntity<EmployeeVO> createEmployee(@RequestBody Map<String, Object> employeeInput);

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteEmployeeById(@PathVariable String id);

}
