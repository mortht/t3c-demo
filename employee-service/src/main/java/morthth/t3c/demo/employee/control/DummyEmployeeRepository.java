package morthth.t3c.demo.employee.control;

import morthth.t3c.demo.employee.entity.Employee;
import morthth.t3c.demo.employee.entity.Role;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class DummyEmployeeRepository implements EmployeeRepository {

    private final AtomicInteger idCounter = new AtomicInteger(1);

    private final Map<Integer, Employee> employeeMap = new HashMap<>();

    @PostConstruct
    void setup() {
        Employee assistant1 = new Employee();
        assistant1.setTitle("Mr");
        assistant1.setFirstName("Assistant");
        assistant1.setSurName("One");
        assistant1.getRoles().add(Role.RESEARCH_ASSISTANT);
        save(assistant1);

        Employee lecturer1 = new Employee();
        lecturer1.setTitle("Prof");
        lecturer1.setFirstName("Lecturer");
        lecturer1.setSurName("One");
        lecturer1.getRoles().add(Role.LECTURER);
        save(lecturer1);

        Employee assistant2 = new Employee();
        assistant2.setTitle("Ms");
        assistant2.setFirstName("Assistant");
        assistant2.setSurName("Two");
        assistant2.getRoles().add(Role.RESEARCH_ASSISTANT);
        save(assistant2);

        Employee lecturer2 = new Employee();
        lecturer2.setTitle("Prof Dr");
        lecturer2.setFirstName("Lecturer");
        lecturer2.setSurName("Two");
        lecturer2.getRoles().add(Role.LECTURER);
        save(lecturer2);

        Employee secretary = new Employee();
        secretary.setTitle("Mr");
        secretary.setFirstName("Department");
        secretary.setSurName("Secretary");
        secretary.getRoles().add(Role.ADMINISTRATIVE);
        save(secretary);

    }

    private Employee save(Employee employee) {
        employee.setId(idCounter.getAndIncrement());
        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeMap.values();
    }

    @Override
    public Optional<Employee> findById(Integer employeeId) {
        return Optional.ofNullable(employeeMap.get(employeeId));
    }
}
