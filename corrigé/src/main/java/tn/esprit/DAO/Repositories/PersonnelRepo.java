package tn.esprit.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.DAO.Entities.Personnel;

public interface PersonnelRepo extends JpaRepository<Personnel,Long> {
}
