package payment_gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payment_gateway.entity.Customer;
import payment_gateway.dto.CustomerInputDto;
import payment_gateway.repository.CustomerRepository;

import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(CustomerInputDto customerInputDto) {
        Customer customer = new Customer();
        customer.setName(customerInputDto.getName());
        customer.setEmail(customerInputDto.getEmail());
        customer.setEndereco(customerInputDto.getEndereco());
        customer.setCpf(customerInputDto.getCpf());
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(UUID id) {
        return customerRepository.findById(id).orElse(null);
    }

}