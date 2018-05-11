package morthth.t3c.demo.employee;

import morthth.t3c.demo.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeResource {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeResource(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @RequestMapping(path = "{employeeId}")
    ResponseEntity<Employee> getEmployee(@PathVariable Integer employeeId) {
        return employeeRepository.findById(employeeId)
                .map(employee -> ResponseEntity.ok(employee))
                .orElse(ResponseEntity.notFound().build());
    }


}
