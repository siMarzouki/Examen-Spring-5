package tn.esprit.RestControllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.DAO.Entities.*;
import tn.esprit.Services.IServices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class RestControllers {
    @Autowired
    IServices services;


    @PostMapping("/ajouterPersonnel")
    public Personnel ajouterPersonnel(@RequestBody Personnel p) {
        return services.ajouterPersonnel(p);
    }

    @PostMapping("/ajouterMuseeEtZones")
    public Musee ajouterMuseeEtZones(@RequestBody Musee m) {
        return services.ajouterMuseeEtZones(m);
    }

    @PostMapping("/ajouterOeuvreArtEtAffecterAZone")
    public void ajouterOeuvreArtEtAffecterAZone(@RequestBody Oeuvre o, @RequestParam long idZone) {
        services.ajouterOeuvreArtEtAffecterAZone(o,idZone);
    }

    @PutMapping("/affecterPersonnelAUneZone")
    public String affecterPersonnelAUneZone(@RequestParam long idPersonnel,@RequestParam long idZone) {
        return services.affecterPersonnelAUneZone(idPersonnel,idZone);
    }

    @GetMapping("/titreTableauParMuseeEtDirection")
    public List<String> titreTableauParMuseeEtDirection(@RequestParam Long idMusee,@RequestParam Direction d) {
        return services.titreTableauParMuseeEtDirection(idMusee,d);
    }
}
