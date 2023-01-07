package com.survey.developer.model.User;

import com.survey.developer.model.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String username;


    public User(Long id, String username) {
        super(id);
        this.username = username;
    }
}
