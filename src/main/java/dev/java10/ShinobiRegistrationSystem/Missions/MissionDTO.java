package dev.java10.ShinobiRegistrationSystem.Missions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10.ShinobiRegistrationSystem.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MissionDTO {
    private Long id;
    private String name;
    private String description;
    private List<NinjaModel> ninjas;
    private MissionRank rank;
}
