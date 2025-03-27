package dev.java10.ShinobiRegistrationSystem.Missions;

import dev.java10.ShinobiRegistrationSystem.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tb_missions")
@AllArgsConstructor
@Data
public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "mission")
    @JoinColumn(name = "ninja_id", nullable = false)
    private List<NinjaModel> ninjas;

    @Enumerated(EnumType.STRING)
    private MissionRank rank;
}
