package com.group11.Models;

public class CustomerAddress {
    String CustName;
    String CustAddress;
    String CustPhone;


    public CustomerAddress(String custName, String custAddress, String custPhone) {
        CustName = custName;
        CustAddress = custAddress;
        CustPhone = custPhone;
    }

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String custName) {
        CustName = custName;
    }

    public String getCustAddress() {
        return CustAddress;
    }

    public void setCustAddress(String custAddress) {
        CustAddress = custAddress;
    }

    public String getCustPhone() {
        return CustPhone;
    }

    public void setCustPhone(String custPhone) {
        CustPhone = custPhone;
    }
}
