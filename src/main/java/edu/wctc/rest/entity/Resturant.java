package edu.wctc.rest.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="resturant")
public class Resturant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ResturantId")
    private int id;
    @Column(name ="ResturantName")
    private String resturantName;
    @Column(name ="Rating1")
    private int rating1;
    @Column(name ="Rating2")
    private int rating2;
    @Column(name ="Rating3")
    private int rating3;
    @Column(name ="lastVisit")
    private Date lastVisit;
}
