package org.checkstyle.suppressionxpathfilter.returncount;

public class InputXpathReturnCountNonVoid {
    public boolean equals(Object obj) {  
        int i = 1;
        switch (i) {
        case 1: return true;
        case 2: return true;
        case 3: return true;
        case 4: return true;
        case 5: return true;
        case 6: return true;
        }
        return false;
    }
    boolean testNonVoid() { // warn
        int i = 1;
        switch(i) {
        case 1: return true;
        case 2: return true;
        case 3: return true;
        }
        return false;
    }

}
