package com.example.bus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "buses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "bus_name")
    private String name;
}
