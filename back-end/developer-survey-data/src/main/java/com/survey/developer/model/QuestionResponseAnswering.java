package com.survey.developer.model;

import javax.persistence.*;

@Entity
public class QuestionResponseAnswering {

    @EmbeddedId
    private QuestionResponseKey id;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @MapsId("responseId")
    @JoinColumn(name = "response_id")
    private QuestionResponse response;

    private boolean isCorrectAnswer;

}
