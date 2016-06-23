package com.projectbolek.service;

import com.projectbolek.domain.entity.ServiceEntity;
import com.projectbolek.domain.repository.ServiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Created by rogalsp1 on 21.06.16.
 */
@Service
@Slf4j
public class MedicalServiceService extends BaseService<ServiceEntity>{

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public CrudRepository<ServiceEntity, Long> getRepository() {
        return serviceRepository;
    }
}
