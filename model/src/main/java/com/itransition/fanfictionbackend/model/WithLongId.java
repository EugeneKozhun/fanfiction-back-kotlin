package com.itransition.fanfictionbackend.model;

import static javax.persistence.GenerationType.IDENTITY;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class WithLongId implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
}
