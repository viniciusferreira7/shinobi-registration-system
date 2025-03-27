package dev.java10.ShinobiRegistrationSystem.Ninjas;

import dev.java10.ShinobiRegistrationSystem.Missions.MissionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "tb_register")
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;

    private int age;

    @Enumerated(EnumType.STRING)
    private NinjaRank rank;

    @ManyToOne()
    @JoinColumn(name = "mission_id", nullable = false)
    private MissionModel mission;

}
