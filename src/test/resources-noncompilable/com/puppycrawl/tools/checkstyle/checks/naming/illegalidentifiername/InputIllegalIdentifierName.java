/*
IllegalIdentifierName
format = (default)(?i)^(?!(record|yield|var|permits|sealed)$).+$
tokens = (default)CLASS_DEF, INTERFACE_DEF, ENUM_DEF, ANNOTATION_DEF, ANNOTATION_FIELD_DEF, \
         PARAMETER_DEF, VARIABLE_DEF, METHOD_DEF, ENUM_CONSTANT_DEF, PATTERN_VARIABLE_DEF, \
         RECORD_DEF, RECORD_COMPONENT_DEF, LAMBDA


*/

//non-compiled with javac: Compilable with Java17
package com.puppycrawl.tools.checkstyle.checks.naming.illegalidentifiername;

import java.util.logging.LogRecord;

public class InputIllegalIdentifierName {
    public Class<Record[]> getRecordType() {
        return Record[].class;
    }

    private static void record(LogRecord... logArray) { // violation
        for (LogRecord record : logArray) { // violation
            record.getLevel();
        }
    }

    class yieldClass {
        int yield = 6; // violation

        public void yield() { // violation

        }
    }

    enum Day {
        MON,
        TUE,
        WED,
        THU,
        FRI,
        SAT,
        SUN,
    }

    int yield(Day day) { // violation
        return switch (day) {
            case MON, TUE -> Math.addExact(0, 1);
            case WED -> Math.addExact(1, 1);
            case THU, SAT, FRI, SUN -> 0;
            default -> {
                yield Math.addExact(2, 1); //yield statement
            }
        };
    }

    public static void main(String... args) {
        var var = 4; // violation

        int record = 15; // violation

        String yield = "yield"; // violation

        record Record // violation
                (Record record) { // violation
        }

        String yieldString = "yieldString"; //part of another word
        record MyRecord() {} //part of another word
        var variable = 2; //part of another word

        String recordString = "record";
        recordString = recordString.substring(record, 20);

        record MyOtherRecord(String record, String yield, String... var) { // 3 violations
        }
    }
}

