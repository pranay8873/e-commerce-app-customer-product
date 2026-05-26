package com.java.ecommerce.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode

public class Customer {
    private String name;
    private String gender;
    private int id;
    private int age;
    private String email;
    private String password;
    private long phoneno;

}
