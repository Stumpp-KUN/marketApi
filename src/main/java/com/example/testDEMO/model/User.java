package com.example.testDEMO.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3,message = "username should be longer than 3 letter")
    private String username;
    @NotNull(message = "password should not be null")
    private String password;
    private String email;
    private String phone;
    private Double amount;
    private Boolean isOrganization;
    private Boolean isFrozen;
    @OneToOne(mappedBy = "user")
    private Organization organization;
    @OneToMany(mappedBy = "user")
    private List<Purchase> purchases;
    @OneToMany(mappedBy = "user")
    private List<Rating> ratings;
    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;
}
