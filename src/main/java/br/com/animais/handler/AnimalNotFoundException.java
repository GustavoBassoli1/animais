package br.com.animais.handler;

public class AnimalNotFoundException extends RuntimeException {

    public AnimalNotFoundException(Long id) {
        super("Animal não encontrado " + id);
    }
}
