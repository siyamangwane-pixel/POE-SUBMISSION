/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe2;

/**
 *
 * @author mangwane
 */

import java.util.Scanner;

public class POE2{
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login auth = new Login();

        System.out.println("<<<<Registration>>>>>");

        // First Name and Last Name
        System.out.print("First Name: ");
        String fn= input.nextLine();

        System.out.print("Last Name: ");
        String ln = input.nextLine();

        // Username validation loop
        String username;
        while (true) {
            System.out.print("Username: ");
            username = input.nextLine();
            if (auth.checkUserName(username)) {
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted. "
                        + "It must contain an underscore and be no more than 5 characters long.");
            }
        }

        // Password validation
        String password;
        while (true) {
            System.out.print("Password: ");
            password = input.nextLine();
            if (auth.checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted. "
                        + "It must be at least 8 characters long and include a capital letter, "
                        + "a number, and a special character.");
            }
        }

        // Phone number validation loop
        String phone;
        while (true) {
            System.out.print("Phone (+27): ");
            phone = input.nextLine();
            if (auth.checkCellphoneNumber(phone)) {
                System.out.println("Cell phone number successfully captured.");
                break;
            } else {
                System.out.println("Cell phone number incorrectly formatted. "
                        + "It must start with +27 followed by 9 digits (e.g., +27831234567).");
            }
        }

        // Register the user after successful validations
        System.out.println(auth.registerUser(username, password, phone, fn, ln));

        // -------------------- LOGIN SECTION --------------------
        System.out.println("\n--- Login ---");
        boolean success = false;
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;

        while (!success && attempts < MAX_ATTEMPTS) {
    System.out.print("Username: ");
    String lUser = input.nextLine();

    System.out.print("Password: ");
    String lPass = input.nextLine();

    success = auth.loginUser(lUser, lPass);
    System.out.println(auth.returnLoginStatus(success));
    attempts++;

    if (!success && attempts < MAX_ATTEMPTS) {
        System.out.println("Attempts remaining: " + (MAX_ATTEMPTS - attempts));
    }
}

if (!success) {
    System.out.println("Too many failed login attempts. Access denied.");
}
        input.close();
    }
}