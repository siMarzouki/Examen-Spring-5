package tn.esprit.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.DAO.Entities.Oeuvre;

public interface OeuvreRepo extends JpaRepository<Oeuvre,Long> {
}
