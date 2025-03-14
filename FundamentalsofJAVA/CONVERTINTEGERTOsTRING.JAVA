// Convert Integer to String

//1:Objects.toString()

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Integer num = 123; // Works for null values as well
        String str = Objects.toString(num, "default");
        System.out.println(str); // Output: "123"
    }
}

//2:String.valueOf()

int num = 123;
String str = String.valueOf(num);
System.out.println(str); // Output: "123"


//3:Integer.toString()
int num = 123;
String str = Integer.toString(num);
System.out.println(str); // Output: "123"


//4:String.format()

int num = 123;
String str = String.format("%d", num);
System.out.println(str); // Output: "123"

//5: +num (concatination)


