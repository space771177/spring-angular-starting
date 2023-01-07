package com.survey.developer.model.competition;

import com.survey.developer.model.BaseEntity;
import com.survey.developer.model.User.Player;
import com.survey.developer.model.question.LabeledProposition;
import com.survey.developer.model.question.Question;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "player_answer")
public class PlayerAnswer extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToMany
    @JoinColumn(name = "player_answer_id")
    private Set<LabeledProposition> answers;

    @ManyToOne
    @JoinColumn(name = "player_competition_review_id")
    private PlayerCompetitionReview playerCompetitionReview;

    @Builder
    public PlayerAnswer(Long id, Question question, Set<LabeledProposition> answers, PlayerCompetitionReview playerCompetitionReview) {
        super(id);
        this.question = question;
        this.answers = answers;
        this.playerCompetitionReview = playerCompetitionReview;
    }
}
