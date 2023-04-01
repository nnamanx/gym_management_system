package org.management.service.menu;


import org.management.service.UserService;
import org.management.service.UserServiceImpl;

import static org.management.util.Input.*;

public class MenuImpl implements Menu {


    @Override
    public short entryMenu() {
        System.out.println("-----| GYM Management |-----" +
                "\n[0] Exit the system" +
                "\n[1] GYM Registration" +
                "\n[2] Show all members" +
                "\n[3] Enter the GYM" +
                "\n[4] Update departures");

        return inputShort("Choose an option: ");
    }

    @Override
    public void entryOptions(short option) {

        UserService userService = new UserServiceImpl();

//        while (true) {
//        Cases for entry option
        switch (option) {
            case 0:
                System.exit(-1);
                break;
            case 1:
                System.out.println("-----| Registration |-----");
                userService.addUser();
                break;
            case 2:
                System.out.println("-----| Members' List |-----");
                userService.findUsers();
                break;
            case 3:
                System.out.println("-----| Entrance |-----");
                userService.entrance();
                break;
            case 4:
                System.out.println("-----| Updating Departures |-----");
                if (userService.updateDeparture()) {
                    System.out.println("Successful");
                } else System.out.println("Unsuccessful try!");
                break;

            default:
                System.err.println("Invalid option.");
        }
    }


//    }
}

