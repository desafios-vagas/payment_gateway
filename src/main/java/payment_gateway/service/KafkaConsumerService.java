package payment_gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import payment_gateway.config.OrderMessage;

@Service
public class KafkaConsumerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "order-check", groupId = "order-check-group")
    public void listen(OrderMessage message) {
        try {
            String cpf = message.getCpf();
            String creditCardNumero = message.getCreditCardNumero();
            String preco = message.getPreco();
            System.out.println("Received message with CPF: " + cpf + ", Credit Card Number: " + creditCardNumero + ", Preço: " + preco);

            int statusCode = 333;
            String responseMessage = "Pagamento não autorizado para CPF: " + cpf + ", Credit Card: " + creditCardNumero + ", Preço: " + preco;


            sendResponse("order-check.reply", responseMessage, statusCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendResponse(String topic, String message, int statusCode) {
        String fullMessage = message + " | Status Code: " + statusCode;
        System.out.println("Sending message to topic: " + topic + " with message: " + fullMessage);
        kafkaTemplate.send(topic, fullMessage);
    }
}