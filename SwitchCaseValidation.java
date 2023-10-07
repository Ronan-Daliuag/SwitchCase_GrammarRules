import java.util.Scanner;

public class SwitchCaseValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
         * System.out.println("Enter Input: ");
         * String iinput = sc.nextLine();
         */
        // TODO function: add checking for break statements. Print out whether there is a break statement before cases
        // TODO function: checking for default, recognize whether default block is present
        String input = "switch(test){case 1: System.out.println(\"1\"); \n break;\n}";
        System.out.println("Input: " + input);

        String forCheck = "" + input.charAt(0) + input.charAt(1) + input.charAt(2) +
                input.charAt(3) + input.charAt(4) + input.charAt(5) + input.charAt(6);
        
        if (forCheck.toLowerCase().equals("switch(")) { //I think kailangan tanggalin yung .toLowerCase() since I think explicit the small cases yung term na "switch"
            System.out.println("GOODS SA switch");

            //Checking the <var> inside the () of switch() is empty or not
            if(input.charAt(7) == ')') {
                System.out.println("<var> can be empty");
                System.exit(0);
            }

            int pointer = 7;
            String beforevar ="";
            String var = "";
            String empty ="";
            //(<var>){ Checker
            for (int i = pointer; i < input.length(); i++) {
                if(input.charAt(i) == ' '){
                    System.out.println("empty");
                    empty = empty + input.charAt(i);
                    beforevar = beforevar + input.charAt(i);
                    continue;
                }              
                //Increasing the pointer by the number of characters <var> has
                if(input.charAt(i) != ')' && input.charAt(i) != ' ' ) {
                    beforevar = "l";
                    var = var + input.charAt(i);//Put the character in the String Checker
                        if(input.charAt(i+1) == ' ') {
                            for(int j = i; j < input.length(); j++) {
                                if (input.charAt(j+1) == ' '){
                                    System.out.println("after name space");
                                    continue;
                                }
                                if (input.charAt(j+1) == ')') {
                                    break;
                                }
                                if (input.charAt(j+1) != ' ') {
                                        System.out.println("<var> must be a singlular name");
                                        System.exit(0);  
                                }
                            }
                        }
                    continue;
                }
                if(beforevar.equals(empty)){
                    System.out.println("Does not have <var>");
                    break;
                }
                if (input.charAt(i) == ')' && input.charAt(i + 1) == '{') {
                    System.out.println(var + "\nreached");
                    pointer = i + 2; // brings to pointer after {
                    break;
                }
            }

            //case: checker
            for (int i = pointer; i < input.length(); i++) {

                if (input.charAt(i) == 'c' && input.charAt(i + 1) == 'a' && input.charAt(i + 2) == 's'
                        && input.charAt(i + 3) == 'e') {
                    System.out.println("goods sa case");
                    i += 3;
                    pointer = i;
                    break;
                }
            }

            for (int i = pointer; i < input.length(); i++) {
                if ((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') || (input.charAt(i) >= 0 && input.charAt(i) <= 9) && (input.charAt(i+1) == ':')) {
                    System.out.println("goods sa case number or char at colon");
                    break;
                }
            }

            /*
             * int mark = 8;
             * String temp = "temp";
             * for (int i = mark; temp != ""; i++) {
             * if (i == input.length()) {
             * System.out.println("This is not a valid loop declaration");
             * System.exit(0);
             * }
             * temp = "" + input.charAt(i);
             * if (temp.equals(")")) {
             * mark = i;
             * break;
             * }
             * }
             * 
             * mark++;
             * temp = "temp";
             * for (int i = mark; temp != ""; i++) {
             * if (i == input.length()) {
             * System.out.println("This is not a valid loop declaration");
             * System.exit(0);
             * }
             * }
             */
        } else {
            System.out.println("This is not a valid switch declaration");
        }
    }
}
