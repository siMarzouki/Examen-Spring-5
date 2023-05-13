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
public class Zone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idZone;
    String code;
    String libelle;
    @Enumerated(EnumType.STRING)
    Direction direction;
    Boolean actif;
    @JsonIgnore
    @ManyToOne
    Musee musee;

    @JsonIgnore
    @OneToMany
    List<Oeuvre> oeuvres;

    @JsonIgnore
    @OneToOne
    Personnel directeur;

    @JsonIgnore
    @OneToMany(mappedBy = "workAsGardien")
    List<Personnel> gardiens;


}
