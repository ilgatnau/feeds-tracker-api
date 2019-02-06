package com.gatnau.feedsapi.customer;

import com.gatnau.feedsapi.domain.Customer;
import com.gatnau.feedsapi.security.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

/**
 * Created by ilgat on 24/01/2019.
 */
@RestController
public class CustomerApi {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Customer getOne(@PathVariable String id){

        Customer customer = new Customer();
        try {
            customer = customerRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            // not found
        }
        return customer;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity< Customer > addOne(@RequestBody Customer customer){
        customerRepository.save(customer);
        Customer customerRtn = customerRepository.findById(customer.getId()).get();
        return ResponseEntity.ok(customerRtn);
    }
}
