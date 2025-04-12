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
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "mission")
    @Column
    private List<NinjaModel> ninjas;

    @Enumerated(EnumType.STRING)
    @Column
    private MissionRank rank;
}
