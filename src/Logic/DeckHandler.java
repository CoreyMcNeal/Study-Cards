package Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckHandler {
    
    private List<StudyCard> allCardList;
    

    public DeckHandler() {
        this.allCardList = new ArrayList<>();
    }

    public StudyCard pullCard() {
        Random draw = new Random();
        int randomIndex = draw.nextInt(this.allCardList.size());
        
        return this.allCardList.get(randomIndex);
    }

    public void addToDeck(String question, String answer, String difficulty) {
        StudyCard card = new StudyCard(question, answer, difficulty);
        this.allCardList.add(card);
    }

    public void shuffleDeck() {
        Collections.shuffle(this.allCardList);
    }
}
