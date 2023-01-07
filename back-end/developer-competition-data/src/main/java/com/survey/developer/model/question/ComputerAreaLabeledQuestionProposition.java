package com.survey.developer.model.question;

import com.survey.developer.model.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "computer_area_labeled_question_propositions")
public class ComputerAreaLabeledQuestionProposition extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "question_correctness_id")
    private ComputerAreaQuestionCorrectness questionCorrectness;
    private String label;
    private String proposition;

    @Builder
    public ComputerAreaLabeledQuestionProposition(Long id, ComputerAreaQuestionCorrectness questionCorrectness, String label, String proposition) {
        super(id);
        this.questionCorrectness = questionCorrectness;
        this.label = label;
        this.proposition = proposition;
    }
}
