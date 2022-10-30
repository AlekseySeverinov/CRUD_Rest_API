package spring.app.application.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import spring.app.application.model.Employee;

import spring.app.application.service.impl.JpaEmployeeServiceImp;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/employees")
public class EmployeeResource {
    private final JpaEmployeeServiceImp jpaEmployeeServiceImp;

    @GetMapping
    public ResponseEntity <List<Employee>> getEmployees() {
        return ResponseEntity.ok(jpaEmployeeServiceImp.getAllEmployees());
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(jpaEmployeeServiceImp.findById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.created(getLocation(employee.getId())).body
                (jpaEmployeeServiceImp.addEmployee(employee));

    }

    protected static URI getLocation(Integer id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(jpaEmployeeServiceImp.deleteById(id));
    }
    @PutMapping
    public ResponseEntity<Boolean> updateEmployee () {
        return null;
    }

    }


