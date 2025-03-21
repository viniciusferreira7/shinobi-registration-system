package dev.java10.ShinobiRegistrationSystem.Missions.Controller;

import dev.java10.ShinobiRegistrationSystem.Ninjas.Controller.NinjaModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_missions")
public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "ninja_id", nullable = false)
    private NinjaModel ninja;

    @Enumerated(EnumType.STRING)
    private MissionRank rank;

    public MissionModel(String name, String description, NinjaModel ninja, MissionRank rank) {
        this.name = name;
        this.description = description;
        this.ninja = ninja;
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

    public NinjaModel getNinja() {
        return ninja;
    }

    public MissionRank getRank() {
        return rank;
    }
}
