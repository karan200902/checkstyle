/*
EmptyBlock
option = TEXT
tokens = LITERAL_CASE


*/

package com.puppycrawl.tools.checkstyle.checks.blocks.emptyblock;

class InputEmptyBlockCase
{
    void method1(int a) {
        switch (a) {}
        switch (a) {case 1: ; }
        switch (a) {case 1:{}}  // violation 'Empty case block'
        switch (a) {
            case 1:
        }
        switch (a) {
            case 1:
            {}  // violation 'Empty case block'
        }
        switch (a) {
            case 1:
            {  //as the block contains a comment
            }
        }
    }

    public void method2(char c) {
        switch(c) { case 0: }
        switch(c) { case 0: {} method1(1); }    // violation 'Empty case block'
        switch(c) { case 0: method1(0); {} }
        switch(c) { case 0: case 1: {} }    // violation 'Empty case block'
        switch(c) { case 0: {} case 1: {    // violation 'Empty case block'
        }
        }
    }
}
