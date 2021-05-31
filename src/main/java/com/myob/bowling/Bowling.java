package com.myob.bowling;

import java.util.ArrayList;
import java.util.List;

public class Bowling {
    private final Converter converter;
    private final List<Frame> game;

    public Bowling() {
        this.converter = new Converter();
        this.game = new ArrayList<>();
    }

    public List<Frame> getGame() {
        return game;
    }

    public int letTheGameBegin(String rollings) {
        if (converter.IsTheRollingsValid(rollings)){
            return converter.isLastFrameStrikeOrStrike(rollings) ?
                    calculateScoreWhenLastFrameIsStrikeOrSpare(rollings) : calculateScoreWhenLastFrameIsNotStrikeOrSpare(rollings);
        }
        System.out.println("The input rollings is invalid!!");
        return 99999;
    }

    public void importGameRecordWhenLastFrameIsNotStrikeOrSpare(String convertedRollings) {
        List<Character> list = getScoreList(convertedRollings);
        for (int i = 0; i < list.size(); i = i + 2) {
            int index = i / 2 + 1;
            Character firstHit = list.get(i);
            Character secondHit = list.get(i + 1);
            boolean isStrike = converter.isStrike(firstHit);
            boolean isSpare = converter.isSpare(secondHit);
            int firstHitScore = isStrike ? 10 : converter.convertToDigital(firstHit);
            int secondHitScore = isSpare ? 10 - firstHitScore : converter.convertToDigital(secondHit);
            recordFrame(index, isStrike, isSpare, firstHitScore, secondHitScore);
        }
    }

    public void importGameRecordWhenLastFrameIsStrikeOrSpare(String rollings) {
        List<Character> list = getScoreList(rollings);
        List<Character> listToBeRemoved = new ArrayList<>();
        int firstHitScore;
        int secondHitScore;
        int extraHitScore;
        boolean isStrike;
        boolean isSpare;
        for (int i = 0; i < 17; i = i + 2) {
            int index = i / 2 + 1;
            Character firstHit = list.get(i);
            Character secondHit = list.get(i + 1);
            isStrike = converter.isStrike(firstHit);
            isSpare = converter.isSpare(secondHit);
            firstHitScore = isStrike ? 10 : converter.convertToDigital(firstHit);
            secondHitScore = isSpare ? 10 - firstHitScore : converter.convertToDigital(secondHit);
            recordFrame(index, isStrike, isSpare, firstHitScore, secondHitScore);
        }
        List<Character> listOfLastFrame = converter.getListOfLastFrame(rollings);
        for (int i = 0; i < listOfLastFrame.size(); i++) {
            if (converter.isStrike(listOfLastFrame.get(i)) && i + 1 <= listOfLastFrame.size()) {
                listToBeRemoved.add(listOfLastFrame.get(i + 1));
            }
        }
        listOfLastFrame.removeAll(listToBeRemoved);
        isStrike = converter.isStrike(listOfLastFrame.get(0));
        isSpare = converter.isSpare(listOfLastFrame.get(1));
        boolean isSecondStrike = converter.isStrike(listOfLastFrame.get(1));
        boolean isExtraStrike = converter.isStrike(listOfLastFrame.get(2));
        firstHitScore = isStrike ? 10 : converter.convertToDigital(listOfLastFrame.get(0));
        if(isSecondStrike){
            secondHitScore = 10;
        }else {
            secondHitScore = isSpare ? 10 - firstHitScore : converter.convertToDigital(listOfLastFrame.get(1));
        }
        if(isExtraStrike){
            extraHitScore = 10;
        }else {
            extraHitScore = converter.isSpare(listOfLastFrame.get(2)) ? 10 - secondHitScore : converter.convertToDigital(listOfLastFrame.get(2));
        }
        recordLastFrame(isStrike, isSpare, firstHitScore, secondHitScore, extraHitScore);
    }

    public int calculateScoreWhenLastFrameIsNotStrikeOrSpare(String rollings) {
        importGameRecordWhenLastFrameIsNotStrikeOrSpare(rollings);
        return Calculator.calculateScoreWhenLastFrameHasNoStrikeAndSpare(game);
    }

    public int calculateScoreWhenLastFrameIsStrikeOrSpare(String rollings) {
        importGameRecordWhenLastFrameIsStrikeOrSpare(rollings);
        return Calculator.calculateScoreWhenLastFrameHasStrikeOrSpare(game);
    }

    private List<Character> getScoreList(String convertedRollings) {
        return converter.processRollings(convertedRollings);
    }

    private void recordFrame(int index, boolean isStrike, boolean isSpare, int firstHit, int secondHit) {
        Frame frame = new Frame(index, isStrike, isSpare, firstHit, secondHit);
        game.add(frame);
    }

    private void recordLastFrame(boolean isStrike, boolean isSpare, int firstHit,
                                 int secondHit, int extra) {
        Frame lastFrame = new LastFrame(isStrike, isSpare, firstHit, secondHit, extra);
        game.add(lastFrame);
    }

}
