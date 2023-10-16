import java.util.Scanner;
import java.util.regex.Pattern;
public class SwitchCaseValidation {
    //    Method to check for switch reserved word. Returns true if there is an instance of the word
//    Return false if no instance is found
    public static boolean switchChecker(String input) {
        String switchFinder = "";
        for (int i = 0; i < input.length(); i++) {
            if (switchFinder.equals("switch")) {
                System.out.println("Switch keyword found!");
                return true;
            } else
                switchFinder = switchFinder + input.charAt(i);
        }
        System.out.println("Switch keyword not found!");
        return false;
    }

    //    Method to check the variable inside the switch()
//    Note: switchChecker must be true to test this next
    public static boolean switchVariableChecker(String input) {
        String switchVariableFinder = "";
        int firstParenthesis = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                firstParenthesis = i + 1;
                break;
            }
            if (input.charAt(i) == ')') {
                System.out.println("No opening parenthesis found for <var>!");
                return false;
            }
        }
//        Loop that starts from the index of the first parenthesis after the switch keyword
        for (int i = firstParenthesis; i < input.length(); i++) {
            if (input.charAt(i) == '{') {
                switchVariableFinder = switchVariableFinder + input.charAt(i);
                break;
            } else
                switchVariableFinder = switchVariableFinder + input.charAt(i);
        }

//        if the <var> is just whitespace or is null
        if (switchVariableFinder.charAt(0) == ')') {
            System.out.println("No arguments found for switch!");
            return false;
        }

//      TODO: add more illegal characters, functions inside parenthesis?
        if (!switchVariableFinder.isBlank()) {
            int closingParenthesisCounter = 0;
            for (int i = 0; i < switchVariableFinder.length() - 1; i++) { // to not include the starting curly brace
                if (switchVariableFinder.charAt(i) == '{' || switchVariableFinder.charAt(i) == '}'
                        || switchVariableFinder.charAt(i) == '(') {
                    System.out.println("Illegal characters for <var>!");
                    return false;
                }
                if (switchVariableFinder.charAt(i) == ')') {
                    closingParenthesisCounter++;
                }
            }
            if (closingParenthesisCounter > 1) {
                System.out.println("Too many closing parenthesis!");
                return false;
            }
            System.out.println("Valid <var> argument!");
            return true;
        }
        System.out.println("No closing parenthesis found for <var>!");
        return false; //default return statement
    }

    //TODO: implement these methods
//    Method to check for correct case syntax and break statements
    public static boolean caseAndBreakChecker(String input) {
        String findCase = "case";
        int numberOfCases = (int) Pattern.compile(findCase).matcher(input).results().count();
        int caseStart = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '{') {
                caseStart = i + 1;
                break;
            }
        }
        int caseOccurence = input.indexOf("case", caseStart);
        int breakOccurence = input.indexOf("break;", caseOccurence);
        for (int i = 1; i < numberOfCases + 1; i++){
            for (int y = caseOccurence; y < input.length(); y++){
                if (input.charAt(y) == ':'){
                    if (caseOccurence > breakOccurence){
                        System.out.println("WARNING: Case " + i + " has no break statement");
                        caseOccurence = input.indexOf("case", y);
                    }
                    else if (caseOccurence < breakOccurence){
                        caseOccurence = input.indexOf("case", y);
                        int breakDoubleCheck = input.indexOf("break;", caseOccurence);
                        if (breakDoubleCheck == breakOccurence){
                            System.out.println("WARNING: Case " + i + " has no break statement");
                        }
                        else{
                            System.out.println("Case " + i + " found with break statement!");
                            breakOccurence = input.indexOf("break;", caseOccurence);
                        }
                    }
                    break;
                }
            }
        }
        return true;
    }

    public static boolean defaultAndEndingCurlyBraceChecker(String input) {
        String findDefault = "default:";
        int defaultFinder = (int) Pattern.compile(findDefault).matcher(input).results().count();
        if (defaultFinder == 0){
            System.out.println("WARNING: The input does not have a default code block." +
                    "The code will still run.");
            for (int i = 0; i < input.length(); i++){
                if (input.charAt(i) == '}'){
                    System.out.println("Ending curly brace found!");
                    return true;
                }
            }
        }
        int defaultOccurence = input.indexOf("default:", 0);
        for (int i = defaultOccurence; i < input.length(); i++){
            if (input.charAt(i) == '}'){
                System.out.println("Ending curly brace found!");
                return true;
            }
        }
        System.out.println("Ending curly brace not found!");
        return false;
    }

    public static void main(String[] args) {
        String input = "switch(test){\ncase 'a': System.out.println(\"1\"); \n break;\n" +
                "case 'b': System.out.println(\"2\"); \n break;\n" +
                "case 'c': System.out.println(\"3\"); \n break;\n" +
                "case 'd': System.out.println(\"4\"); \n break;\n}";
        System.out.println("Input: " + input);
        if (switchChecker(input))
            System.out.println("The input has the switch keyword");
        else {
            System.out.println("The input is an invalid switch statement");
            System.exit(0);
        }
        if (switchVariableChecker(input))
            System.out.println("The input has a valid <var> argument");
        else {
            System.out.println("The input is an invalid switch statement");
            System.exit(0);
        }
        if (caseAndBreakChecker(input))
            System.out.println("The input has a valid cases syntax");
        else {
            System.out.println("The input is an invalid switch statement");
            System.exit(0);
        }
        if (defaultAndEndingCurlyBraceChecker(input))
            System.out.println("The input has an ending curly brace");
        else{
            System.out.println("The input is an invalid switch statement");
            System.exit(0);
        }



//        String forCheck = "" + input.charAt(0) + input.charAt(1) + input.charAt(2) +
//                input.charAt(3) + input.charAt(4) + input.charAt(5) + input.charAt(6);
//
//        if (forCheck.toLowerCase().equals("switch(")) { //I think kailangan tanggalin yung .toLowerCase() since I think explicit the small cases yung term na "switch"
//            System.out.println("GOODS SA switch");
//
//            //Checking the <var> inside the () of switch() is empty or not
//            if(input.charAt(7) == ')') {
//                System.out.println("<var> can be empty");
//                System.exit(0);
//            }
//
//            int pointer = 7;
//            String beforevar ="";
//            String var = "";
//            String empty ="";
//            //(<var>){ Checker
//            for (int i = pointer; i < input.length(); i++) {
//                if(input.charAt(i) == ' '){
//                    System.out.println("empty");
//                    empty = empty + input.charAt(i);
//                    beforevar = beforevar + input.charAt(i);
//                    continue;
//                }
//                //Increasing the pointer by the number of characters <var> has
//                if(input.charAt(i) != ')' && input.charAt(i) != ' ' ) {
//                    beforevar = "l";
//                    var = var + input.charAt(i);//Put the character in the String Checker
//                        if(input.charAt(i+1) == ' ') {
//                            for(int j = i; j < input.length(); j++) {
//                                if (input.charAt(j+1) == ' '){
//                                    System.out.println("after name space");
//                                    continue;
//                                }
//                                if (input.charAt(j+1) == ')') {
//                                    break;
//                                }
//                                if (input.charAt(j+1) != ' ') {
//                                        System.out.println("<var> must be a singlular name");
//                                        System.exit(0);
//                                }
//                            }
//                        }
//                    continue;
//                }
//                if(beforevar.equals(empty)){
//                    System.out.println("Does not have <var>");
//                    break;
//                }
//                if (input.charAt(i) == ')' && input.charAt(i + 1) == '{') {
//                    System.out.println(var + "\nreached");
//                    pointer = i + 2; // brings to pointer after {
//                    break;
//                }
//            }
//
//            //case: checker
//            for (int i = pointer; i < input.length(); i++) {
//
//                if (input.charAt(i) == 'c' && input.charAt(i + 1) == 'a' && input.charAt(i + 2) == 's'
//                        && input.charAt(i + 3) == 'e') {
//                    System.out.println("goods sa case");
//                    i += 3;
//                    pointer = i;
//                    break;
//                }
//            }
//
//            for (int i = pointer; i < input.length(); i++) {
//                if ((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') || (input.charAt(i) >= 0 && input.charAt(i) <= 9) && (input.charAt(i+1) == ':')) {
//                    System.out.println("goods sa case number or char at colon");
//                    break;
//                }
//            }
//
//            /*
//             * int mark = 8;
//             * String temp = "temp";
//             * for (int i = mark; temp != ""; i++) {
//             * if (i == input.length()) {
//             * System.out.println("This is not a valid loop declaration");
//             * System.exit(0);
//             * }
//             * temp = "" + input.charAt(i);
//             * if (temp.equals(")")) {
//             * mark = i;
//             * break;
//             * }
//             * }
//             *
//             * mark++;
//             * temp = "temp";
//             * for (int i = mark; temp != ""; i++) {
//             * if (i == input.length()) {
//             * System.out.println("This is not a valid loop declaration");
//             * System.exit(0);
//             * }
//             * }
//             */
//        } else {
//            System.out.println("This is not a valid switch declaration");
//        }
    }
}

