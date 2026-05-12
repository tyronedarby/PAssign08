# Secure Vault System (JavaFX)

A sophisticated security vault simulation built with **JavaFX**. This application replicates a digital safe door, featuring an LCD status display, a custom keypad with event-driven logic, and password validation.

## 🔒 Features

* **LCD Status Screen:** A stylized "retro" display using `Courier New` font and dynamic colors (Lime, Yellow, Cyan, Red) to indicate system states.
* **Password Masking:** Inputs are visually masked with asterisks (`*`) to maintain security, just like a real vault.
* **Custom Keypad Logic:** * **Numbers 0-9:** Input code entry.
* **Asterisk (*):** Resets the current input attempt.
* **Pound (#):** Submits the code for validation.


* **Advanced UI Design:** Implements a dark-themed door layout with a safe handle graphic and thick borders to simulate a heavy vault door.

## 🚀 Logic Overview

The system is hardcoded with a default master code (`1234`).

* **Success:** The display turns **Cyan** and shows `UNLOCK`.
* **Failure:** The display turns **Red** and shows `ACCESS DENIED`.
* **Reset:** The display turns **Yellow** and clears the buffer.

## 🛠️ Technical Implementation

* **Inheritance:** Extends a base `KeyPadPane` class to reuse button layouts while overriding event handlers for specific vault logic.
* **Event Handling:** Uses a centralized loop to register listeners across all 12 buttons.
* **Layout Management:** Utilizes nested `VBox` and `HBox` containers with CSS-style padding and background colors.

## 📂 Files

* `PAssign08.java`: Contains the `SafeKeypad` inner class and the main application setup.

## ⚙️ How to Run

1. **Ensure JavaFX is configured** in your IDE or via command line.
2. **Compile:**
```bash
javac --module-path /path/to/javafx/lib --add-modules javafx.controls PAssign08.java

```


3. **Run:**
```bash
java --module-path /path/to/javafx/lib --add-modules javafx.controls PAssign08

```



## 📝 Project Details

**Author:** [Tyrone Darby](https://www.google.com/search?q=https://github.com/tyronedarby)

**Class:** 1302

**Created:** April 18, 2026

---

