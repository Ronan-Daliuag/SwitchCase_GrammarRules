import java.util.regex.Pattern;
public class SwitchCaseValidation {
    // Method to check for switch reserved word. Returns true if there is an
    // instance of the word
    // Return false if no instance is found
    public static boolean switchChecker(String input) {
        String switchFinder = "";
        for (int i = 0; i < input.length(); i++) {
            if (switchFinder.contains("(")){
                if (switchFinder.contains("switch")) {
                    return true;
                }
                else {
                    System.out.println("Switch keyword not found");
                    return false;
                }
            } else
                switchFinder = switchFinder + input.charAt(i);
        }
        System.out.println("Switch keyword not found");
        return false;
    }

    // Method to check the variable inside the switch()
    // Note: switchChecker must be true to test this next
    public static boolean switchVariableChecker(String input) {
        String switchVariableFinder = "";
        int firstParenthesis = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                firstParenthesis = i + 1;
                break;
            }
            if (input.charAt(i) == ')') {
                System.out.println("No opening parenthesis found for <var>");
                return false;
            }
        }
        // Loop that starts from the index of the first parenthesis after the switch
        // keyword
        for (int i = firstParenthesis; i < input.length(); i++) {
            if (input.charAt(i) == '{') {
                switchVariableFinder = switchVariableFinder + input.charAt(i);
                break;
            } else
                switchVariableFinder = switchVariableFinder + input.charAt(i);
        }

        // if the <var> is just whitespace or is null
        if (switchVariableFinder.charAt(0) == ')') {
            System.out.println("No arguments found for switch");
            return false;
        }

        if (!switchVariableFinder.isBlank()) {
            int closingParenthesisCounter = 0;
            for (int i = 0; i < switchVariableFinder.length() - 1; i++) { // to not include the
                // starting curly brace
                if (switchVariableFinder.charAt(i) == '{' || switchVariableFinder.charAt(i) == '}'
                        || switchVariableFinder.charAt(i) == '(' || switchVariableFinder.charAt(i) == '>' || switchVariableFinder.charAt(i) == '<'
                        || switchVariableFinder.charAt(i) == '='|| switchVariableFinder.charAt(i) == '.')  {
                    System.out.println("Illegal characters for <var>");
                    return false;
                }
                if (switchVariableFinder.charAt(i) == ')') {
                    closingParenthesisCounter++;
                }
            }
            if (closingParenthesisCounter > 1) {
                System.out.println("Too many closing parenthesis");
                return false;
            }
            if (closingParenthesisCounter == 0) {
                System.out.println("No closing parenthesis for <var>");
                return false;
            }
            return true;
        }
        System.out.println("No closing parenthesis found for <var>");
        return false;
    }

//    Method to check the case keyword
    public static boolean checkCaseWord(String input) {
        boolean caseChecker = true;
        String caseFinder = "";
        try{
            for (int i = 0; i < input.length() + 1; i++) {
                if (caseFinder.contains("break")) {
                    if (caseFinder.contains("case")) {
                        caseFinder = "";
                    } else if (caseFinder.contains("default")) {
                        caseFinder = "";
                    } else {
                        System.out.println("Misspelled case/default keyword");
                        return false;
                    }
                }
                else if (caseFinder.contains("}")){
                    if (caseFinder.trim().length() == 1){
                        break;
                    }
                    if (caseFinder.contains("case")) {
                        caseFinder = "";
                    } else if (caseFinder.contains("default")) {
                        caseFinder = "";
                    } else {
                        System.out.println("Misspelled case/default keyword");
                        return false;
                    }
                }
                else
                    caseFinder = caseFinder + input.charAt(i);
            }
        } catch (IndexOutOfBoundsException ie) {
            System.out.println("Ending curly brace not found");
            return false;
        }

        return caseChecker;
    }
//    Method to check the break keyword
    public static boolean checkBreakWord(String input) {
        boolean breakChecker = true;
        String breakSpellChecker = "";
        int firstSemicolon = input.indexOf(';') + 1;
        int i = firstSemicolon;
        while (i < input.length()) {
            if (breakSpellChecker.contains(";")) {
                if (breakSpellChecker.contains("case")){
                    i = input.indexOf(';', i) + 1;
                    breakSpellChecker = "";
                }
                else if (!breakSpellChecker.contains("break")) {
                    System.out.println("Misspelled break word");
                    return false;
                }
                else {
                    i = input.indexOf(';', i) + 1;
                    if (i == 0)
                        break;
                    breakSpellChecker = "";
                }
            } else
                breakSpellChecker = breakSpellChecker + input.charAt(i);
            i++;
        }
        return breakChecker;
    }
//    Method to check the break's semicolon
    public static boolean checkBreakSemicolon(String input) {
        boolean breakChecker = true;
        String breakFinder = "";
        String semicolonChecker = "";
        for (int i = 0; i < input.length(); i++) {
            if (breakFinder.contains("break")) {
                if (semicolonChecker.contains("case") || semicolonChecker.contains("default")) {
                    if (!semicolonChecker.contains(";")) {
                        System.out.println("There is no semicolon after break");
                        return false;
                    }
                    else {
                        breakFinder = "";
                        semicolonChecker = "";
                    }
                } else
                        semicolonChecker = semicolonChecker + input.charAt(i);
            }
            else
                breakFinder = breakFinder + input.charAt(i);

        }
        return breakChecker;
    }

//    Method to check the case argument
    public static boolean checkCaseArgument(String input) {
        boolean caseChecker = true;
        String caseFinder = "";
        String caseArgument = "";
        for (int i = 0; i < input.length(); i++) {
            if (caseFinder.contains("case")) {
                if(caseArgument.contains(":")){
                    if(caseArgument.contains("<") || caseArgument.contains(">") || caseArgument.contains("=") || caseArgument.contains("{")
                            || caseArgument.contains("}") || caseArgument.contains("(") || caseArgument.contains(")") || caseArgument.contains(".")){
                        System.out.println("There is an illegal character inside a case parameter / No semicolon");
                        return false;
                    }
                    else {
                        caseFinder = "";
                        caseArgument = "";
                    }
                }
                else {
                    caseArgument = caseArgument + input.charAt(i);
                }
            } else
                caseFinder = caseFinder + input.charAt(i);
        }
        return caseChecker;
    }

    // Method to check for correct case syntax and break statements
    public static boolean caseAndBreakChecker(String input) {
        if (!checkCaseWord(input)) {
            return false;
        }
        if (!checkCaseArgument(input)) {
            return false;
        }
        if (!checkBreakSemicolon(input)) {
            return false;
        }
        if (!checkBreakWord(input)) {
            return false;
        }

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
        try {
            for (int i = 1; i < numberOfCases + 1; i++) {
                for (int y = caseOccurence; y < input.length(); y++) {
                    if (input.charAt(y) == ':') {
                        if (caseOccurence > breakOccurence) {
                            System.out.println("WARNING: Case " + i + " has no break statement. " +
                                    "The code will still run");
                            caseOccurence = input.indexOf("case", y);
                        } else if (caseOccurence < breakOccurence) {
                            caseOccurence = input.indexOf("case", y);
                            int breakDoubleCheck = input.indexOf("break;", caseOccurence);
                            if (breakDoubleCheck == breakOccurence) {
                                System.out.println("WARNING: Case " + i + " has no break statement. " +
                                        "The code will still run");
                            } else {
                                breakOccurence = input.indexOf("break;", caseOccurence);
                            }
                        }
                        break;
                    }
                }
            }
        } catch (IndexOutOfBoundsException ie) {
            System.out.println("There is no semicolon after case");
            return false;
        }
        return true;
    }
//Method to check the presence of a default statement and the ending curly brace.
    public static boolean defaultAndEndingCurlyBraceChecker(String input) {
        String findDefault = "default:";
        int defaultFinder = (int) Pattern.compile(findDefault).matcher(input).results().count();
        if (defaultFinder == 0) {
            System.out.println("WARNING: The input does not have a default code block." +
                    "The code will still run.");
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '}') {
                    return true;
                }
            }
        }
        int defaultOccurence = input.indexOf("default:", 0);
        try {
            for (int i = defaultOccurence; i < input.length(); i++) {
                if (input.charAt(i) == '}') {
                    System.out.println("Default code block found");
                    return true;
                }
            }
        } catch (IndexOutOfBoundsException ie) {
            System.out.println("Ending curly brace not found");
        }
        return false;
    }

    public static void main(String[] args) {
        String input = "switch(test){\ncase 'a': System.out.println(\"1\"); \n break;\n" +
                "case 'a': System.out.println(\"2\"); \n break;\n" +
                "case 'a': System.out.println(\"3\"); \n break;\n" +
                "case 'a': System.out.println(\"4\"); \n break;\n" +
                "default: System.out.println(\"5\"); \nbreak;\n}";
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
        else {
            System.out.println("The input is an invalid switch statement");
            System.exit(0);
        }
        System.out.println("The input is a valid switch statement");
    }
}
