package com.survey.developer.model.competition;

import com.survey.developer.model.BaseEntity;
import com.survey.developer.model.Difficulty;
import com.survey.developer.model.User.Player;
import com.survey.developer.model.User.Publisher;
import com.survey.developer.model.question.Question;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "competitions")
public class Competition extends BaseEntity {
    private String name;
    private int maximumNumberOfPlayers;
    private int numberOfQuestions;
    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty")
    private Difficulty difficulty;

    @ManyToMany
    @JoinTable(name = "competitions_players_join_table", joinColumns = @JoinColumn(name = "competition_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private Set<Player> players;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    private LocalDate startingAt;

    private LocalDate endingAt;

    @OneToMany(mappedBy = "competition")
    private Set<Question> questions;

    @Builder
    public Competition(Long id, String name, int maximumNumberOfPlayers, int numberOfQuestions, Difficulty difficulty,
                       Set<Player> players, Publisher publisher, LocalDate startingAt, LocalDate endingAt, Set<Question> questions) {
        super(id);
        this.name = name;
        this.maximumNumberOfPlayers = maximumNumberOfPlayers;
        this.numberOfQuestions = numberOfQuestions;
        this.difficulty = difficulty;
        this.players = players;
        this.publisher = publisher;
        this.startingAt = startingAt;
        this.endingAt = endingAt;
        this.questions = questions;
    }

    public void addPlayer(Player player){
        this.players.add(player);
        player.getCompetitions().add(this);
    }

    public void removePlayer(Player player){
        this.players.remove(player);
        player.getCompetitions().remove(this);
    }

}
