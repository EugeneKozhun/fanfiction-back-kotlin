package com.itransition.fanfictionbackend.model;

import com.itransition.fanfictionbackend.model.lookup.ReactionLookUp;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "reaction")
@EqualsAndHashCode(callSuper = true)
public class Reaction extends WithLongId {

    @ManyToOne(optional = false)
    @JoinColumn(name = "reaction_lut_id")
    private ReactionLookUp value;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fanfic_id")
    private Fanfic fanfic;
}
