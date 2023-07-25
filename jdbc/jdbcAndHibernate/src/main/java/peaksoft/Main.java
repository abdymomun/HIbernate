package peaksoft;

import peaksoft.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl service = new UserServiceImpl();

            //service.saveUser("Adbymomun","Akunov",(byte) 18);
            //System.out.println(service.getAllUsers());
//        service.cleanUsersTable();
//        service.removeUserById(1L);
       service.dropUsersTable();
        }
    }

