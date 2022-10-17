package com.survey.developer.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class QuestionResponseKey implements Serializable {

    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "response_id")
    private Long responseId;


}
