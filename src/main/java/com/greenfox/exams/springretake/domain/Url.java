package com.greenfox.exams.springretake.domain;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by ${rudolfps} on 2017.01.23..
 */
@Entity
@Table(name="urlstore")
@Data
public class ShortenUrl {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @NotNull
        private String url;
        private String generated;

    }


