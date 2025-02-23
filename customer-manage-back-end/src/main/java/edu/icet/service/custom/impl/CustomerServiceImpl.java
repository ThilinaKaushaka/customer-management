package edu.icet.service.custom.impl;

import edu.icet.dto.CustomerDto;
import edu.icet.entity.Customerentity;
import edu.icet.repository.custom.CustomerRepository;
import edu.icet.service.custom.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository repository;
    final ModelMapper mapper;

    @Override
    public boolean addCustomer(CustomerDto dto) {
        repository.save(mapper.map(dto, Customerentity.class));
        return true;
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) {
        repository.save(mapper.map(dto,Customerentity.class));
        return true;
    }

    @Override
    public boolean deletecustomer(Integer id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public CustomerDto viewCustomer(Integer id) {
        return mapper.map(repository.findById(id), CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAll() {
        List<CustomerDto> list=new ArrayList<>();
        repository.findAll().forEach(customerentity -> {
            list.add(mapper.map(customerentity, CustomerDto.class));
        });
        return list;
    }

    @Override
    public List<CustomerDto> searchByName(String name) {
        List<CustomerDto> list=new ArrayList<>();
        repository.findByName(name).forEach(customerentity -> {
            list.add(mapper.map(customerentity, CustomerDto.class));
        });
        return list;
    }

    @Override
    public List<CustomerDto> searchByAddress(String address) {
        List<CustomerDto> list=new ArrayList<>();
        repository.findByAddress(address).forEach(customerentity -> {
            list.add(mapper.map(customerentity, CustomerDto.class));
        });
        return list;
    }

    @Override
    public List<CustomerDto> searchBySalary(Double salary) {
        List<CustomerDto> list=new ArrayList<>();
        repository.findBySalary(salary).forEach(customerentity -> {
            list.add(mapper.map(customerentity, CustomerDto.class));
        });
        return list;
    }


}
