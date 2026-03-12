package demo6;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sortcards {
    public static void sort(List<card> cards) {
        Collections.sort(cards, new Comparator<card>() {
            @Override
            public int compare(card o1, card o2) {
                return o2.getSizeValue() - o1.getSizeValue();
            }
        });
    }
}
