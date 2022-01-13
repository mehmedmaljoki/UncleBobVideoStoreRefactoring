package com.meski.accademy.refactored;

public abstract class Movie {

    private String title;
    int priceCode;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    abstract double determineAmount(int daysRented);

    abstract int determineFrequentRenterPoints(int daysRented);
}