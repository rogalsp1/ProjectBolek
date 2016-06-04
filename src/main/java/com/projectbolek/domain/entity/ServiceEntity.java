package com.projectbolek.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@Entity
@Table(name = "service", schema = "bolekshema")
@Data
public class ServiceEntity extends BaseEntity implements Serializable{

    private static final long serialVersionUID = -6340154717370017125L;

    @Id @SequenceGenerator(name = "service_id_seq", sequenceName = "service_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_id_seq")
    private Long id;

    @Column(name = "service_name")
    private String serviceName;

    private String description;

    private Double price;

}
