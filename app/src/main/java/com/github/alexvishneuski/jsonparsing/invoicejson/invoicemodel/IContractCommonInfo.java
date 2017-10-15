package com.github.alexvishneuski.jsonparsing.invoicejson.invoicemodel;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface IContractCommonInfo {

    Integer getContractId();

    Timestamp getCreated();

    ContractStatus getContractStatus();

    // PayForm getPayForm() ;

    // PayStatus getPayStatus() ;

    //Integer getCustomerId();

    // CustomerType getCustomerType() ;

    String getCustomerCompanyName();

    //String getCustomerLastName();

    //String getManagerLastName();

    BigDecimal getTotalAmount();

}
