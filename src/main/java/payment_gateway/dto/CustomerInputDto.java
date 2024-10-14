package payment_gateway.dto;

import lombok.Data;

@Data
public class CustomerInputDto {
    private String name;
    private String email;
    private String endereco;
    private String cpf;
}