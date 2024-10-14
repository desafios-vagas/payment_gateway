package payment_gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import payment_gateway.entity.Customer;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}