package com.greenfox.exams.springretake.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by ${rudolfps} on 2017.01.23..
 */
@Data
@Entity
@Table(name="urlstore")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String urlinput;
    private String generatedKey;
}
