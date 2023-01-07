package com.survey.developer.model.User;

import com.survey.developer.model.competition.ComputerAreaCompetition;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "players")
public class Player extends User {
    @ManyToMany(mappedBy = "players")
    private Set<ComputerAreaCompetition> competitions;

    @Builder
    public Player(Long id, String username, Set<ComputerAreaCompetition> competitions) {
        super(id, username);
        this.competitions = competitions;
    }
}
