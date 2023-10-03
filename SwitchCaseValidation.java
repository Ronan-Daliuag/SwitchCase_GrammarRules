public class SwitchCaseValidation {
    public static void main(String[] args) {
        String input = "switch(test)(case 1:System.out.println(\"1\");break;" +
                "case: 10:System.out.println(\"10\");break;}";
        System.out.println("Input: " + input);
        String forCheck = "" + input.charAt(0) + input.charAt(1) + input.charAt(2) +
                input.charAt(3) + input.charAt(4) + input.charAt(5) + input.charAt(6);
        if (forCheck.toLowerCase().equals("switch(")){
            int mark = 8;
            String temp = "temp";
            for (int i = mark; temp != ""; i++){
                if (i == input.length()){
                    System.out.println("This is not a valid loop declaration");
                    System.exit(0);
                }
                temp = "" + input.charAt(i);
                if (temp.equals(")")){
                    mark = i;
                    break;
                }
            }
            mark++;
            temp = "temp";
            for (int i = mark; temp != ""; i++) {
                if (i == input.length()){
                    System.out.println("This is not a valid loop declaration");
                    System.exit(0);
                }
            }
        }
    }
}
