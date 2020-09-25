package com.wyf.ycu.mybatis.web;

import com.wyf.ycu.mybatis.mapper.CustomerMapper;
import com.wyf.ycu.mybatis.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerMapper customerMapper;

    @RequestMapping("/getCustomers")
    public List<Customer> getCustomers() {
        List<Customer> customers = this.customerMapper.getAll();
        return customers;
    }

    @RequestMapping("/getCustomer")
    public Customer getCustomer(Long id) {
        Customer customer = this.customerMapper.getOne(id);
        return customer;
    }

    @RequestMapping("/add")
    public void save(Customer customer) {
        this.customerMapper.insert(customer);
    }

    @RequestMapping("/update")
    public void update(Customer customer) {
        this.customerMapper.update(customer);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.customerMapper.delete(id);
    }
}
