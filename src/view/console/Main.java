/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.exceptions.InvalidDateException;
import model.exceptions.InvalidNifException;
import model.validations.UserDataValidations;

/**
 *
 * @author ruthagulop
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        sc.useDelimiter("\n");
        String option;
        
        do {
            System.out.println("MENU: ");
            System.out.println("1.- Tester Check ID");
            System.out.println("2.- Tester Check Format Date");
            System.out.println("3.- Tester Calculate Age");
            System.out.println("4.- Tester Check Postal Code");
            System.out.println("5.- Tester Check Is Numeric");
            System.out.println("6.- Tester Check Is Alphabetic");
            System.out.println("7.- Tester Check Email");
            System.out.println("8.- Tester Check Name");
            System.out.println("Z.- Exit");
            
            System.out.print("Opcion: ");
            option = sc.next();
            
            switch (option) {
                case "1":
                    testCheckId();
                    break;
                case "2":
                    testCheckFormatDate();
                    break;
                case "3":
                    testCalculateAge();
                    break;
                case "4":
                    testCheckPostalCode();
                    break;
                case "5":
                    testCheckIsNumeric();
                    break;
                case "6":
                    testCheckIsAlphabetic();
                    break;
                case "7":
                    testCheckEmail();
                    break;
                case "8":
                    testCheckName();
                    break;
                case "Z":
                    System.out.println("Have a nice day! ");
                    break;
                default:
                    System.out.println("Incorrect option");
            }
        
        } while (!option.equals("Z"));
    }
    
    
    static void testCheckId(){
        try {
            System.out.println("NIF VALIDATOR");
            System.out.println("Enter your ID");
            
            //Agui utiliza el length para mirar que sean 9 caracteres y coge el ultimo char
            //para ver que sea una letra mientas hace un substring de la posición 0 toma 8 caracteres y pide
            //el resto de dividido entre 23
            
            String nif = sc.next();
            boolean idOk = UserDataValidations.checkId( nif);
            if(idOk){
                System.out.println("Correct ID");
            }
        } catch (InvalidNifException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
            
    }
    
    static void testCheckFormatDate(){
        try {
            System.out.println("\nDate Validator");
            System.out.println("\nEnter the Date");
            
            //checkdate lo que hace es crear un formato para la fecha y luego le da formato
            
            String date = sc.next().replaceAll(" ", "");
            
            boolean dateOk = UserDataValidations.checkDate(date);
            
            if(dateOk){
                System.out.println("\nCorrect Date");
            }
        } catch (InvalidDateException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    
    }
    
    static void testCalculateAge(){
        try {
            System.out.println("Enter your birthday: ");
            String birthday = sc.next().trim();
            
            //calculateAge hace varias utiliza checkdate no solo para darle formato
            //y parsear el string, utiliza la fecha de hoy con LocalDAte y también utiliza period.between para que podamos
            //pedirle los años que hay entre estas fechas
            
            boolean birthdayOk = UserDataValidations.checkDate(birthday);
            int birthdayNum = UserDataValidations.calculateAge(birthday);
            
            if(birthdayOk){
                System.out.println("Your age is: " + birthdayNum);
            }else{
                System.out.println("Enter a valid date");
            }
        } catch (InvalidDateException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    
    
    }
    
    static void testCheckPostalCode(){
        System.out.println("Enter your ZipCode: ");
        String zip = sc.next();
        
        //esta función utiliza isNumeric para verificar que lo que el usuario nos 
        //de sean numeros y que la longitud sea igual a 5
        
        boolean zipCodeOk = UserDataValidations.checkZipCode(zip);
        
        if(zipCodeOk){
            System.out.println("The ZipCode is correct");
        }else{
            System.out.println("Enter a correct ZipCode");
        }
    
    
    }
    
    static void testCheckIsNumeric(){
        System.out.println("Enter numbers: ");
        String phrase = sc.next();
        
        //isNumeric es un método que mira char por char si es un numero
        //utliza isDigit por detras
        
        boolean numericOK = UserDataValidations.isNumeric(phrase);
        
        if(numericOK){
            System.out.println("These are numbers");
        }else{
            System.out.println("These are not numbers");
        }
    
    }
    
    static void testCheckIsAlphabetic(){
        //is alphabetic es un metodo que ve por cada char si es una letra
          System.out.println("Enter letters: ");
        String phrase = sc.next();
        
        boolean alphabeticOK = UserDataValidations.isAlphabetic(phrase);
        
        if(alphabeticOK){
            System.out.println("These are words");
        }else{
            System.out.println("These are not words");
        }
    }
    
    static void testCheckEmail(){
        //contains es un metodo que "busca" si existe en el string
        
        System.out.println("Enter your email: ");
        String email = sc.next();
        
        boolean isCorrect = UserDataValidations.checkEmail(email);
        
        
              if(isCorrect){
            System.out.println("This is an email");
        }else{
            System.out.println("This is not an email");
        }
    
    }
    //aquí voy a reutilizar isAlphabetic porque lo que mira son es char por char
    static void testCheckName(){
        System.out.println("Enter your name: ");
    String name = sc.next();
    
    boolean nameOk = UserDataValidations.isAlphabetic(name);
    
    if(nameOk){
        System.out.println("This is a name");
    }else{
        System.out.println("This is not a name");
    }
    }
    
    
   static void mealPlanner() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Meal Planner!\n");
        System.out.print("Enter the number of croissants you want to eat: ");
        int croissants = scanner.nextInt();

        int croissantCalories = 230;
        int totalCalories = croissants * croissantCalories;

        System.out.println("\nHealthy meal suggestions:");
        System.out.println("1. Croissants with Greek yogurt and berries");
        System.out.println("2. Croissants with scrambled egg whites and avocado");
        System.out.println("3. Croissants with cottage cheese and nuts");

        System.out.println("\nEstimated calorie intake: " + totalCalories + " kcal");

        if (totalCalories > 500) {
            System.out.println("Consider reducing the number of croissants or adding more proteins and fibers.");
        } else {
            System.out.println("Great choice! Keep balancing your meals.");
        }
        
        scanner.close();
    }

}
    
    
   
    
 
    

