package com.gatnau.feedsapi.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * Created by ilgat on 05/01/2019.
 */
@Getter
@Setter
public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;
    public String credentials;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}
