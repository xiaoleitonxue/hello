package demo6;

import java.util.*;

public class room {

    private List<card> cards = new ArrayList<>();

    {
        String [] sizes = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String [] colors = {"♥", "♠", "♣", "♦"};
        int count = 0;
        for (String size : sizes) {
            count++;
            for (String color : colors) {
                cards.add(new card(size, color, count));
            }
        }
        //cards.add(new card("JOKER", "大王"));
        //cards.add(new card("JOKER", "小王"));
        Collections.addAll(cards, new card("JOKER", "大王", ++count), new card("JOKER", "小王", ++count));
        System.out.println( cards);
    }
    public void start() {
        Collections.shuffle(cards);
        System.out.println("洗牌后" + cards);

        Map<String, List<card>> players = new HashMap<>();
        List<card> player1 = new ArrayList<>();
        players.put("p1", player1);
        List<card> player2 = new ArrayList<>();
        players.put("p2", player2);
        List<card> player3 = new ArrayList<>();
        players.put("p3", player3);

        for (int i = 0; i < cards.size() - 3; i++) {
            card c = cards.get(i);
            if (i % 3 == 0) {
                player1.add(c);
            } else if (i % 3 == 1) {
                player2.add(c);
            } else {
                player3.add(c);
            }
        }

        sortcards.sort(player1);
        sortcards.sort(player2);
        sortcards.sort(player3);

        List<card> last = cards.subList(cards.size() - 3, cards.size());
        System.out.println("底牌" + last);

        for (Map.Entry<String, List<card>> entry : players.entrySet()){
            String key = entry.getKey();
            List<card> value = entry.getValue();
            System.out.println(key + ":" + value);
        }


    }
}
