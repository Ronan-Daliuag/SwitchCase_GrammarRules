import java.util.Scanner;

public class SwitchCaseValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
         * System.out.println("Enter Input: ");
         * String iinput = sc.nextLine();
         */

        String input = "switch(test){case 1: System.out.println(\"1\"); \n break;\n}";
        System.out.println("Input: " + input);

        String forCheck = "" + input.charAt(0) + input.charAt(1) + input.charAt(2) +
                input.charAt(3) + input.charAt(4) + input.charAt(5) + input.charAt(6);

        if (forCheck.toLowerCase().equals("switch(")) {
            System.out.println("GOODS SA switch");

            //Checking the <var> inside the () of switch() is empty or not
            int pointer = 7;
            if(input.charAt(pointer) == ')') {
                System.out.println("<var> can be empty");
                System.exit(0);
            }
 
            for (int i = pointer; i < input.length(); i++) {

                //Increasing the pointer by the number of characters <var> has
                if(input.charAt(i) != ')') {
                    continue;
                }

                if (input.charAt(i) == ')' && input.charAt(i + 1) == '{') {
                    System.out.println("goods sa ){");
                    continue;
                }

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
