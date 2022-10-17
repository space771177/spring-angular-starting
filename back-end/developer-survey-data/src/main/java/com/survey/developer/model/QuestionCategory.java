package com.survey.developer.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions_categories")
public class QuestionCategory extends BaseEntity{

    private String name;

    @Builder
    public QuestionCategory(Long id, String name) {
        super(id);
        this.name = name;
    }
}
