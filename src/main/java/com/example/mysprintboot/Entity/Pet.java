package com.example.mysprintboot.Entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PET")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seqence")
    @SequenceGenerator(name = "pet_sequnce", sequenceName = "pet_seq_sequance", initialValue = 1,allocationSize = 1)

    private long id;

    private String name;

    private String type;

    private String breeds;

    private int birthYear;

}
