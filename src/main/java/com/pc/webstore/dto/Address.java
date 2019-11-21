package com.pc.webstore.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Przemek
 */
@Entity
public class Address implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(name = "user_id")
//    private int userId;
    @ManyToOne
    private User user;
    
    @Column(name = "address_line_one")
    private String addressLineOne;
    @Column(name = "address_line_two")
    private String addresLineTwo;
    private String city;
    private String state;
    private String country;
    @Column(name = "post_code")
    private String postCode;
    private boolean shipping;
    private boolean billing;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddresLineTwo() {
        return addresLineTwo;
    }

    public void setAddresLineTwo(String addresLineTwo) {
        this.addresLineTwo = addresLineTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public boolean isShipping() {
        return shipping;
    }

    public void setShipping(boolean shipping) {
        this.shipping = shipping;
    }

    public boolean isBilling() {
        return billing;
    }

    public void setBilling(boolean billing) {
        this.billing = billing;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", userId=" + user.getId() + ", addressLineOne=" + addressLineOne + ", addresLineTwo=" + addresLineTwo + ", city=" + city + ", state=" + state + ", country=" + country + ", postCode=" + postCode + ", shipping=" + shipping + ", biling=" + billing + '}';
    }
    
}
