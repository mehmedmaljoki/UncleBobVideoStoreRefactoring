package com.meski.accademy.original;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class VideoStoreTest extends TestCase {

    private Customer customer;

    public VideoStoreTest(String name) {
        super(name);
    }

    @Before
    protected void setUp() {
        customer = new Customer("Mehmed");
    }

    @Test
    public void testSingleNewReleaseStatement() {
        customer.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));
        assertEquals(
                "Rental Record for Mehmed\n" +
                        "\tThe Cell\t9.0\n" +
                        "You owed 9.0\n" +
                        "You earned 2 frequent renter points\n",
                customer.statement());
    }

    public void testDualNewReleaseStatement() {
        customer.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("The Tiger Movie", Movie.NEW_RELEASE), 3));
        assertEquals(
                "Rental Record for Mehmed\n" +
                        "\tThe Cell\t9.0\n" +
                        "\tThe Tiger Movie\t9.0\n" +
                        "You owed 18.0\n" +
                        "You earned 4 frequent renter points\n",
                customer.statement());
    }

    public void testSingleChildrensStatement() {
        customer.addRental(new Rental(new Movie("The Tiger Movie", Movie.CHILDRENS), 3));
        assertEquals(
                "Rental Record for Mehmed\n" +
                        "\tThe Tiger Movie\t1.5\n" +
                        "You owed 1.5\n" +
                        "You earned 1 frequent renter points\n",
                customer.statement());
    }


    public void testMultipleRegularStatement() {
        customer.addRental(new Rental(new Movie("Plan 9 from Outer Space", Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie("8 1/2", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Eraserhead", Movie.REGULAR), 3));

        assertEquals(
                "Rental Record for Mehmed\n" +
                        "\tPlan 9 from Outer Space\t2.0\n" +
                        "\t8 1/2\t2.0\n" +
                        "\tEraserhead\t3.5\n" +
                        "You owed 7.5\n" +
                        "You earned 3 frequent renter points\n",
                customer.statement()
        );
    }

    public void testRentalStatementFormat() {
    }
}