package ru.firm.main.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SimpleFileRepository {

    /**
     * Метод считывает тело файла .txt из папки src/ru/firm/main/resources/
     *
     * @param fileName имя файла
     * @return контент
     */
    public String readFileFromResources(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/ru/firm/main/resources/" + fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
