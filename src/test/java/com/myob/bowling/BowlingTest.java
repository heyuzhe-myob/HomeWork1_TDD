package com.myob.bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BowlingTest {
    Bowling bowling = new Bowling();

    @Test
    @DisplayName("Test for calculating score when lastFrame is not strike or spare")
    public void shouldCreateGameRecordWhenLastFrameIsNotStrikeOrSpare() {
        String rollings = "11x2/33x";
        bowling.importGameRecordWhenLastFrameIsNotStrikeOrSpare(rollings);
        Assertions.assertEquals(5, bowling.getGame().size());
    }

    @Test
    @DisplayName("Test for calculating score when lastFrame is not strike or spare")
    public void shouldReturn0IfAllMissWhen() {
        Assertions.assertEquals(0, bowling.letTheGameBegin("--------------------"));
    }

    @Test
    @DisplayName("Test for calculating score when lastFrame is not strike or spare")
    public void shouldReturn20WhenAllHit1() {
        Assertions.assertEquals(20, bowling.letTheGameBegin("11111111111111111111"));
    }

    @Test
    @DisplayName("Test for calculating score when lastFrame is not strike or spare")

    public void shouldReturn29() {
        Assertions.assertEquals(29, bowling.letTheGameBegin("113/1111111111111111"));
    }

    @Test
    @DisplayName("Test for calculating score when lastFrame is not strike or spare")
    public void shouldReturn30UnderThisSituation() {
        Assertions.assertEquals(30, bowling.letTheGameBegin("x111111111111111111"));
    }

    @Test
    @DisplayName("Test for calculating score when lastFrame is not strike or spare")
    public void shouldReturn49() {
        Assertions.assertEquals(49, bowling.letTheGameBegin("xx1111111111111111"));
    }

    @Test
    @DisplayName("Test for calculating score when lastFrame is not strike or spare")
    public void shouldReturn245() {
        Assertions.assertEquals(245, bowling.letTheGameBegin("xxxxxXXxx11"));
    }

    @Test
    @DisplayName("Test for calculating score when lastFrame is not strike or spare")
    public void shouldReturn125() {
        Assertions.assertEquals(125, bowling.letTheGameBegin("12x3/452/xx4/2-1-"));
    }

    @Test
    @DisplayName("Test for calculating score when lastFrame is not strike or spare")
    public void shouldReturn96() {
        Assertions.assertEquals(96, bowling.letTheGameBegin("-------9545/5/5/x63"));
    }

    @Test
    @DisplayName("Test for calculating score when lastFrame is not strike or spare")
    public void shouldReturn51() {
        Assertions.assertEquals(51, bowling.letTheGameBegin("354323-12-2345234212"));
    }

    @Test
    @DisplayName("Test for calculating score when lastFrame is not strike or spare")
    public void shouldReturn12() {
        Assertions.assertEquals(12, bowling.letTheGameBegin("1/1-----------------"));
    }

    @Test
    @DisplayName("Test for calculating score when lastFrame is strike or spare")
    public void shouldReturn48() {
        Assertions.assertEquals(48, bowling.letTheGameBegin("111111111111111111xxx"));
    }

    @Test
    @DisplayName("Test for calculating score when lastFrame is strike or spare")
    public void shouldReturn144() {
        Assertions.assertEquals(144, bowling.letTheGameBegin("12x3/452/xx4/2-1/x"));
    }

    @Test
    @DisplayName("Test for calculating score when lastFrame is strike or spare")
    public void shouldReturn129() {
        Assertions.assertEquals(129, bowling.letTheGameBegin("2/614/7/273/7/3/537/5"));
    }

    @Test
    @DisplayName("Test for calculating score when lastFrame is strike or spare")
    public void shouldReturn150() {
        Assertions.assertEquals(150, bowling.letTheGameBegin("5/5/5/5/5/5/5/5/5/5/5"));
    }

    @Test
    @DisplayName("Test for calculating score when lastFrame is strike or spare")
    public void shouldReturn13() {
        Assertions.assertEquals(13, bowling.letTheGameBegin("------------------3/3"));
    }


    @Test
    @DisplayName("Test for calculating score when Finish with strike but no spare")
    public void shouldReturn14() {
        Assertions.assertEquals(14, bowling.letTheGameBegin("X11----------------"));
    }

    @Test
    @DisplayName("Test for calculating score when Finish with strike but no spare")
    public void shouldReturn30() {
        Assertions.assertEquals(30, bowling.letTheGameBegin("------------------Xxx"));
    }

    @Test
    @DisplayName("Test for calculating score when Finish with strike and spare")
    public void shouldReturn166() {
        Assertions.assertEquals(166, bowling.letTheGameBegin("x8/4/x6/x6/34x4/2"));
    }

    @Test
    @DisplayName("Test for calculating score when Finish with strike and spare")
    public void shouldReturn139() {
        Assertions.assertEquals(139, bowling.letTheGameBegin("137/2/2/X635/6/81x6/"));
    }

    @Test
    @DisplayName("Test for calculating score when Finish with strike and spare")
    public void shouldReturn20() {
        Assertions.assertEquals(20, bowling.letTheGameBegin("------------------X3/"));
    }

    @Test
    @DisplayName("Test for calculating score when Finish with strike and spare")
    public void shouldReturn10() {
        Assertions.assertEquals(10, bowling.letTheGameBegin("------------------x--"));
    }

    @Test
    @DisplayName("Test invalid input")
    public void shouldReturn99999() {
        Assertions.assertEquals(99999, bowling.letTheGameBegin("---------------xxxx---x--"));
    }
}