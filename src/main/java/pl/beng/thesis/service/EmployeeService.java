package pl.beng.thesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.beng.thesis.model.Employee;
import pl.beng.thesis.repository.EmployeeRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public Employee find(Long id) {
        return employeeRepository.findOne(id);
    }

    @Transactional
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    public void updateEmployee(Employee updatedEmployee) {
        employeeRepository.saveAndFlush(updatedEmployee);
    }

    @Transactional
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Transactional
    public Employee findByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }
}
