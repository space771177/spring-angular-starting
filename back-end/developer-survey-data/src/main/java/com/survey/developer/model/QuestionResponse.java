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
public class QuestionResponse extends BaseEntity {

    private String proposition;

    @Builder
    public QuestionResponse(Long id, String proposition) {
        super(id);
        this.proposition = proposition;
    }
}
