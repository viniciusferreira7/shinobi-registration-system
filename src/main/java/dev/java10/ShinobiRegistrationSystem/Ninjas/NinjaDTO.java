package dev.java10.ShinobiRegistrationSystem.Ninjas;

import dev.java10.ShinobiRegistrationSystem.Missions.MissionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {
    private Long id;
    private String name;
    private String email;
    private int age;
    private NinjaRank rank;
    private MissionModel mission;
}
