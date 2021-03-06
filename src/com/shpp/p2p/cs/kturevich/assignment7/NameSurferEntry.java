package com.shpp.p2p.cs.kturevich.assignment7;

/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

public class NameSurferEntry implements NameSurferConstants {
    String name;
    int[] ranks;

	/* Constructor: NameSurferEntry(line) */

    /**
     * Creates a new NameSurferEntry from a data line as it appears
     * in the data file.  Each line begins with the name, which is
     * followed by integers giving the rank of that name for each
     * decade.
     */
    public NameSurferEntry(String line) {
        String[] elements = line.split(" ");
        this.name = elements[0];
        this.ranks = parseRanks(elements);
    }

    private int[] parseRanks(String[] elements) {
        int[] ranks = new int[NDECADES];
        for (int i = 1; i < elements.length; i++) {
            ranks[i-1] = Integer.parseInt(elements[i]);
        }
        return  ranks;
    }

	/* Method: getName() */

    /**
     * Returns the name associated with this entry.
     */
    public String getName() {
        if (this.name != null) {
            return this.name;
        }
        return null;
    }

	/* Method: getRank(decade) */

    /**
     * Returns the rank associated with an entry for a particular
     * decade.  The decade value is an integer indicating how many
     * decades have passed since the first year in the database,
     * which is given by the constant START_DECADE.  If a name does
     * not appear in a decade, the rank value is 0.
     */
    public int getRank(int decade) {
        return this.ranks[decade];
    }

	/* Method: toString() */

    /**
     * Returns a string that makes it easy to see the value of a
     * NameSurferEntry.
     */
    public String toString() {
        String result = "";

        result += this.name;
        result += "[";

        for (int rank : this.ranks) {
            result += rank;
            result += " ";
        }

        //remove extra space
        result = result.substring(0, result.length() - 1);

        result += "]";
        return result;
    }
}

