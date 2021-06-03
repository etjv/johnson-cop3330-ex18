/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Edmund Johnson V
 */

/*
You’ll often need to determine which part of a program is run based on user input or other events.

Create a program that converts temperatures from Fahrenheit to Celsius or from Celsius to Fahrenheit. Prompt for the starting temperature. The program should prompt for the type of conversion and then perform the conversion.

The formulas are

C = (F − 32) × 5 / 9
and

F = (C × 9 / 5) + 32
Example Output
Press C to convert from Fahrenheit to Celsius.
Press F to convert from Celsius to Fahrenheit.
Your choice: C
Please enter the temperature in Fahrenheit: 32
The temperature in Celsius is 0.

Constraints
Ensure that you allow upper or lowercase values for C and F.
Use as few output statements as possible and avoid repeating output strings.
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] arg){
        int type = getType();
        float temp = getTemp(type);
        System.out.println(output(type, temp));
    }

    private static int getType(){
        System.out.println("Press C to convert from Fahrenheit to Celsius.");
        System.out.println("Press F to convert from Celsius to Fahrenheit.");
        String x = in.nextLine();

        if(x.equals("F") || x.equals("f")){
            return 1;
        }
        else if(x.equals("C") || x.equals("c")){
            return 0;
        }
        else{
            System.out.println("Enter a valid input (F/f/C/c).");
            return getType();
        }
    }

    private static float getTemp(int type){
        if(type == 1){
            System.out.print("Please enter the temperature in Fahrenheit: ");
            String x = in.nextLine();
            return Float.parseFloat(x.replace(" ", ""));
        }
        else{
            System.out.print("Please enter the temperature in Celsius: ");
            String x = in.nextLine();
            return Float.parseFloat(x.replace(" ", ""));
        }
    }

    private static String output(int type, float temp){
        double n;
        DecimalFormat d = new DecimalFormat("#.##");
        if(type == 1){
            n = (temp - 32) * 5 / 9;
            return "The temperature in Celsius is " + d.format(n) + ".";
        }
        else{
            n = (temp * 9 / 5) + 32;
            return "The temperature in Fahrenheit is " + d.format(n) + ".";
        }
    }
}
