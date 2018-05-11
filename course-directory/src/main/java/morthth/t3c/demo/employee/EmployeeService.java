package morthth.t3c.demo.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Component
public class EmployeeService {

    private final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Value("${t3c.demo.employee.service.url}")
    private String employeeServiceUrl;

    public Optional<Employee> findEmployeeById(Integer lecturerId) {
        String employeeUrl = UriComponentsBuilder.fromHttpUrl(employeeServiceUrl).path("/" + lecturerId).build().toUriString();
        logger.debug("get employee: {}", employeeUrl);
        try {
            RestTemplate restTemplate = new RestTemplate();
            return Optional.of(restTemplate.getForObject(employeeUrl, Employee.class));

        } catch (RestClientException e) {
            logger.debug("Can't retrieve employee: {}", e.getMessage());
            return Optional.empty();
        }
    }

}
