package Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckHandler {
    
    private List<StudyCard> cardList;

    public DeckHandler() {
        this.cardList = new ArrayList<>();
    }

    public StudyCard pullCard() {
        Random draw = new Random();
        int randomIndex = draw.nextInt(this.cardList.size());
        
        return this.cardList.get(randomIndex);
    }

    public void addToDeck(String question, String answer, String difficulty) {
        StudyCard card = new StudyCard(question, answer, difficulty);
        this.cardList.add(card);
    }

    public void shuffleDeck() {
        Collections.shuffle(this.cardList);
    }
}
