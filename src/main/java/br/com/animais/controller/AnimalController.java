package br.com.animais.controller;

import br.com.animais.handler.AnimalNotFoundException;
import br.com.animais.model.Animal;
import br.com.animais.repository.AnimaisRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final AnimaisRepository repository;

    public AnimalController(AnimaisRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    List<Animal> all() {
        return repository.findAll();
    }

    @PostMapping()
    Animal newAnimal(@RequestBody Animal newAnimal) {
        return repository.save(newAnimal);
    }

    @GetMapping("/{id}")
    Animal one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new AnimalNotFoundException(id));
    }

    @PutMapping("/{id}")
    Animal replaceAnimal(@RequestBody Animal newAnimal, @PathVariable Long id) {

        return repository.findById(id)
                .map(animais -> {
                    animais.setNome(newAnimal.getNome());
                    animais.setEspecie(newAnimal.getEspecie());
                    animais.setPeso(newAnimal.getPeso());
                    return repository.save(animais);
                })
                .orElseGet(() -> {
                    newAnimal.setId(id);
                    return repository.save(newAnimal);
                });
    }

    @DeleteMapping("/{id}")
    void deleteAnimal(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
