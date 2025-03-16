package FundamentalsofJAVA;

public class CorrectTheMistakesofTheCharacterRecognitionSoftware {
    public static String correct(String string) {
        StringBuilder str = new StringBuilder();

        for (char ch : string.toCharArray()) {
           
            if (ch == '5') {
                str.append('S');
            } else if (ch == '0') {
                str.append('O');
            } else if (ch == '1') {
                str.append('I');
            } else {
                str.append(ch); 
            }
        }
        
        return str.toString();
    }
}
