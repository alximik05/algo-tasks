package org.example.old;

import java.util.HashMap;
import java.util.Map;

public class TournamentWinners {

    public static void main(String[] args) {

        System.out.println(getWinners(new String[][]{
                        {"HTML", "C#"},
                        {"Java", "C++"},
                        {"Python", "C#"},
                        {"C++", "C#"}},

                new int[]{
                        1,
                        0,
                        0,
                        1}
        ));

    }

//    [["HTML", "C#"],
//    ["Java", "C++"],
//    ["Python", "C#"],
//    ["C++", "C#"]]
//    [0,1,1,0]

    public static String getWinners(String[][] competitions, int[] result) {
        Map<String, Integer> resultMap = new HashMap<>();
        String winnerTeam = competitions[0][0];
        Integer highScore = result[0];
        for (int i = 0; i < competitions.length; i++) {
            String[] competition = competitions[i];
            int matchResult = result[i];
            if (matchResult == 1) {
                if (resultMap.containsKey(competition[0])) {
                    resultMap.put(competition[0], resultMap.get(competition[0]) + 3);
                } else {
                    resultMap.put(competition[0], 3);
                }

            } else {
                if (resultMap.containsKey(competition[0])) {
                    resultMap.put(competition[1], resultMap.get(competition[1]) + 3);
                } else {
                    resultMap.put(competition[1], 3);
                }
            }
        }

        String winner = null;
        for (Map.Entry<String, Integer> stringIntegerEntry : resultMap.entrySet()) {
            if (winner == null) {
                winner = stringIntegerEntry.getKey();
            } else {
                if (stringIntegerEntry.getValue() > resultMap.get(winner)) {
                    winner = stringIntegerEntry.getKey();
                }
            }
        }
        return winner;
    }

}
