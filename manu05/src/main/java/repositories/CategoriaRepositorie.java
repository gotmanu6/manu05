package repositories;

import models.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorie extends JpaRepository<CategoriaModel, Long> {
}