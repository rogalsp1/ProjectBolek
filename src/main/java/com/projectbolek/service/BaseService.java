package com.projectbolek.service;

import com.google.common.collect.Lists;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by rogalsp1 on 29.05.16.
 */
public abstract class BaseService<T> {

    public abstract CrudRepository<T, Long> getRepository();

    public T save(T t){
        return getRepository().save(t);
    }

    public List<T> findAll(){
        return Lists.newArrayList(getRepository().findAll());
    }

    public List<T> findAll(List<Long> idList){
        return Lists.newArrayList(getRepository().findAll(idList));
    }

    public T findOne(Long id){
        return getRepository().findOne(id);
    }

    public void delete (T t){
        getRepository().delete(t);
    }

    public void delete(Long id){
        getRepository().delete(id);
    }

    public void delete(List<T> tList){
        getRepository().delete(tList);
    }

    public Long count(){
        return getRepository().count();
    }


}
