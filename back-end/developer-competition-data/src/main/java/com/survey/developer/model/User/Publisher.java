package com.survey.developer.model.User;

import com.survey.developer.model.competition.ComputerAreaCompetition;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "publishers")
public class Publisher extends User {

    @OneToMany(mappedBy = "publisher")
    private Set<ComputerAreaCompetition> competitions;

    @Builder
    public Publisher(Long id, String username, Set<ComputerAreaCompetition> competitions) {
        super(id, username);
        this.competitions = competitions;
    }
}
