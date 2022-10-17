package com.survey.developer.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor(force = true)
@Table(name = "questions")
public class Question extends BaseEntity{

    private final String subject;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private final Difficulty difficulty;

    private final boolean isMultipleChoices;

    @ManyToMany
    private final Set<QuestionCategory> categories;

    @ManyToMany
    private final Set<QuestionResponse> responses;

    @Builder
    public Question(Long id, String subject, Difficulty difficulty, boolean isMultipleChoices,
                    Set<QuestionCategory> categories, Set<QuestionResponse> responses) {
        super(id);
        this.subject = subject;
        this.difficulty = difficulty;
        this.isMultipleChoices = isMultipleChoices;
        this.categories = categories;
        this.responses = responses;
    }
}
