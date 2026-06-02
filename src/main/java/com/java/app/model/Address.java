package com.java.app.model;

public class Address {
    private String houseNo;
    private String building;
    private String landMark;
    private String streetName;
    private String street;
    private String area;
    private String city;
    private String district;
    private String state;
    private String country;
    private int pincode;
    private int zipCode;

    public Address() {
    }

    public Address(String houseNo, String building, String landMark, String streetName, String street, String area, String city, String district, String state, String country, int pincode, int zipCode) {
        this.houseNo = houseNo;
        this.building = building;
        this.landMark = landMark;
        this.streetName = streetName;
        this.street = street;
        this.area = area;
        this.city = city;
        this.district = district;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.zipCode = zipCode;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String houseNo;
        private String building;
        private String landMark;
        private String streetName;
        private String street;
        private String area;
        private String city;
        private String district;
        private String state;
        private String country;
        private int pincode;
        private int zipCode;

        private Builder() {
        }

        public Builder houseNo(String houseNo) {
            this.houseNo = houseNo;
            return this;
        }

        public Builder building(String building) {
            this.building = building;
            return this;
        }

        public Builder landMark(String landMark) {
            this.landMark = landMark;
            return this;
        }

        public Builder streetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder area(String area) {
            this.area = area;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder district(String district) {
            this.district = district;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder pincode(int pincode) {
            this.pincode = pincode;
            return this;
        }

        public Builder zipCode(int zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Address build() {
            return new Address(houseNo, building, landMark, streetName, street, area, city, district, state, country, pincode, zipCode);
        }
    }
}
