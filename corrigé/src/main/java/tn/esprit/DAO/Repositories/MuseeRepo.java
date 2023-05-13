package tn.esprit.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.DAO.Entities.Musee;

public interface MuseeRepo extends JpaRepository<Musee,Long> {
}
