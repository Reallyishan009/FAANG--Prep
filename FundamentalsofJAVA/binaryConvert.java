package FundamentalsofJAVA;

public class binaryConvert {

    public static String binaryAddition(int a, int b) {
        int sum = a + b;
        StringBuilder binary = new StringBuilder();

        if (sum == 0) return "0"; 

        while (sum > 0) {
            binary.append(sum % 2); 
            sum /= 2; 
        }

        return binary.reverse().toString(); 
    }
}