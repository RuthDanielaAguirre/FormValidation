/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import model.exceptions.InvalidDateException;
import model.exceptions.InvalidNifException;

/**
 *
 * @author ruthagulop
 */
public class UserDataValidations {

    public static boolean checkId( String id) throws InvalidNifException {

        if (id.length() != 9) {
            System.out.println("Enter a valid NIF");
        }
      
        String digits = id.substring(0, 8);
        char letra = id.charAt(8);

        int numero = Integer.parseInt(digits);

        int resto = numero % 23;
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        char letraCalculada = letras.charAt(resto);

        if(letraCalculada != letra){
            throw new InvalidNifException("Invalid NIF, it is incorrect.");
        }
        return true;
    }

    public static boolean checkDate(String date) throws InvalidDateException {
        boolean dateOk = false;

         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
           
            LocalDate parsedDate = LocalDate.parse(date, formatter);
            System.out.println("Valid date: " + parsedDate);
            dateOk = true; 
        } catch (DateTimeParseException e) {
            
            throw new InvalidDateException("Invalid date. Please enter in format dd/MM/yyyy");
        }
          return dateOk;  
      }

    public static int calculateAge(String birthday) {
   
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate parsedBirthday = LocalDate.parse(birthday, formatter);
    LocalDate today = LocalDate.now();
    
    int age= Period.between(parsedBirthday, today).getYears();
    
    return age;
    }

    public static boolean checkZipCode(String zip) {
        boolean zipCodeOk = false;
        
        
        
        if(isNumeric(zip)){
            if (zip.length()==5){
            zipCodeOk = true;
            }
            
        }
        return zipCodeOk;
    }

    public static boolean isNumeric(String str) {
        boolean numericOK = true;

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return numericOK = false;
            }
        }

        return numericOK;
    }

    public static boolean isAlphabetic(String str) {
        boolean alphabeticOK = true;
        
        for (char c : str.toCharArray()) {
            if(!Character.isAlphabetic(c)){
            alphabeticOK = false;
            break;
            }
         
        }
        return alphabeticOK;
    }

    public static boolean checkEmail(String email) {
        boolean isCorrect = false;
        
        if(email.contains("@")&& email.contains(".com")) {
        isCorrect = true;
        }
        return isCorrect;
        
        
    }



}
