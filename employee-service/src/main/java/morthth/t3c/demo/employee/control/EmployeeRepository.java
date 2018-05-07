package morthth.t3c.demo.employee.control;

import morthth.t3c.demo.employee.entity.Employee;

import java.util.Optional;

public interface EmployeeRepository {

    Iterable<Employee> findAll();

    Optional<Employee> findById(Integer employeeId);

}
