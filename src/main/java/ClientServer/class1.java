/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientServer;

/**
 *
 * @author HP
 */
public class class1 {

    private int goal;
    private boolean correct;

    public class1() {
        goal = (int) (Math.random() * 15 + 1);
        correct = false;
    }

    public int getGoal() {
        return goal;
    }

    public boolean getCorrect() {
        return correct;
    }

    public String guess(int guess) {
        if (guess == goal) {
            correct = true;
            return " Correct Answer";
        } else if (guess > goal) {
            return "Too high try another Number";
        } else {
            return "Too low pick more bigger number";
        }
    }
}       
