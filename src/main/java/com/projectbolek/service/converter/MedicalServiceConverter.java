package com.projectbolek.service.converter;

import com.projectbolek.domain.entity.ServiceEntity;
import com.projectbolek.domain.model.dto.ServiceDTO;
import com.projectbolek.service.MedicalServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by rogalsp1 on 21.06.16.
 */
@Component
public class MedicalServiceConverter implements EntityDTOConverter<ServiceEntity, ServiceDTO>{

    @Autowired
    private MedicalServiceService service;

    @Override
    public ServiceEntity fromDTO(ServiceDTO serviceDTO) {
        ServiceEntity serviceEntity = new ServiceEntity();
        if(serviceEntity.getId() != null)
            serviceEntity =  service.findOne(serviceEntity.getId());
        serviceEntity.setDescription(serviceDTO.getDescription());
        serviceEntity.setPrice(serviceDTO.getPrice());
        serviceEntity.setServiceName(serviceDTO.getServiceName());
        return serviceEntity;
    }

    @Override
    public ServiceDTO fromEntity(ServiceEntity serviceEntity) {
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setId(serviceEntity.getId());
        serviceDTO.setDescription(serviceEntity.getDescription());
        serviceDTO.setPrice(serviceEntity.getPrice());
        serviceDTO.setServiceName(serviceEntity.getServiceName());
        return serviceDTO;
    }

}
