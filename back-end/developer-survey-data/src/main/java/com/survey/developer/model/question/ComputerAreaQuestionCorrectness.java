package com.survey.developer.model.question;

import com.survey.developer.model.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "computer_area_questions_correctness")
public class ComputerAreaQuestionCorrectness extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "question_id")
    private ComputerAreaQuestion question;
    private boolean isCorrectAnswer;
    @OneToOne(mappedBy = "questionCorrectness")
    private ComputerAreaLabeledQuestionProposition proposition;

    @Builder
    public ComputerAreaQuestionCorrectness(Long id, ComputerAreaQuestion question, boolean isCorrectAnswer, ComputerAreaLabeledQuestionProposition proposition) {
        super(id);
        this.question = question;
        this.isCorrectAnswer = isCorrectAnswer;
        this.proposition = proposition;
    }
}
