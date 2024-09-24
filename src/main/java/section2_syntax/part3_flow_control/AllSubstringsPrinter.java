/*
 * Copyright (c) 2014 Michiel Noback
 * All rights reserved
 * www.bioinf.nl, www.cellingo.net
 */
package section2_syntax.part3_flow_control;

/**
 *
 * @author michiel
 */
public class AllSubstringsPrinter {
    public static void main(String[] args) {
        final AllSubstringsPrinter asp = new AllSubstringsPrinter();
        asp.printAllSubstrings("GATCG", true, false); // Left truncated, right aligned
    }

    public void printSubstringsLeftAlignedLeftTruncated(String stringToSubstring) {
        for (int i = 0; i < stringToSubstring.length(); i++) {
            System.out.println(stringToSubstring.substring(i));
        }
    }

    public void printAllSubstrings(String stringToSubstring, boolean leftTruncated, boolean leftAligned) {
        int length = stringToSubstring.length();

        if (leftTruncated) {
            for (int i = 0; i < length; i++) {
                String substring = stringToSubstring.substring(i);
                if (leftAligned) {
                    System.out.println(substring);
                } else {
                    System.out.println(createSpacer(i) + substring);
                }
            }
        } else {
            for (int i = length; i > 0; i--) {
                String substring = stringToSubstring.substring(0, i);
                if (leftAligned) {
                    System.out.println(substring);
                } else {
                    System.out.println(createSpacer(length - i) + substring);
                }
            }
        }
    }

    public String createSpacer(int length) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < length; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * THIS IS AN EXAMPLE OF HOW NOT TO DO IT!!
     * String concatenation in for-loops is *evil*
     * @param length
     * @return spacer
     */
    private String createSpacerTheWrongWay(int length) {
        String spacer = "";
        for (int i = 0; i < length; i++) {
            spacer += " ";
        }
        return spacer;
    }
}
