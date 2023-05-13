package tn.esprit.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Musee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idMusee;
    @Temporal(TemporalType.DATE)
    Date dateInauguration;
    String designation;
    String adresse;

    @OneToMany(mappedBy = "musee")
    List<Zone> zones;
}
