package com.havriush.service;

import com.havriush.MySessionFactory;
import com.havriush.dao.*;
import com.havriush.model.*;
import lombok.Data;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CustomerService {
    CustomerDAO customerDAO;
    StoreDAO storeDAO;
    CityDAO cityDAO;
    AddressDAO addressDAO;

    RentalDAO rentalDAO;

    FilmDAO filmDAO;

    InventoryDAO inventoryDAO;

    PaymentDAO paymentDAO;

    public CustomerService() {
        this.customerDAO = new CustomerDAO(MySessionFactory.getSessionFactory());
        this.storeDAO = new StoreDAO(MySessionFactory.getSessionFactory());
        this.cityDAO = new CityDAO(MySessionFactory.getSessionFactory());
        this.addressDAO = new AddressDAO(MySessionFactory.getSessionFactory());

        this.rentalDAO = new RentalDAO(MySessionFactory.getSessionFactory());

        this.filmDAO = new FilmDAO(MySessionFactory.getSessionFactory());

        this.inventoryDAO = new InventoryDAO(MySessionFactory.getSessionFactory());

        this.paymentDAO = new PaymentDAO(MySessionFactory.getSessionFactory());

    }

    public Customer createCustomer() {
        try (Session session = MySessionFactory.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            Store store = storeDAO.getItems(0, 1).get(0);
            City city = cityDAO.getByName("Akron");

            Address address = new Address();
            address.setAddress("Independency 50");
            address.setDistrict("Capital");
            address.setCity(city);
            address.setPhone("0123456789");
            addressDAO.save(address);

            Customer customer = new Customer();
            customer.setStore(store);
            customer.setFirstName("Oleksandr");
            customer.setLastName("Vorona");
            customer.setEmail("test@gmail.com");
            customer.setAddress(address);
            customer.setActive(true);
            customerDAO.save(customer);

            session.getTransaction().commit();
            return customer;
        }

    }

    public void customerReturnInventoryToStore() {
        try (Session session = MySessionFactory.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            Rental rental = rentalDAO.getAnyUnreturnedRental();
            rental.setReturnDate(LocalDateTime.now());
            rentalDAO.save(rental);
            session.getTransaction().commit();
        }
    }

    public void customerRentInventory(Customer customer) {
        try (Session session = MySessionFactory.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Film film = filmDAO.getFirstAvailableFilmForRent();
            Store store = storeDAO.getItems(0, 1).get(0);

            Inventory inventory = new Inventory();
            inventory.setStore(store);
            inventory.setFilm(film);
            inventoryDAO.save(inventory);

            Staff staff = store.getStaff();

            Rental rental = new Rental();
            rental.setRentalDate(LocalDateTime.now());
            rental.setInventory(inventory);
            rental.setCustomer(customer);
            rental.setStaff(staff);
            rentalDAO.save(rental);

            Payment payment = new Payment();
            payment.setCustomer(customer);
            payment.setStaff(staff);
            payment.setRental(rental);
            payment.setAmount(BigDecimal.valueOf(500.25));
            payment.setPaymentDate(LocalDateTime.now());
            paymentDAO.save(payment);

            session.getTransaction().commit();
        }
    }
}
