# 🧾 User Data Validator

Java Swing desktop application that validates personal user data through a visual form.  
It checks fields like name, NIF (Spanish ID), email, birthdate, and zip code, and allows exporting valid entries to a CSV file.

---

## 🖼️ Preview

| ![Form running](assets/ex1.png) | ![Form with errors](assets/ex2.png) |

---

## ✅ Features

- **Name**: accepts only alphabetic characters
- **NIF**: validates format and letter using the official algorithm
- **Email**: checks for proper format (`@... .com`)
- **Birthdate**: validates date format and auto-calculates age
- **Zip Code**: validates 5-digit numeric code
- **Custom Exceptions**:
    - `InvalidNifException`
    - `InvalidDateException`
- **CSV Export**: stores user data into `user_data_RDALL.csv`
- **Built with**: Java Swing and NetBeans GUI Editor

---

## 🧪 Tech Stack

- Java 17+
- NetBeans IDE
- Java Swing
- Git & GitHub

---

## 🚀 How to Run

1. Open the project in **NetBeans**
2. Run the file `JFrameMain.java`
3. Fill in the form fields and click **Validate**
4. If all data is valid, the CSV export button becomes active

---

## 👩‍💻 Author

Developed by **Ruth Daniela Aguirre** as part of module Java and User Interfaces for the **DAM program at Monlau**.

---

## 📬 Feedback or Suggestions?

Feel free to open an issue or fork the repo if you'd like to contribute!
