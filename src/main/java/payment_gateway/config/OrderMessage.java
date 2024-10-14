package payment_gateway.config;

import lombok.Data;

@Data
public class OrderMessage {
    private String cpf;
    private String creditCardNumero;
    private String nome;
    private String produto;
    private String preco;
    private String identificador;
    private String status_pedido;
    private int status_code;
    private String order_number;
}