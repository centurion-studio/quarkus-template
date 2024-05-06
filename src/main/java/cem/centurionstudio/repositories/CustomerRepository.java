package cem.centurionstudio.repositories;

import cem.centurionstudio.entities.CustomerEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements PanacheRepositoryBase<CustomerEntity, Integer> {
}