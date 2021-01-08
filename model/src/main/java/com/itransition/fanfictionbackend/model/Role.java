package com.itransition.fanfictionbackend.model;

import static javax.persistence.EnumType.STRING;
import com.itransition.fanfictionbackend.model.enums.ERole;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "role")
@EqualsAndHashCode(callSuper = true)
public class Role extends WithLongId {

    @Enumerated(STRING)
    private ERole name;
    private Boolean signUpRole;
}
