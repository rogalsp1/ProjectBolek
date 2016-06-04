package com.projectbolek.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@Entity
@Table(name = "personel_inaccessibility", schema = "bolekshema")
@Data
public class PersonelInaccessibilityEntity extends BaseEntity implements Serializable{

    private static final long serialVersionUID = -7480321626699337972L;

    @Id @SequenceGenerator(name = "personel_inaccessibility_id_seq", sequenceName = "bolekshema.personel_inaccessibility_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personel_inaccessibility_id_seq")
    private Long id;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @ManyToOne
    @JoinColumn(name = "personel_id")
    private UserEntity personel;
}
