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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
