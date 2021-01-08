package com.itransition.fanfictionbackend.model.lookup;

import com.itransition.fanfictionbackend.model.Reaction;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "reaction_lut")
public class ReactionLookUp implements Serializable {

    @Id
    private String name;

    @OneToMany(mappedBy = "value", orphanRemoval = true)
    private List<Reaction> reaction = new ArrayList<>();
}
