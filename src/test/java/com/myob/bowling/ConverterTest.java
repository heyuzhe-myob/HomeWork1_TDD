package com.myob.bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ConverterTest {
    private final Converter converter = new Converter();

    @Test
    public void shouldReturnCorrectFormatOfRollingsWhenAllMiss() {
        Assertions.assertEquals("00000000000000000000", converter.convertMiss("--------------------"));
    }

    @Test
    public void shouldReturnCorrectFormatOfRollingsWhenAllStrike() {
        Assertions.assertEquals("x0x0x0x0x0x0x0x0x0x0x0x0", converter.convertStrike("xxxxxxxxxxxx"));
    }

    @Test
    public void shouldReturnCorrectFormatOfRollingsWhenHasMissStrikeAndSpare() {
        Assertions.assertEquals("101/x0111111111111x0x0x0", converter.convertRollings("1-1/x111111111111xxx"));
    }

    @Test
    public void shouldReturnTrueWhenLastFrameIsStrike() {
        Assertions.assertTrue(converter.isLastFrameStrikeOrStrike("111111111111111111xxx"));
    }

    @Test
    public void shouldReturnFalseWhenLastFrameIsNotStrike() {
        Assertions.assertFalse(converter.isLastFrameStrikeOrStrike("1234567891234567899-"));
    }

    @Test
    public void shouldReturnTrueWhenIsStrike() {
        Assertions.assertTrue(converter.isStrike('x'));
    }

    @Test
    public void shouldReturnTrueWhenIsSpare() {
        Assertions.assertTrue(converter.isSpare('/'));
    }

    @Test
    public void shouldReturnScoreWhenIsDigital(){
        Assertions.assertEquals(7, converter.convertToDigital('7'));
    }

    @Test
    public void shouldReturn999WhenIsNotDigital(){
        Assertions.assertEquals(999, converter.convertToDigital('z'));
    }

    @Test
    public void shouldReturnFalseWhenRollingsIsInvalidDueToShort(){
        Assertions.assertFalse(converter.IsTheRollingsValid("123312X"));
    }

    @Test
    public void shouldReturnFalseWhenRollingsIsInvalidDueToLong(){
        Assertions.assertFalse(converter.IsTheRollingsValid("xx1111111111111111111xx1"));
    }

    @Test
    public void shouldReturnTrueWhenRollingsIsValid(){
        Assertions.assertTrue(converter.IsTheRollingsValid("11111111111111111111"));
    }

    @Test
    public void shouldReturnTrueWhenComplexRollingsIsValid(){
        Assertions.assertTrue(converter.IsTheRollingsValid("12x3/452/xx4/2-xxx"));
    }
}