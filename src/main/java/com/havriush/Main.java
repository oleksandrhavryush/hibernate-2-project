package com.havriush;

import com.havriush.model.Customer;
import com.havriush.service.CustomerService;
import com.havriush.service.FilmService;

public class Main {
    public static void main(String[] args) {
        /*CustomerService customerService = new CustomerService();
        Customer customer = customerService.createCustomer();
        customerService.customerReturnInventoryToStore();
        customerService.customerRentInventory(customer);*/
        FilmService filmService = new FilmService();
        filmService.productionNewFilm();
    }
}