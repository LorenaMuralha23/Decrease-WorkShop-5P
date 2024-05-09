package com.decrease.interfaces;

import com.decrease.entities.Order;
import com.decrease.entities.User;

public interface invoicePrinter {
    public void generateInvoice();
    public Object configPDFGenerator(User user, Order orderToRegister);
}
