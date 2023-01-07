package com.survey.developer.model.question;

import com.survey.developer.model.BaseEntity;
import com.survey.developer.model.Difficulty;
import com.survey.developer.model.competition.Competition;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Question extends BaseEntity {

    @Column(name = "subject")
    private String subject;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty")
    private Difficulty difficulty;

    @ManyToMany
    @JoinTable(name = "questions_categories_join_table", joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "question")
    private Set<LabeledProposition> propositions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;


    @Builder
    public Question(Long id, String subject, Difficulty difficulty, Set<Category> categories,
                    Set<LabeledProposition> propositions, Competition competition) {
        super(id);
        this.subject = subject;
        this.difficulty = difficulty;
        this.categories = categories;
        this.propositions = propositions;
        this.competition = competition;
    }

    public void addCategory(Category category){
        this.categories.add(category);
        category.getQuestions().add(this);
    }

    public void removeCategory(Category category){
        this.categories.remove(category);
        category.getQuestions().remove(this);
    }
}
