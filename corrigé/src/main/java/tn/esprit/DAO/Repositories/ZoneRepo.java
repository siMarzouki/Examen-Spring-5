package tn.esprit.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.DAO.Entities.Zone;

public interface ZoneRepo extends JpaRepository<Zone,Long> {
}
