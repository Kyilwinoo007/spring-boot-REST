package com.symbolic.mm.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.NoArgsConstructor;


import java.util.Date;


@Entity
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Size(min = 2,message = "Name should have at least 2 characters")
    String name;

    @Past
    Date dateOfBirth;

    public void setId(int id) {
        this.id = id;
    }
}
