package com.company;

public class Movie {

    String title;
    Boolean inStock;
    int rentDate;

    public Movie(String title, Boolean inStock, int rentDate) {
        this.title = title;
        this.inStock = inStock;
        this.rentDate = rentDate;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public int getRentDate() {
        return rentDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public void setRentDate(int rentDate) {
        this.rentDate = rentDate;
    }

    public void returned() {
        inStock = true;
    }

    public void rentedOut() {
        inStock = false;
    }

}
