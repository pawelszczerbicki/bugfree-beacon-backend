package com.bugfree.web.order;

import java.util.Currency;

import static java.util.Locale.US;

/**
 * Created by pawel on 07.11.15.
 */
public class Calculation {

    private Integer amount;

    private Double price;

    private Double priceWithTax;

    private Double shippingPrice;

    private String currency = Currency.getInstance(US).getSymbol();

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Calculation withPrice(Double price) {
        setPrice(price);
        return this;
    }

    public Calculation calculateTax(Double tax) {
        if (amount != null)
            priceWithTax = price + price * tax;
        return this;
    }

    public Double getPriceWithTax() {
        return priceWithTax;
    }

    public Double getShippingPrice() {
        return shippingPrice;
    }

    public Calculation withShippingPrice(Double shippingPrice) {
        this.shippingPrice = shippingPrice;
        return this;
    }

    public String getCurrency() {
        return currency;
    }
}
