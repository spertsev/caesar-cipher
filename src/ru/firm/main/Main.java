package ru.firm.main;

import ru.firm.main.repository.SimpleFileRepository;
import ru.firm.main.service.Decoder;
import ru.firm.main.service.InteractRunner;

public class Main {

    public static void main(String[] args) {

        SimpleFileRepository simpleFileRepository = new SimpleFileRepository();
        InteractRunner interactRunner = new InteractRunner();
        Decoder decoder = new Decoder();

        interactRunner.interactWithUser(simpleFileRepository.readFileFromResources("encrypted_text.txt"));
        decoder.decryptText(simpleFileRepository.readFileFromResources("encrypted_text.txt"), simpleFileRepository.readFileFromResources("alphabet.txt"));

    }

}
