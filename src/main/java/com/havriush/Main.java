package com.havriush;

import com.havriush.model.Customer;
import com.havriush.service.CustomerService;
import com.havriush.service.FilmService;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();

        //This method handles the transaction of creating a new customer
        // along with all dependent fields in the customer table.
        Customer customer = customerService.createCustomer();

        //This method handles the transaction of a customer
        // returning a previously rented movie.
        customerService.customerReturnInventoryToStore();

        //This method handles the transaction of a customer renting inventory
        // from a store and making a payment to the staff.
        customerService.customerRentInventory(customer);

        FilmService filmService = new FilmService();

        //This method handles the transaction of adding a new movie
        // and making it available for rent.
        filmService.productionNewFilm();
    }
}