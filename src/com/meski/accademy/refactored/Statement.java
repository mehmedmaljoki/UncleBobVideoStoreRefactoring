package com.meski.accademy.refactored;

// This file is the original program.  It has been left here so you can compare it with the refactored version.

import java.util.ArrayList;
import java.util.List;

public class Statement {
    private String customerName;
    private List<Rental> rentals = new ArrayList<>();
    private double totalAmount;
    private int frequentRenterPoints;


    public Statement(String customerName) {
        this.customerName = customerName;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotal() {
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public String generate() {
        clearTotals();
        String statementText = header();
        statementText += rentalLines();
        statementText += footer();

        return statementText;
    }

    private String footer() {
        return "You owed " + totalAmount + "\nYou earned " + frequentRenterPoints + " frequent renter points\n";
    }

    private String rentalLines() {
        String rentalLines = "";
        for (Rental rental : rentals) {
            double thisAmount = 0;

            // determines the amount for rental line
            switch (rental.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (rental.getDaysRented() > 2) thisAmount += (rental.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += rental.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (rental.getDaysRented() > 3) thisAmount += (rental.getDaysRented() - 3) * 1.5;
                    break;
            }

            frequentRenterPoints++;

            if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            rentalLines += "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        return rentalLines;
    }

    private void clearTotals() {
        totalAmount = 0;
        frequentRenterPoints = 0;
    }

    private String header() {
        return String.format("Rental Record for %s\n", customerName);
    }
}
