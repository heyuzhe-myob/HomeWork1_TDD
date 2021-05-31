package com.myob.bowling;

public class LastFrame extends Frame {

    private final int extra;

    public LastFrame(boolean isStrike, boolean isSpare, int firstHit, int secondHit, int extra) {
        super.index = 20;
        super.isStrike = isStrike;
        super.isSpare = isSpare;
        super.firstHit = firstHit;
        super.secondHit = secondHit;
        this.extra = extra;
        super.score = calculateScore();
    }

    @Override
    public int calculateScore() {
        return super.firstHit + super.secondHit + extra;
    }

}
