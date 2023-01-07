package com.survey.developer.model.question;

import com.survey.developer.model.BaseEntity;
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
@Table(name = "computer_area_categories")
public class ComputerAreaCategory extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<ComputerAreaQuestion> questions;

    @Builder
    public ComputerAreaCategory(Long id, String name) {
        super(id);
        this.name = name;
    }
}
