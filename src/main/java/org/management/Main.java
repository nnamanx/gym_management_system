package org.management;

import org.management.service.menu.Menu;
import org.management.service.menu.MenuImpl;

public class Main {
    public static void main(String[] args) {
        Menu menu = new MenuImpl();

        while(true) {

            menu.entryOptions(menu.entryMenu());
        }
    }
}