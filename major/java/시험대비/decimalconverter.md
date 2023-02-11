```java
public class DecimalConvertor {
    public static int binaryToDecimal(String binaryValue) {
        int decimalValue = 0;
        int length = binaryValue.length();
        int base = 1;
        for (int i = length - 1; i >= 0; i--) {
            if (binaryValue.charAt(i) == '1') {
                decimalValue += base;
            }
            base *= 2;
        }
        return decimalValue;
    }

    public static String decimalToBinary(int decimal) {
        String binary = "";
        while (decimal > 0) {
            binary = (decimal % 2) + binary;
            decimal = decimal / 2;
        }
        return binary;
    }
}

```