package com.projectbolek.domain.entity;

/**
 * Created by rogalsp1 on 03.06.16.
 */
public abstract  class BaseEntity {

    private Long id;

    public boolean isNew(){
        return id == null;
    }
}
