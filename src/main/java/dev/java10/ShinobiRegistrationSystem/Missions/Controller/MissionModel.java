package dev.java10.ShinobiRegistrationSystem.Missions.Controller;

import dev.java10.ShinobiRegistrationSystem.Ninjas.Controller.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missions")
public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany
    @JoinColumn(name = "ninja_id", nullable = false)
    private List<NinjaModel> ninjas;

    @Enumerated(EnumType.STRING)
    private MissionRank rank;

    public MissionModel(String name, String description, List<NinjaModel> ninjas, MissionRank rank) {
        this.name = name;
        this.description = description;
        this.ninjas = ninjas;
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<NinjaModel> getNinjas() {
        return ninjas;
    }

    public MissionRank getRank() {
        return rank;
    }
}
