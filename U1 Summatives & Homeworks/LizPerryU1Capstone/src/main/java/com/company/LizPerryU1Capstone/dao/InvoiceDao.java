package com.company.LizPerryU1Capstone.dao;

import com.company.LizPerryU1Capstone.model.Invoice;

import java.util.List;

public interface InvoiceDao {

    Invoice addInvoice (Invoice invoice);

    Invoice getInvoice(int id);

    List<Invoice> getAllInvoices();

    //Pretty sure I do not need this.
//    void updateInvoice(Invoice invoice);

    void deleteInvoice(int id);


}
