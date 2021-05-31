package com.myob.bowling;

public class Frame {
    protected int index;
    protected boolean isStrike;
    protected boolean isSpare;
    protected int firstHit;
    protected int secondHit;
    protected int score;
    private int scoreWithBonus = 0;

    public Frame() {
    }

    public Frame(int index, boolean isStrike, boolean isSpare, int firstHit, int secondHit) {
        this.index = index;
        this.isStrike = isStrike;
        this.isSpare = isSpare;
        this.firstHit = firstHit;
        this.secondHit = secondHit;
        this.score = calculateScore();
    }


    public int calculateScore() {
        return firstHit + secondHit;
    }

    private void calculateScoreWithBonus(Frame nextFrame) {
        scoreWithBonus = this.score + nextFrame.getScore();
    }

    public void setScoreWithBonus(int scoreWithBonus) {
        this.scoreWithBonus = scoreWithBonus;
    }

    public int getIndex() {
        return index;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public boolean isSpare() {
        return isSpare;
    }

    public int getFirstHit() {
        return firstHit;
    }

    public int getSecondHit() {
        return secondHit;
    }

    public int getScore() {
        return score;
    }

    public int getScoreWithBonus() {
        return scoreWithBonus;
    }

}
