package com.java.app.model;

public class Product {
    private int id;
    private String name;
    private double maxRetailPrice;
    private float discountPercentage;
    private boolean isAvailable;
    private String company;
    private String category;
    private int manufacturedYear;

    public Product() {
    }

    public Product(int id, String name, double maxRetailPrice, float discountPercentage, boolean isAvailable, String company, String category, int manufacturedYear) {
        this.id = id;
        this.name = name;
        this.maxRetailPrice = maxRetailPrice;
        this.discountPercentage = discountPercentage;
        this.isAvailable = isAvailable;
        this.company = company;
        this.category = category;
        this.manufacturedYear = manufacturedYear;
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

    public double getMaxRetailPrice() {
        return maxRetailPrice;
    }

    public void setMaxRetailPrice(double maxRetailPrice) {
        this.maxRetailPrice = maxRetailPrice;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(int manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private int id;
        private String name;
        private double maxRetailPrice;
        private float discountPercentage;
        private boolean isAvailable;
        private String company;
        private String category;
        private int manufacturedYear;

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

        public Builder maxRetailPrice(double maxRetailPrice) {
            this.maxRetailPrice = maxRetailPrice;
            return this;
        }

        public Builder discountPercentage(float discountPercentage) {
            this.discountPercentage = discountPercentage;
            return this;
        }

        public Builder isAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder manufacturedYear(int manufacturedYear) {
            this.manufacturedYear = manufacturedYear;
            return this;
        }

        public Product build() {
            return new Product(id, name, maxRetailPrice, discountPercentage, isAvailable, company, category, manufacturedYear);
        }
    }
}
