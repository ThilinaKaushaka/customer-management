package edu.icet.service.custom;

import edu.icet.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    boolean addCustomer(CustomerDto dto);
    boolean updateCustomer(CustomerDto dto);
    boolean deletecustomer(Integer id);
    CustomerDto viewCustomer(Integer id);
    List<CustomerDto> getAll();

    List<CustomerDto> searchByName(String name);

    List<CustomerDto> searchByAddress(String address);
    List<CustomerDto> searchBySalary(Double salary);
}
