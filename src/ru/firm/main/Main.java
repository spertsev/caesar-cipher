package ru.firm.main;

import ru.firm.main.service.Decoder;
import ru.firm.main.service.InteractRunner;
import ru.firm.main.repository.SourceData;

public class Main {

    public static void main(String[] args) {
        SourceData sourceData = new SourceData();
        InteractRunner interactRunner = new InteractRunner();
        Decoder decoder = new Decoder();

        interactRunner.interactWithUser(sourceData.getText());
        decoder.decryptText(sourceData.getText(), sourceData.getAlphabet());
    }

}
