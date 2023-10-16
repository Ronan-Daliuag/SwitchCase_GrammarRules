import java.util.Scanner;

public class SwitchCaseValidation {
//    Method to check for switch reserved word. Returns true if there is an instance of the word
//    Return false if no instance is found
    public static boolean switchChecker(String input){
        String switchFinder = "";
        for (int i = 0; i<input.length(); i++){
            if (switchFinder.equals("switch")){
                System.out.println("Switch keyword found!");
                return true;
            }
            else
                switchFinder = switchFinder + input.charAt(i);
        }
        System.out.println("Switch keyword not found!");
        return false;
    }
//    Method to check the variable inside the switch()
//    Note: switchChecker must be true to test this next
    public static boolean switchVariableChecker(String input){
//        Finds the first instance of open parenthesis
        String switchVariableFinder = "";
        int firstParenthesis = 0;
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == '('){
                firstParenthesis = i + 1; //does not include the opening parenthesis
                break;
            }
            if (input.charAt(i) == ')'){
                System.out.println("No opening parenthesis found for <var>!");
                return false; // no opening parenthesis found before closing
            }
        }
//        Loop that starts from the index of the first parenthesis after the switch keyword
        if (firstParenthesis == 0) {
            System.out.println("No opening parenthesis found for <var>!");
            return false; // no opening parenthesis
        }
        for (int i = firstParenthesis; i < input.length();i++) {
            if (input.charAt(i) == ')'){
                break;
            }
            switchVariableFinder = switchVariableFinder + input.charAt(i);
        }
//        if the <var> is just whitespace or is null
        if (switchVariableFinder.isBlank()) {
            System.out.println("No arguments found for switch!");
            return false; //no variable found in argument
        }
//      if the <var> has illegal characters inside parenthesis
//      TODO: add more illegal characters, functions inside parenthesis?
        if (!switchVariableFinder.isBlank()){
            for (int i = 0; i < switchVariableFinder.length(); i++){
                if (switchVariableFinder.charAt(i) == '{' || switchVariableFinder.charAt(i) == '}'
                        || switchVariableFinder.charAt(i) == '(' || switchVariableFinder.charAt(i) == ')') {
                    System.out.println("Illegal characters for <var>!");
                    return false; // illegal character found
                }
            }
            System.out.println("Valid <var> argument!");
            return true; // valid variable argument
        }
        System.out.println("No closing parenthesis found for <var>!");
        return false; //<var> most likely does not have a closing parenthesis to the opening parenthesis
    }

    //TODO: implement these methods
    public static boolean curlyBraceChecker (String input){
        return false;
    }
    public static boolean caseAndBreakChecker (String input){
        return false;
    }
    public static boolean defaultChecker (String input){
        return false;
    }
    public static boolean endingCurlyBraceChecker (String input){
        return false;
    }
    public static void main(String[] args) {
        String input = "switch(test){case 1: System.out.println(\"1\"); \n break;\n}";
        System.out.println("Input: " + input);
        if (switchChecker(input) && switchVariableChecker(input))
            System.out.println("The input is a valid switch statement");
        else
            System.out.println("The input is an invalid switch statement");
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
