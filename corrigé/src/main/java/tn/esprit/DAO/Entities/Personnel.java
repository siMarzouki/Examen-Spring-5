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
public class Personnel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idPersonnel;
    String nomPersonnel;
    String prenomPersonnel;
    @Temporal(TemporalType.DATE)
    Date dateDerniereAffectation;
    @Enumerated(EnumType.STRING)
    TypePersonnel typePersonnel;

    @JsonIgnore
    @OneToOne
    Zone workAsDireteur;

    @JsonIgnore
    @ManyToOne()
    Zone workAsGardien;

}
