package com.myob.bowling;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public List<Character> processRollings(String rollings) {
        return constructList(convertRollings(rollings));
    }

    public boolean IsTheRollingsValid(String rollings){
        int shortest = 20;
        int longest = 24;
        return convertRollings(rollings).length()>=shortest && convertRollings(rollings).length()<=longest;
    }

    public String convertRollings(String rollings) {
        String convertedRollings = convertMiss(rollings);
        return convertStrike(convertedRollings);
    }

    public String convertMiss(String rollings) {
        return rollings.replace('-', '0');
    }

    public String convertStrike(String rollings) {
        List<Character> list = constructList(rollings);
        for (int i = 0; i < list.size(); i++) {
            if (isStrike(list.get(i))) {
                list.add(i + 1, '0');
            }
        }
        return getString(list);
    }

    public List<Character> constructList(String rollings) {
        List<Character> list = new ArrayList<>();
        char[] ch = rollings.toCharArray();
        for (char c : ch) {
            list.add(c);
        }
        return list;
    }

    public String getString(List<Character> list) {
        StringBuilder container = new StringBuilder();
        for (Character l : list) {
            container.append(l);
        }
        return container.toString();
    }

    public List<Character> getListOfLastFrame(String rollings){
        String convertedRollings = convertRollings(rollings);
        return constructList(convertedRollings.substring(18));
    }
    public boolean isLastFrameStrikeOrStrike(String rollings) {
        List<Character> list = getListOfLastFrame(rollings);
        List<Character> listToBeRemoved = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (isStrike(list.get(i)) && i + 1 <= list.size()) {
                listToBeRemoved.add(list.get(i + 1));
            }
        }
        list.removeAll(listToBeRemoved);
        return list.size() == 3;
    }

    public boolean isStrike(Character c) {
        return c.equals('x')||c.equals('X');
    }

    public boolean isSpare(Character c) {
        return c.equals('/');
    }

    public int convertToDigital(Character c) {
        if (Character.getNumericValue(c) >= 10 || Character.getNumericValue(c) < 0) {
            System.out.println("Warning!!!");
            System.out.println("The result you get must be wrong.");
            System.out.println("invalid rollings, there must be some character weird in the rollings out of '/','x' and number");
            return 999;
        }
        return Character.getNumericValue(c);
    }

}