package edu.wctc.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Legend")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Legend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "legendId")
    private int id;
    @Column(name = "legendName")
    private String name;
    @Column(name = "legendDescription")
    private String description;

    public Legend(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Legend{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
