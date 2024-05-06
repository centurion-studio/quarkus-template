package cem.centurionstudio.services.mappers;

import cem.centurionstudio.domain.Customer;
import cem.centurionstudio.entities.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface CustomerMapper {

    CustomerEntity toEntity(Customer domain);

    Customer toDomain(CustomerEntity entity);

}