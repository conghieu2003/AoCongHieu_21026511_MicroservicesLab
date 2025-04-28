package vn.edu.iuh.fit.dhktpm17a.customerservices.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import vn.edu.iuh.fit.dhktpm17a.customerservices.dto.CustomerDTO;
import vn.edu.iuh.fit.dhktpm17a.customerservices.entities.Customer;
import vn.edu.iuh.fit.dhktpm17a.customerservices.repositories.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        customer.setAddress(customerDTO.getAddress());

        Customer savedCustomer = customerRepository.save(customer);
        return new CustomerDTO(savedCustomer.getId(), savedCustomer.getName(),
                savedCustomer.getEmail(), savedCustomer.getPhone(),
                savedCustomer.getAddress());
    }
    public List<CustomerDTO> getAllCustomers() {
    List<Customer> customers = customerRepository.findAll();
    return customers.stream()
        .map(customer -> new CustomerDTO(
            customer.getId(), 
            customer.getName(),
            customer.getEmail(), 
            customer.getPhone(),
            customer.getAddress()))
        .collect(Collectors.toList());
}

    public CustomerDTO getCustomer(String id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy khách hàng"));
        return new CustomerDTO(customer.getId(), customer.getName(),
                customer.getEmail(), customer.getPhone(),
                customer.getAddress());
    }

    public CustomerDTO updateCustomer(String id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy khách hàng"));
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        customer.setAddress(customerDTO.getAddress());
        Customer updatedCustomer = customerRepository.save(customer);
        return new CustomerDTO(updatedCustomer.getId(), updatedCustomer.getName(),
                updatedCustomer.getEmail(), updatedCustomer.getPhone(),
                updatedCustomer.getAddress());
    }

    public void deleteCustomer(String id) {
        if (!customerRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy khách hàng");
        }
        customerRepository.deleteById(id);
    }
}