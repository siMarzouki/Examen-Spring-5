package tn.esprit.Services;
import tn.esprit.DAO.Entities.*;

import java.util.List;

public interface IServices {
    Personnel ajouterPersonnel(Personnel p);
    Musee ajouterMuseeEtZones(Musee m);
    void ajouterOeuvreArtEtAffecterAZone(Oeuvre o, long idZone);
    String affecterPersonnelAUneZone(long idPersonnel, long idZone);
    List<String> titreTableauParMuseeEtDirection(Long idMusee, Direction d);
}
