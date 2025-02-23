package edu.icet.controller;

import edu.icet.dto.CustomerDto;
import edu.icet.service.custom.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {


    final CustomerService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    void addCustomer(@RequestBody CustomerDto customerDto){
        service.addCustomer(customerDto);
    }

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    List<CustomerDto> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteCustomer(@PathVariable Integer id){
        service.deletecustomer(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updateCustomer(@RequestBody CustomerDto customerDto){
        service.updateCustomer(customerDto);
    }


    @GetMapping("/search-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    CustomerDto searchCustomerById(@PathVariable Integer id){
        return service.viewCustomer(id);
    }

    @GetMapping("search-by-name/{name}")
    @ResponseStatus(HttpStatus.OK)
    List<CustomerDto> searchCustomerByName(@PathVariable String name){
        return service.searchByName(name);
    }

    @GetMapping("search-by-address/{address}")
    @ResponseStatus(HttpStatus.OK)
    List<CustomerDto> searchCustomerByAddress(@PathVariable String address){
        return service.searchByAddress(address);
    }

    @GetMapping("search-by-salary/{salary}")
    @ResponseStatus(HttpStatus.OK)
    List<CustomerDto> searchCustomerBySalary(@PathVariable Double salary){
        return  service.searchBySalary(salary);
    }

}
