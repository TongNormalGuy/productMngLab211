

import java.util.Scanner;

public class License {
    public static void main(String[] args) {
        String choice;
        String choice2;
        String choice3;
        
        Scanner sc = new Scanner(System.in);
        Funtion tong = new Funtion();
        eXtendMenu otp = new eXtendMenu();

        do {
            System.out.println("1- print all \n"
                    + "2- creat product \n"
                    + "3- check exist product \n"
                    + "4- search product by name \n"
                    + "5- update product (update or delete) \n"
                    + "6- save file \n"
                    + "7- list from file \n"
                    + "other key to exit\n"
                    + "put choice: ");
                    choice = sc.nextLine();
                        switch (choice) {
                            case "1":
                                tong.printProduct();
                                System.out.println("press any key to return menu.");
                                choice2 = sc.nextLine();
                                sc = new Scanner(System.in);
                                break;
                            case "2":
                                tong.creatProduct();
                                System.out.println("put y to do again, other to return menu.");
                                choice2 = sc.nextLine();
                                if (choice2.matches("y")) tong.creatProduct();
                                else sc = new Scanner(System.in);
                                break;
                            case "3":
                                System.out.println("1 for check by name.\n" + "2 for check by ID.\n" + "other to return.");
                                choice2 = sc.nextLine();
                                switch(choice2){
                                    case "1":
                                        tong.checkExistByName();
                                        System.out.println("put y to do again, other to return menu.");
                                        choice3 = sc.nextLine();
                                        if (choice3.matches("y")) tong.checkExistByName();
                                        else sc = new Scanner(System.in);
                                        break;
                                    case "2":
                                        tong.checkExistByID();
                                        System.out.println("put y to do again, other to return menu.");
                                        choice3 = sc.nextLine();
                                        if (choice3.matches("y")) tong.checkExistByID();
                                        else sc = new Scanner(System.in);
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            case "4":
                                tong.searchNameProd();
                                System.out.println("put y to do again, other to return menu.");
                                choice3 = sc.nextLine();
                                        if (choice3.matches("y")) tong.searchNameProd();
                                        else sc = new Scanner(System.in);
                                break;
                            case "5":
                                System.out.println("1 for update.\n" + "2 for remove.\n" + "other to return.");
                                choice2 = sc.nextLine();
                                switch(choice2){
                                    case "1":
                                        tong.updateProduct();
                                        System.out.println("put y to do again, other to return menu.");
                                        choice3 = sc.nextLine();
                                         if (choice3.matches("y")) tong.updateProduct();
                                        else sc = new Scanner(System.in);
                                        break;
                                    case "2":
                                        tong.removeProduct();
                                        System.out.println("put y to do again, other to return menu.");
                                        choice3 = sc.nextLine();
                                         if (choice3.matches("y")) tong.removeProduct();
                                        else sc = new Scanner(System.in);
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            case "6":
                                tong.saveFile();
                                System.out.println("press y to return menu.");
                                choice2 = sc.nextLine();
                                if (choice2.matches("y"))  sc = new Scanner(System.in);
                                break;
                            case "7":
                                tong.readFile();
                                System.out.println("press any key to return menu.");
                                choice2 = sc.nextLine();
                                sc = new Scanner(System.in);
                                break;
                            default:
                                System.out.println("exit");
                                break;
                        }
                } while (choice.matches("[1-7]"));
            }
    }


