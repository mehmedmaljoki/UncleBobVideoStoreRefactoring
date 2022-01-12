package com.meski.accademy.refactored;

public class Rental
{
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    private Movie movie;
    private int daysRented;
}