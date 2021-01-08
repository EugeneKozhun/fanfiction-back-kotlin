package com.itransition.fanfictionbackend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "fanfic_chapter")
@EqualsAndHashCode(callSuper = true)
public class FanficChapter extends WithLongId {

    private String title;

    @Lob
    private String content;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fanfic_id")
    private Fanfic fanfic;
}
