package org.ironhack;

import org.ironhack.enums.Day;
import org.ironhack.classes.Role;
import org.ironhack.enums.User;

public class App {
    public static void main(String[] args) {
        Day today = Day.SATURDAY;

        if (today == Day.TUESDAY || today == Day.SATURDAY){
            System.out.println("We have back-end class today!");
        } else {
            System.out.println("Practice some Java");
        }

        User user = new User(91, "Lorenzo", "password", Role.ADMIN);
        System.out.println(user.getUserRole());
    }
}
