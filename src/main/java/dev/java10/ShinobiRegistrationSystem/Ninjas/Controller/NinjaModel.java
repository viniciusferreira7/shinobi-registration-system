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

    @OneToMany
    private List<MissionModel> missions;

    public NinjaModel(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
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

    public List<MissionModel> getMissions() {
        return missions;
    }
}
