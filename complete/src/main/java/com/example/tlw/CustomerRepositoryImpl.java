package com.example.tlw;

import com.example.accessingdatajpa.Customer;
import com.example.accessingdatajpa.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public List<Customer> findByLastName(String lastName) {
        return null;
    }

    @Override
    public Customer findById(long id) {
        return null;
    }

    @Override
    public <S extends Customer> S save(S entity) {
        System.out.println("saving");
        return null;
    }

    @Override
    public <S extends Customer> Iterable<S> saveAll(Iterable<S> entities) {
        System.out.println("Saving all");
        return null;
    }

    public void foo() {
        System.out.println("foo");
    }

    @Override
    public Optional<Customer> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Customer> findAll() {
        return null;
    }

    @Override
    public Iterable<Customer> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Customer entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Customer> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
