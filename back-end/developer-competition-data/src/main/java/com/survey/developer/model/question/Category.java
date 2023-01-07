package com.survey.developer.model.question;

import com.survey.developer.model.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Question> questions;

    @Builder
    public Category(Long id, String name) {
        super(id);
        this.name = name;
    }
}
