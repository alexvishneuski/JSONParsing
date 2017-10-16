package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model.datamodel;

import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("mId")
    private Integer id;
    @SerializedName("mFirstName")
    private String firstName;
    @SerializedName("mPatronymic")
    private String patronymic;
    @SerializedName("mLastName")
    private String lastName;
    @SerializedName("mCompanyName")
    private String companyName;
    @SerializedName("mAddress")
    private String address;
    @SerializedName("mPhoneNumber")
    private String phoneNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getCustomerGroupId() {
        return customerGroupId;
    }

    public void setCustomerGroupId(Integer customerGroupId) {
        this.customerGroupId = customerGroupId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    private Integer customerGroupId;
    private Integer managerId;
}
