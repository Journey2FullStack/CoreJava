package org.example.interview;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {

        String valid1 = "geeksforgeeks"; // "allergy";
        String valid2 = "forgeeksgeeks"; // "allergic"
        String invalid1 = "allergy";
        String invalid2 = "allergic";


        // split string into char
        // add into map, if key exists increment the count for the key
        // do the step1 and step for 2nd string
        // compare the map count
        // if false.. then its not anagram
        // if equal.. check if the key count equal then continue for next key else return false and break;
        Map<Character, Integer> charMap1 = extractMap(valid1);
        Map<Character, Integer> charMap2 = extractMap(valid2);

        // print the collection
        System.out.println("First String " + valid1);
        for (Map.Entry<Character, Integer> entry : charMap1.entrySet()) {
            System.out.print(entry.getKey() + " ::" + entry.getValue());
        }
        System.out.println();
        System.out.println("Second String " + valid2);
        for (Map.Entry<Character, Integer> entry : charMap2.entrySet()) {
            System.out.print(entry.getKey() + " ::" + entry.getValue());
        }
        boolean result = isAnagram(charMap1, charMap2);
        System.out.println("\nFirst and Second string is Anagram " + result);

    }

    private static boolean isAnagram(Map<Character, Integer> charMap1, Map<Character, Integer> charMap2) {
        boolean result = false;
        if (charMap1.size() == charMap2.size()) {
            for (Map.Entry<Character, Integer> entry : charMap1.entrySet()) {
                if (charMap2.containsKey(entry.getKey()) && charMap2.containsValue(entry.getValue())) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;

    }

    private static Map<Character, Integer> extractMap(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (charCountMap.get(c) != null) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }
        return charCountMap;
    }
}
