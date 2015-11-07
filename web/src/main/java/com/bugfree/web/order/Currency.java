package com.bugfree.web.order;

import static java.util.Currency.getInstance;
import static java.util.Locale.US;

/**
 * Created by pawel on 07.11.15.
 */
public class Currency {

    private String currencySymbol = getInstance(US).getSymbol();

    private String currencyCode = getInstance(US).getCurrencyCode();

    private String currencyName = getInstance(US).getDisplayName();

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }
}
