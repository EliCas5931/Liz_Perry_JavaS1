package com.company.LizPerryU1Capstone.controller;

import com.company.LizPerryU1Capstone.exception.NotFoundException;
import com.company.LizPerryU1Capstone.service.InvoiceInventoryService;
import com.company.LizPerryU1Capstone.viewmodel.InvoiceViewModel;
import com.company.LizPerryU1Capstone.viewmodel.PurchaseViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/invoice") //invoice API
public class InvoiceInventoryController {

    @Autowired
    InvoiceInventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createInvoice(@RequestBody PurchaseViewModel purchaseViewModel) throws InvoiceInventoryService.InvalidInputException, Exception {

        return inventoryService.saveInvoice(purchaseViewModel);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InvoiceViewModel getInvoice(@PathVariable("id") int invoiceId) {
        InvoiceViewModel invoice = inventoryService.findInvoice(invoiceId);

        if (invoice == null)
            throw new NotFoundException("Invoice could not be found for id " + invoiceId);
        return invoice;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceViewModel> getAllInvoices() {

        return inventoryService.getAllInvoices();

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoice(@PathVariable("id") int invoiceId) {

        inventoryService.removeInvoice(invoiceId);

    }
}
