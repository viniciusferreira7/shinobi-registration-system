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

    public MissionModel(NinjaModel ninja, String description, String name) {
        this.ninja = ninja;
        this.description = description;
        this.name = name;
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
}
