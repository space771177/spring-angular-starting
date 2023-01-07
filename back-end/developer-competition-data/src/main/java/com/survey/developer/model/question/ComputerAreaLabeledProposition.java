package com.survey.developer.model.question;

import com.survey.developer.model.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "computer_area_labeled_propositions")
public class ComputerAreaLabeledProposition extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "question_id")
    private ComputerAreaQuestion question;
    private String label;
    private String proposition;
    private boolean isCorrectAnswer;
    private Duration maximumTime;
    private int order;

    @Builder
    public ComputerAreaLabeledProposition(Long id, ComputerAreaQuestion question, String label, String proposition,
                                          boolean isCorrectAnswer, Duration maximumTime, int order) {
        super(id);
        this.question = question;
        this.label = label;
        this.proposition = proposition;
        this.isCorrectAnswer = isCorrectAnswer;
        this.maximumTime = maximumTime;
        this.order = order;
    }
}
