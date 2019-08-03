//package com.company.LizPerryU1Capstone.controller;
//
//import com.company.LizPerryU1Capstone.exception.NotFoundException;
//import com.company.LizPerryU1Capstone.service.InvoiceInventoryService;
//import com.company.LizPerryU1Capstone.viewmodel.PurchaseViewModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/purchase") //purchase api for customer to buy stuff
//public class PurchaseInventoryController {
//
//    @Autowired
//    InvoiceInventoryService inventoryService;
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public PurchaseViewModel createPurchase(@RequestBody PurchaseViewModel purchase) {
//
//        return inventoryService.savePurchase(purchase);
//
//    }
//
//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public PurchaseViewModel getPurchase(@PathVariable("id") int invoiceId) {
//        PurchaseViewModel invoice = inventoryService.findPurchase(invoiceId);
//
//        if (invoice == null)
//            throw new NotFoundException("Invoice could not be retrieved for id " + invoiceId);
//        return invoice;
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deletePurchase(@PathVariable("id") int invoiceId) {
//
//        inventoryService.removePurchase(invoiceId);
//    }
//
//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updatePurchase(@PathVariable("id") int invoiceId, @RequestBody @Valid PurchaseViewModel purchaseViewModel) {
//
//        if (purchaseViewModel.getId() == 0)
//            purchaseViewModel.setId(invoiceId);
//
//        if(invoiceId != purchaseViewModel.getId()) {
//            throw new IllegalArgumentException("Invoice ID on path must match the ID in the Invoice object!");
//        }
//        inventoryService.updatePurchase(purchaseViewModel);
//    }
//
//}
