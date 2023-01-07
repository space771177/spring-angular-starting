package com.survey.developer.model.competition;

import com.survey.developer.model.BaseEntity;
import com.survey.developer.model.User.Player;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "player_competition_review")
public class PlayerCompetitionReview extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @OneToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @OneToMany(mappedBy = "playerCompetitionReview")
    private Set<PlayerAnswer> playerAnswers;

    @Builder
    public PlayerCompetitionReview(Long id, Player player, Competition competition, Set<PlayerAnswer> playerAnswers) {
        super(id);
        this.player = player;
        this.competition = competition;
        this.playerAnswers = playerAnswers;
    }
}
