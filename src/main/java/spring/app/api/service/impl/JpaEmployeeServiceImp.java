package spring.app.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.app.application.model.Employee;
import spring.app.application.repository.JpaEmployeeRepository;
import spring.app.application.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaEmployeeServiceImp implements EmployeeService {
    private final JpaEmployeeRepository jpaEmployeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        return jpaEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return jpaEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return jpaEmployeeRepository.findById(id).get();
    }

    public Employee updateEmployee(Employee employee) {

          return null;
    }


    @Override
    public Boolean deleteById (Integer id) {
         jpaEmployeeRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
