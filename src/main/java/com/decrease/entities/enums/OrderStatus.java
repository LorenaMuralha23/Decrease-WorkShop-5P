package com.decrease.entities.enums;

import com.decrease.model.Alerts;
import com.decrease.model.CustomException;

/**
 * Enumeração que representa o status de um pedido.
 */
public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    /**
     * Construtor que inicializa o status do pedido com o código fornecido.
     * @param code O código do status do pedido.
     */
    private OrderStatus(int code) {
        this.code = code;
    }

    /**
     * Obtém o código do status do pedido.
     * @return O código do status do pedido.
     */
    public int getCode() {
        return code;
    }

    /**
     * Obtém a representação em forma de string do código do status do pedido.
     * @return A representação em forma de string do código do status do pedido.
     */
    public String getCodeString() {
        switch (this.code) {
            case 1:
                return "Waiting Payment";
            case 2:
                return "Paid";
            case 3:
                return "Shipped";
            case 4:
                return "Delivered";
            case 5:
                return "Canceled";
        }
        return null;
    }

    /**
     * Obtém o enum correspondente ao código fornecido.
     * @param code O código do status do pedido.
     * @return O enum correspondente ao código fornecido.
     */
    public static OrderStatus valueOf(int code) {
        String msg;

        try {
            for (OrderStatus value : OrderStatus.values()) {
                if (value.getCode() == code) {
                    return value;
                }
            }
            
            msg = """
                    Invalid code!
                    """;

            throw new CustomException(msg);
            
        } catch (CustomException e) {
            Alerts.showErrorMessage(e.getMessage(), "There was a Problem", null);
        }
        
        return null;
    }
    
}