package com.java.app.model;
import com.java.app.enums.Gender;
import com.java.app.enums.Membership;
import com.java.app.enums.Status;

import java.time.LocalDateTime;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String password;
    private Long phoneNo;
    private int age;
    private Gender gender;
    private Status status;
    private Membership membershipType;
    private LocalDateTime createdOn;
    private LocalDateTime lastLoggedIn;
    private Address residentialAddress;
    private Address shippingAddress;

    public Customer() {
    }

    public Customer(int id, String name, String email, String password, Long phoneNo, int age, Gender gender, Status status, Membership membershipType, LocalDateTime createdOn, LocalDateTime lastLoggedIn, Address residentialAddress, Address shippingAddress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.age = age;
        this.gender = gender;
        this.status = status;
        this.membershipType = membershipType;
        this.createdOn = createdOn;
        this.lastLoggedIn = lastLoggedIn;
        this.residentialAddress = residentialAddress;
        this.shippingAddress = shippingAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Membership getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(Membership membershipType) {
        this.membershipType = membershipType;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(LocalDateTime lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public Address getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(Address residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private int id;
        private String name;
        private String email;
        private String password;
        private Long phoneNo;
        private int age;
        private Gender gender;
        private Status status;
        private Membership membershipType;
        private LocalDateTime createdOn;
        private LocalDateTime lastLoggedIn;
        private Address residentialAddress;
        private Address shippingAddress;

        private Builder() {
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder phoneNo(Long phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Builder membershipType(Membership membershipType) {
            this.membershipType = membershipType;
            return this;
        }

        public Builder createdOn(LocalDateTime createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder lastLoggedIn(LocalDateTime lastLoggedIn) {
            this.lastLoggedIn = lastLoggedIn;
            return this;
        }

        public Builder residentialAddress(Address residentialAddress) {
            this.residentialAddress = residentialAddress;
            return this;
        }

        public Builder shippingAddress(Address shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public Customer build() {
            return new Customer(id, name, email, password, phoneNo, age, gender, status, membershipType, createdOn, lastLoggedIn, residentialAddress, shippingAddress);
        }
    }
}
