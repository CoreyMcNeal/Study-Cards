package Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckHandler {
    
    private List<StudyCard> allCardList = new ArrayList<>();
    private List<StudyCard> easyCardList = new ArrayList<>();
    private List<StudyCard> modCardList = new ArrayList<>();
    private List<StudyCard> hardCardList = new ArrayList<>();

    public void addToDeck(String question, String answer, String difficulty) {      // Creates StudyCard and decides which deck to place the object into.
        StudyCard card = new StudyCard(question, answer, difficulty);
        allCardList.add(card);

        if (difficulty.equals("Easy")) {
            easyCardList.add(card);
        } else if (difficulty.equals("Moderate")) {
            modCardList.add(card);
        } else if (difficulty.equals("Hard")) {
            hardCardList.add(card);
        }
    }

    public void shuffleDecks() {                                                // Shuffles all decks of StudyCards
        Collections.shuffle(allCardList);
        Collections.shuffle(easyCardList);
        Collections.shuffle(modCardList);
        Collections.shuffle(hardCardList);
    }

    public void clearLists() {                                                  // Clears all decks of StudyCards
        allCardList.clear();
        easyCardList.clear();
        modCardList.clear();
        hardCardList.clear();
    }

    public List<StudyCard> getAllCardList() {
        return this.allCardList;
    }

    public void setAllCardList(List<StudyCard> allCardList) {
        this.allCardList = allCardList;
    }

    public List<StudyCard> getEasyCardList() {
        return this.easyCardList;
    }

    public void setEasyCardList(List<StudyCard> easyCardList) {
        this.easyCardList = easyCardList;
    }

    public List<StudyCard> getModCardList() {
        return this.modCardList;
    }

    public void setModCardList(List<StudyCard> modCardList) {
        this.modCardList = modCardList;
    }

    public List<StudyCard> getHardCardList() {
        return this.hardCardList;
    }

    public void setHardCardList(List<StudyCard> hardCardList) {
        this.hardCardList = hardCardList;
    }
    
}
