import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberToEnglishWords {
    Scanner sc = new Scanner(System.in);

    //We should convert the Enter number to a string, like 100 to "one hundred"
    //We should use a switch statement to convert the number to a string
    //We should use a for loop to convert the number to a string
    //Make a for loop from 1 to 1000 and add Thousands values in the map
    static String[] oneDigit = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    static String[] twoDigit = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] multiplicationoftens = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] multiplicationoftens2 = new String[]{"", "", "Hundred", "Thousand", "Million", "Billion"};
    Map <Integer, String> ThousandsMap = new HashMap<>();
    
    {
        for (int i = 0; i <= 1001; i++) {
            if(i > 0 && i < 10) {
                ThousandsMap.put(i, oneDigit[i] + " Thousand");
            } else if(i > 9 && i < 20) {
                ThousandsMap.put(i, twoDigit[i - 10] + " Thousand");
            } else if(i > 19 && i < 100) {
                int tens = i / 10;
                int ones = i % 10;
                if(ones == 0) {
                    ThousandsMap.put(i, multiplicationoftens[tens] + " Thousand");
                } else {
                    ThousandsMap.put(i, multiplicationoftens[tens] + " " + oneDigit[ones] + " Thousand");
                }
            } else if(i > 99 && i < 1000) {
                int hundreds = i / 100;
                int rest = i % 100;
                if(rest == 0) {
                    ThousandsMap.put(i, oneDigit[hundreds] + " " + multiplicationoftens2[2] + " Thousand");
                } else {
                    ThousandsMap.put(i, oneDigit[hundreds] + " " + multiplicationoftens2[2] + " " + ThousandsMap.get(rest) );

                }
            }
        }
    }
    Map <Integer, String> MillionsMap = new HashMap<>();
    {
        for(int i = 1; i <= 1000; i++){
            if( i > 0 && i < 10) {
                MillionsMap.put(i, oneDigit[i] + " Million");
            } else if(i > 9 && i < 20) {
                MillionsMap.put(i, twoDigit[i - 10] + " Million");
            } else if(i > 19 && i < 100) {
                int tens = i / 10;
                int ones = i % 10;
                if(ones == 0) {
                    MillionsMap.put(i, multiplicationoftens[tens] + " Million");
                } else {
                    MillionsMap.put(i, multiplicationoftens[tens] + " " + oneDigit[ones] + " Million");
                }
            } else if(i > 99 && i < 1000) {
                int hundreds = i / 100;
                int rest = i % 100;
                if(rest == 0) {
                    MillionsMap.put(i, oneDigit[hundreds] + " " + multiplicationoftens2[2] + " Million");
                } else {
                    MillionsMap.put(i, oneDigit[hundreds] + " " + multiplicationoftens2[2] + " " + MillionsMap.get(rest));

                }
            }
        }
    }
    Map <Integer, String> BillionsMap = new HashMap<>();
    {
        for(int i = 1; i <= 1000; i++){
            if( i > 0 && i < 10) {
                BillionsMap.put(i, oneDigit[i] + " Billion");
            } else if(i > 9 && i < 20) {
                BillionsMap.put(i, twoDigit[i - 10] + " Billion");
            } else if(i > 19 && i < 100) {
                int tens = i / 10;
                int ones = i % 10;
                if(ones == 0) {
                    BillionsMap.put(i, multiplicationoftens[tens] + " Billion");
                } else {
                    BillionsMap.put(i, multiplicationoftens[tens] + " " + oneDigit[ones] + " Billion");
                }
            } else if(i > 99 && i < 1000) {
                int hundreds = i / 100;
                int rest = i % 100;
                if(rest == 0) {
                    BillionsMap.put(i, oneDigit[hundreds] + " " + multiplicationoftens2[2] + " Billion");
                } else {
                    BillionsMap.put(i, oneDigit[hundreds] + " " + multiplicationoftens2[2] + " " + BillionsMap.get(rest) + " Billion");

                }
            }
        }
    }
    Map <Integer, String> Zero = new HashMap<>();
    {
        Zero.put(0, "Zero");
    }
    public String numberToWords(int num) {
        //It should convert the number to english words like "one hundred" or "twelve thousand three hundred and twenty-five"
        //It should return the string
        //change int number into string
        String number = String.valueOf(num);
        
        StringBuilder sb = new StringBuilder();
        int length = number.length();
        //if the number enteres is SOLELY 0 RETURN "Zero"
        if (length == 1) {
            sb.append(oneDigit[Integer.parseInt(number)]);
        } else if (length == 2) {
            if (number.charAt(0) == '1') {
                sb.append(twoDigit[Integer.parseInt(number.substring(1))]);
            } else {
                sb.append(multiplicationoftens[Integer.parseInt(number.substring(0, 1))]);
                if(number.charAt(1) != '0' || number.charAt(1) != '0') {
                    sb.append(" " + oneDigit[Integer.parseInt(number.substring(1))]);
                }
            }
        } else if (length == 3) {
            sb.append(oneDigit[Integer.parseInt(number.substring(0, 1))]);
            sb.append(" ");
            sb.append(multiplicationoftens2[2]);
            if(number.charAt(2) != '0' || number.charAt(1) != '0') {
            sb.append(" ");
            sb.append(numberToWords(Integer.parseInt(number.substring(1))));
            }
        } else if (length == 4) {
            sb.append(oneDigit[Integer.parseInt(number.substring(0, 1))]);
            sb.append(" ");
            sb.append(multiplicationoftens2[3]);
            if(number.charAt(3) != '0' || number.charAt(2) != '0' || number.charAt(1) != '0') {
            sb.append(" ");
            sb.append(numberToWords(Integer.parseInt(number.substring(1))));
            }
        } else if (length == 5) {
            sb.append(ThousandsMap.get(Integer.parseInt(number.substring(0, 2))));
            if(number.charAt(4) != '0' || number.charAt(3) != '0' || number.charAt(2) != '0' || number.charAt(1) != '0') {
            sb.append(" ");
            sb.append(numberToWords(Integer.parseInt(number.substring(2))));
            }
        } else if (length == 6) {
            sb.append(ThousandsMap.get(Integer.parseInt(number.substring(0, 3))));
            if(number.charAt(5) != '0' || number.charAt(4) != '0' || number.charAt(3) != '0' || number.charAt(2) != '0' || number.charAt(1) != '0') {
            sb.append(" ");
            sb.append(numberToWords(Integer.parseInt(number.substring(3))));
            }
        } else if (length == 7) {
            sb.append(MillionsMap.get(Integer.parseInt(number.substring(0, 1))));
            sb.append(" ");
            sb.append(numberToWords(Integer.parseInt(number.substring(1))));
            //if the Word Zero is in the String then it should be removed
            if(sb.toString().contains("Zero")) {
                sb.replace(sb.indexOf("Zero"), sb.indexOf("Zero") + 5, "");
            }
            //delete the last space in the string only if it is empty space
            if(sb.toString().endsWith(" ")) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        else if (length == 8) {
            sb.append(MillionsMap.get(Integer.parseInt(number.substring(0, 2))));
            sb.append(" ");
            sb.append(numberToWords(Integer.parseInt(number.substring(2))));
            //if the Word Zero is in the String then it should be removed
            if(sb.toString().contains("Zero")) {
                sb.replace(sb.indexOf("Zero"), sb.indexOf("Zero") + 5, "");
            }
            //delete the last space in the string only if it is empty space
            if(sb.toString().endsWith(" ")) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        else if (length == 9) {
            sb.append(MillionsMap.get(Integer.parseInt(number.substring(0, 3))));
            sb.append(" ");
            sb.append(numberToWords(Integer.parseInt(number.substring(3))));
            //if the Word Zero is in the String then it should be removed
            if(sb.toString().contains("Zero")) {
                sb.replace(sb.indexOf("Zero"), sb.indexOf("Zero") + 5, "");
            }
            //delete the last space in the string only if it is empty space
            if(sb.toString().endsWith(" ")) {
                sb.deleteCharAt(sb.length() - 1);
            }
        
        }
        else if (length == 10) {
            sb.append(BillionsMap.get(Integer.parseInt(number.substring(0, 1))));
            sb.append(" ");
            sb.append(numberToWords(Integer.parseInt(number.substring(1))));
            //if the Word Zero is in the String then it should be removed
            if(sb.toString().contains("Zero")) {
                sb.replace(sb.indexOf("Zero"), sb.indexOf("Zero") + 5, "");
            }
            //delete the last space in the string only if it is empty space
            if(sb.toString().endsWith(" ")) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        else if (length == 11) {
            sb.append(BillionsMap.get(Integer.parseInt(number.substring(0, 2))));
            sb.append(" ");
            sb.append(numberToWords(Integer.parseInt(number.substring(2))));
            //if the Word Zero is in the String then it should be removed
            if(sb.toString().contains("Zero")) {
                sb.replace(sb.indexOf("Zero"), sb.indexOf("Zero") + 5, "");
            }
            //delete the last space in the string only if it is empty space
            if(sb.toString().endsWith(" ")) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        else if (length == 12) {
            sb.append(BillionsMap.get(Integer.parseInt(number.substring(0, 3))));
            sb.append(" ");
            sb.append(numberToWords(Integer.parseInt(number.substring(3))));
            //if the Word Zero is in the String then it should be removed
            if(sb.toString().contains("Zero")) {
                sb.replace(sb.indexOf("Zero"), sb.indexOf("Zero") + 5, "");
            }
            //delete the last space in the string only if it is empty space
            if(sb.toString().endsWith(" ")) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
        
    public static void main(String[] args) {
        NumberToEnglishWords n = new NumberToEnglishWords();
        //a for loop to test the method
        for(int i = 0; i <Integer.MAX_VALUE; i++) {
            System.out.println(n.numberToWords(i));
        }


    }

}
