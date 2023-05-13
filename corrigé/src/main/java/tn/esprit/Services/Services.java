package tn.esprit.Services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.DAO.Entities.*;
import tn.esprit.DAO.Repositories.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class Services implements IServices {
    ZoneRepo zoneRepo;
    OeuvreRepo oeuvreRepo;
    MuseeRepo museeRepo;
    PersonnelRepo personnelRepo;

    @Override
    public Personnel ajouterPersonnel(Personnel p) {
        return personnelRepo.save(p);
    }

    @Override
    public Musee ajouterMuseeEtZones(Musee m) {
         museeRepo.save(m);
        m.getZones().stream().forEach(zone ->{
            zone.setMusee(m);
            zoneRepo.save(zone);
        });
        return m;
    }

    @Override
    public void ajouterOeuvreArtEtAffecterAZone(Oeuvre o, long idZone) {
        oeuvreRepo.save(o);
        Zone z = zoneRepo.findById(idZone).get();
        z.getOeuvres().add(o);
        zoneRepo.save(z);
    }

    @Override
    public String affecterPersonnelAUneZone(long idPersonnel, long idZone) {
        Personnel p=personnelRepo.findById(idPersonnel).get();
        Zone z = zoneRepo.findById(idZone).get();
        if (p.getTypePersonnel().equals(TypePersonnel.DIRECTEUR)){
            if (z.getDirecteur()==null){
                z.setDirecteur(p);
                p.setWorkAsDireteur(z);
                p.setDateDerniereAffectation(new Date());
                zoneRepo.save(z);
                personnelRepo.save(p);
                return " L'affectation du directeur est effectuée avec succès ";
            }else{
                return "« Il y a déjà un directeur";
            }
        }else{
            int min = Math.round(z.getOeuvres().size());
            if(z.getGardiens().size()<min){
                z.getGardiens().add(p);
                p.setWorkAsGardien(z);
                p.setDateDerniereAffectation(new Date());
                zoneRepo.save(z);
                personnelRepo.save(p);
                return "L'affectation du gardien est effectuée avec succès ";
            }else{
                return "« La zone contient assez de gardiens";
            }
        }

    }

    @Override
    public List<String> titreTableauParMuseeEtDirection(Long idMusee, Direction d) {
        Musee m = museeRepo.findById(idMusee).get();
        List<String> res=new ArrayList<>();
        for (Zone zone : m.getZones()) {
            if(zone.getDirection().equals(d)){
                for (Oeuvre oeuvre:zone.getOeuvres()){
                    res.add(oeuvre.getTitreTabkeau());
                }
            }
        }
        return res;
    }
}
