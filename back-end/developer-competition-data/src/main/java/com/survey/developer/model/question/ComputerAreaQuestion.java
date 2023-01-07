package com.survey.developer.model.question;

import com.survey.developer.model.BaseEntity;
import com.survey.developer.model.Difficulty;
import com.survey.developer.model.competition.ComputerAreaCompetition;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "computer_area_questions")
public class ComputerAreaQuestion extends BaseEntity {

    @Column(name = "subject")
    private String subject;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty")
    private Difficulty difficulty;

    @ManyToMany
    @JoinTable(name = "computer_area_questions_categories_join_table", joinColumns = @JoinColumn(name = "computer_area_question_id"),
            inverseJoinColumns = @JoinColumn(name = "computer_area_category_id"))
    private Set<ComputerAreaCategory> categories = new HashSet<>();

    @OneToMany(mappedBy = "question")
    private Set<ComputerAreaLabeledProposition> propositions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "competition_id")
    private ComputerAreaCompetition competition;


    @Builder
    public ComputerAreaQuestion(Long id, String subject, Difficulty difficulty, Set<ComputerAreaCategory> categories,
                                Set<ComputerAreaLabeledProposition> propositions, ComputerAreaCompetition competition) {
        super(id);
        this.subject = subject;
        this.difficulty = difficulty;
        this.categories = categories;
        this.propositions = propositions;
        this.competition = competition;
    }

    public void addCategory(ComputerAreaCategory category){
        this.categories.add(category);
        category.getQuestions().add(this);
    }

    public void removeCategory(ComputerAreaCategory category){
        this.categories.remove(category);
        category.getQuestions().remove(this);
    }
}
