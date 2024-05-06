package cem.centurionstudio.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private Integer customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String email;
    private String phone;
}
