package dev.java10.ShinobiRegistrationSystem.Ninjas;

import dev.java10.ShinobiRegistrationSystem.Missions.MissionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "tb_ninjas")
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private int age;

    @Enumerated(EnumType.STRING)
    @Column
    private NinjaRank rank;

    @ManyToOne()
    @JoinColumn(name = "mission_id", nullable = false)
    private MissionModel mission;

}
