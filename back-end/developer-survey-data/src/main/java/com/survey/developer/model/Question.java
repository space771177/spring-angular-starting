package com.survey.developer.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Question extends BaseEntity{

    @Column(name = "subject")
    private String subject;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty")
    private Difficulty difficulty;

    @ManyToMany
    @JoinTable(name = "questions_categories_join_table", joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<QuestionCategory> categories = new HashSet<>();


    @ElementCollection
    @CollectionTable(name = "propositions_validation_mapping",
            joinColumns = {@JoinColumn(name = "question_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "proposition")
    @Column(name= "proposition_validate")
    private Map<String, Boolean> propositions = new HashMap<>();


    @Builder
    public Question(Long id, String subject, Difficulty difficulty, Set<QuestionCategory> categories, Map<String, Boolean> propositions) {
        super(id);
        this.subject = subject;
        this.difficulty = difficulty;
        this.categories = categories;
        this.propositions = propositions;
    }


    public void addCategory(QuestionCategory category){
        this.categories.add(category);
        category.getQuestions().add(this);
    }

    public void removeCategory(QuestionCategory category){
        this.categories.remove(category);
        category.getQuestions().remove(this);
    }
}
