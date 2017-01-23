package com.greenfox.exams.springretake.repository;

import com.greenfox.exams.springretake.domain.Url;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ${rudolfps} on 2017.01.23..
 */


public interface UrlRepository extends CrudRepository<Url, Long>{
    public Url findByGeneratedKey(String generatedKey);
    public Url findByUrlinput(String urlinput);
}
