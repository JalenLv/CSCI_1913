    public String toVeryFancyString() {
        // we're getting into some deep magic with this one.
        // Don't be too worried if it doesn't work on your computer.

        
        // user getSuitNum and getRankNum so we don't assume any specific private variable name.
        char letter_part_one = '\uD83C';
        char letter_part_two = (char) ('\uDCA0' + getRankNum());
        if (getSuitNum() == 2) {
            letter_part_two += 16;
        } else if (getSuitNum() == 4) {
            letter_part_two += 32;
        } else if (getSuitNum() == 3) {
            letter_part_two += 48;
        }
        if (getRankNum() >=12) {
            letter_part_two++; // skip "Knight".
        }
        
        String retval;
        if (getSuitNum()%2 == 1) {
            // black card
            retval = "\u001B[30m\u001B[47m";
        } else {
            // red card
            retval = "\u001B[31m\u001B[47m";
        }

        return retval + letter_part_one + letter_part_two + " \u001B[0m";
    }

    public String toFancyString() {
        String suits = "♠♥♣♦";
        String ranks = "A23456789⑩JQK";
        // user getSuitNum and getRankNum so we don't assume any specific private variable name.
        return ""+suits.charAt(getSuitNum()-1) + ranks.charAt(getRankNum()-1);
    }

