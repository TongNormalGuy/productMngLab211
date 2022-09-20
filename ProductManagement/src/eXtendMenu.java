
import java.util.Scanner;

public class eXtendMenu {

    boolean count = false;
    int select;
    String hnd;
    
    
    Scanner xm = new Scanner(System.in);
    Funtion funn = new Funtion();
    
    //check exist file
    public void checkExitOption() {
        System.out.println("1 for check exist by name.\n"
                + "2 for check exist by ID.\n"
                + "other to return main menu.\n"
                + "put your choice: ");

        do {
            try {
                select = xm.nextInt();
                if (select < 0 || select > 2) {
                    System.out.println("wrong input, put again.");
                    throw new Exception();
                } else {
                    switch (select) {
                        case 1:
                            funn.checkExistByName();
                            break;
                        case 2:
                            funn.checkExistByID();
                            break;
                        default:
                            break;
                    }
                    count = false;
                }
            } catch (Exception e) {
                count = true;
            }
        } while (count == true);

    }
    
    public void returnMenu(){
        
    }
    
    //update file
    public void modifyProd() {
        System.out.println("1 for update product by ID.\n"
                + "2 for delete product by ID.\n"
                + "other to return main menu.\n"
                + "put your choice: ");
        do {
            try {

                select = xm.nextInt();
                if (select < 0 || select > 2) {
                    System.out.println("wrong input, put again.");
                    throw new Exception();
                } else {
                    switch (select) {
                        case 1:
                            funn.updateProduct();
                            break;
                        case 2:
                            funn.removeProduct();
                            break;
                        default:
                            break;
                    }
                    count = false;
                }
            } catch (Exception e) {
                count = true;
            }
        } while (count == true);

    }
    
    
    
    //list product from file , this funtion will read file and print
//    public void listProdFromFile(){
//         
//             
//         
//    }
    
}
