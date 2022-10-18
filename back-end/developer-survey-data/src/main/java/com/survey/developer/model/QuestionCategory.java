package com.survey.developer.model;

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
@Table(name = "questions_categories")
public class QuestionCategory extends BaseEntity{

    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Question> questions;

    @Builder
    public QuestionCategory(Long id, String name) {
        super(id);
        this.name = name;
    }
}
