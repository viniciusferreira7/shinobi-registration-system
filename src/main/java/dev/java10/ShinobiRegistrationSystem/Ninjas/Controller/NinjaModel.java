package dev.java10.ShinobiRegistrationSystem.Ninjas.Controller;

import dev.java10.ShinobiRegistrationSystem.Missions.Controller.MissionModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_register")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int age;

    @Enumerated(EnumType.STRING)
    private NinjaRank rank;

    @ManyToOne()
    @JoinColumn(name = "mission_id", nullable = false)
    private MissionModel mission;

    public NinjaModel(String name, String email, int age, NinjaRank rank) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.rank = rank;
    }

    public NinjaModel(String name, String email, int age, NinjaRank rank, MissionModel mission) {
        this(name, email, age, rank);
        this.mission = mission;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public NinjaRank getRank() {
        return rank;
    }

    public MissionModel getMission() {
        return mission;
    }
}
