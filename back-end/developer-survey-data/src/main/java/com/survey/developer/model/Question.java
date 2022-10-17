package com.survey.developer.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Question extends BaseEntity{

    private String subject;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private boolean isMultipleChoices;

    @ManyToMany
    @JoinTable(name = "questions_categories_join_table", joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<QuestionCategory> categories;

    @ManyToMany
    @JoinTable(name = "questions_responses_join_table", joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "response_id"))
    private Set<QuestionResponse> responses;

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
