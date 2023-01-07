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
@Table(name = "labeled_propositions")
public class LabeledProposition extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    private String label;
    private String proposition;
    private boolean isCorrectAnswer;
    private Duration maximumTime;
    private int order;

    @Builder
    public LabeledProposition(Long id, Question question, String label, String proposition,
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
