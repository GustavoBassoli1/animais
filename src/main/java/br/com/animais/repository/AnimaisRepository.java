package br.com.animais.repository;

import br.com.animais.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimaisRepository extends JpaRepository<Animal,Long> {
}
