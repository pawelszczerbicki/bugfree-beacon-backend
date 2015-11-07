package com.bugfree.web.order;

import com.bugfree.web.customer.Address;
import com.bugfree.web.customer.InvoiceData;
import org.springframework.data.annotation.Id;

/**
 * Created by pawel on 07.11.15.
 */
public class Order {

    @Id
    private String id;

    private String domain;

    private Integer amount;

    private InvoiceData invoiceData;

    private Address address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public InvoiceData getInvoiceData() {
        return invoiceData;
    }

    public void setInvoiceData(InvoiceData invoiceData) {
        this.invoiceData = invoiceData;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
