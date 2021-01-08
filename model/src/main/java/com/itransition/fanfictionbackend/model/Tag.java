package com.itransition.fanfictionbackend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tag")
@EqualsAndHashCode(callSuper = true)
public class Tag extends WithLongId {

    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Fanfic> fanfics = new ArrayList<>();
}
