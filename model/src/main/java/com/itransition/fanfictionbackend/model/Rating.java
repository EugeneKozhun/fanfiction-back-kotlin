package com.itransition.fanfictionbackend.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "rating")
@EqualsAndHashCode(callSuper = true)
public class Rating extends WithLongId {

    private Float value;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fanfic_id")
    private Fanfic fanfic;
}
