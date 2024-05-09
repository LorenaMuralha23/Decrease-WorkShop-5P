package com.decrease.controller;

import com.decrease.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvoiceController {

    @Autowired
    private InvoiceService service;
    
    public InvoiceController() {
    }
    
    public void generateInvoice(String rootPathToSave){
        service.generateInvoice(rootPathToSave);
    }
    
    
}
