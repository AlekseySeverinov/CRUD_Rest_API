package spring.app.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.app.application.model.Employee;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<Employee, Integer> {

}
