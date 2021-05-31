package com.myob.bowling;

import java.util.List;

public class Calculator {
    public static int calculateScoreWhenLastFrameHasNoStrikeAndSpare(List<Frame> game) {
        int totalScore = 0;
        for (int i = 0; i < game.size(); i++) {
            Frame f1 = game.get(i);
            if (i < game.size() - 2) {
                Frame f2 = game.get(i + 1);
                Frame f3 = game.get(i + 2);
                if (f1.isStrike()) {
                    if (!f2.isStrike()) {
                        totalScore = totalScore + f1.getScore() + f2.getScore();
                    } else {
                        totalScore = totalScore + f1.getScore() + f2.getScore() + f3.getFirstHit();
                    }
                    continue;
                }
                if (f1.isSpare()) {
                    totalScore = totalScore + f1.getScore() + f2.getFirstHit();
                    continue;
                }
                totalScore += f1.getScore();
            }
            if (i == game.size() - 2) {
                Frame f2 = game.get(i + 1);
                if (f1.isStrike()) {
                    if (!f2.isStrike()) {
                        totalScore = totalScore + f1.getScore() + f2.getScore();
                    }
                    continue;
                }
                if (f1.isSpare()) {
                    totalScore = totalScore + f1.getScore() + f2.getFirstHit();
                    continue;
                }
                totalScore += f1.getScore();
            }
            if (i == game.size() - 1) {
                totalScore += f1.getScore();
            }

        }
        return totalScore;
    }

    public static int calculateScoreWhenLastFrameHasStrikeOrSpare(List<Frame> game) {
        int totalScore = 0;
        for (int i = 0; i < game.size(); i++) {
            Frame f1 = game.get(i);
            if (i < game.size() - 2) {
                Frame f2 = game.get(i + 1);
                Frame f3 = game.get(i + 2);
                if (f1.isStrike()) {
                    if (!f2.isStrike()) {
                        totalScore = totalScore + f1.getScore() + f2.getScore();
                    } else {
                        totalScore = totalScore + f1.getScore() + f2.getScore() + f3.getFirstHit();
                    }
                    continue;
                }
                if (f1.isSpare()) {
                    totalScore = totalScore + f1.getScore() + f2.getFirstHit();
                    continue;
                }
                totalScore += f1.getScore();
            }
            if (i == game.size() - 2) {
                Frame f2 = game.get(i + 1);
                if (f1.isStrike()) {
                    if (!f2.isStrike()) {
                        totalScore = totalScore + f1.getScore() + f2.getFirstHit() + f2.getSecondHit();
                    }
                    continue;
                }
                if (f1.isSpare()) {
                    totalScore = totalScore + f1.getScore() + f2.getFirstHit();
                    continue;
                }
                totalScore += f1.getScore();
            }
            if (i == game.size() - 1) {
                totalScore += game.get(i).getScore();
            }

        }
        return totalScore;
    }


}
