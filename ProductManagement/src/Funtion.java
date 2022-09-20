
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Funtion {
    /*
    almost problem are solved
     */
    private String productID;
    private String productName;
    private float unitPrice;
    private String status;
    private int quantity;

    ArrayList<Product> listProducts = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    boolean flagg = false;
    boolean check = false;

    //list or print all here
    public void printProduct() {
        if (listProducts.isEmpty()) {
            System.out.println("nothing here! please add product or read the file."
                    + "\n--------------------");
        } else sortProd();
        for (int i = 0; i < listProducts.size(); i++) {
            System.out.println(listProducts.get(i));
        }
    }

    // sort product descending
    public void sortProd() {
        Collections.sort(listProducts, (Product s1, Product s2) -> {
            if (s1.getQuantity() == s2.getQuantity()) {
                if (s1.getUnitPrice() - s2.getUnitPrice() >0) {
                    return 0;
                } else if(s1.getUnitPrice() - s2.getUnitPrice() <0){
                    return -1;
                }else return 0;
            } else {
                return s2.getQuantity() - s1.getQuantity();
            }
        });
    }

    // creat product here FUNTION 1
    public void creatProduct() {
        //// product Name here
        do {
            //check empty, blank
            System.out.println("(please have at least 5 char and do not let it empty)\n"
                    + "please put product name: "
            );
            productName = sc.nextLine();
            if (productName.isEmpty() || productName.length() <5) {
                System.out.println("please do not let it empty or lower 5.");
                productName = "";
            }
            
            //check space in string name
            for (int i = 0; i < productName.length(); i++) {
                if (productName.charAt(i) == ' ') {
                    System.out.println("dont let space in name");
                    productName = "";
                }
            }
            // check duplicate
            for (int i = 0; i < listProducts.size(); i++) {
                if (listProducts.get(i).getProductName().matches(productName)) {
                    System.out.println("the product name has exited.");
                    productName = "";
                }
            }
        } while (productName.isEmpty());

        ////product ID here
        do {
            System.out.println("(format Pxxx when x is digit and do not let it empty)\n"
                    + "please put product ID :"
            );
            productID = sc.nextLine();
            //product ID format
            if (productID.isEmpty()) {
                System.out.println("please do not let it empty.");
            } else if (!productID.matches("P\\d{4}")) {
                System.out.println("Wrong format");
                productID = "";
            }
            //check space in string ID
            for (int i = 0; i < productID.length(); i++) {
                if (productID.charAt(i) == ' ') {
                    productID = "";
                }
            }
            // check duplicate
            for (int i = 0; i < listProducts.size(); i++) {
                if (listProducts.get(i).getProductID().matches(productID)) {
                    System.out.println("the product ID has exited.");
                    productID = "";
                }
            }
        } while (productID.isEmpty());

        //// unit Price here 
        do {
            try {
            System.out.println("(please put REAL NUMBER 0-10.000 and do not let it empty)"
                    + "\nplease put unit price here: ");
            unitPrice = Float.parseFloat(sc.nextLine()); // check is number
            flagg = false;
            //check the price input is follow 0 to 10.000 and it is real number 
            if (unitPrice < 0 || unitPrice > 10000 /* || unitPrice != '\n' */) {
                System.out.println("please put REAL NUMBER from 0-10.000 and do not let it empty");
                flagg = true;
            }
            } catch (Exception e) {
                System.out.println("please put number.");
                flagg = true;
            }
        } while (flagg == true);

        //// quantity here
        do {
            try {
            System.out.println("(please put INTEGER NUMBER 0-1000 and do not let it empty)"
                    + "\nplease put quantity number here: ");
            quantity = Integer.parseInt(sc.nextLine());
            flagg = false;
            //check quantity input is follow 0 to 10.000 and it is integer number
            if (quantity < 0 || quantity > 1000 /* || quantity != '\n' */) {
                System.out.println("please put INTEGER NUMBER 0-1000 and do not let it empty");
                flagg = true;
            }
            } catch (Exception e) {
                System.out.println("please put number.");
                flagg = true;
            }
        } while (flagg);

        //// status here
        do {
            System.out.println("please put status here A(available) or N(not available): "
                    + "\n(not empty end please follow the format)");
            sc = new Scanner(System.in);
            status = sc.nextLine().toUpperCase();
            //check empty
            if (status.isEmpty()) {
                System.out.println("can not be empty");
            } // check follow format A or N
            //            else if (!status.matches("a") || !status.matches("n") || !status.matches("A") || !status.matches("N")){
            else if (!"A".equals(status) && !"N".equals(status)) {
                System.out.println("please put A(available) or N(not available)");
                status = "";
            }
        } while (status.isEmpty());

        /// add product to product list
        Product obj = new Product(productName, productID, unitPrice, status, quantity);
        listProducts.add(obj);
        System.out.println("add done."
                + "\n--------------------");
    }

    // file creat and check exist file, refer from w3school 
    public void checkCreFile() {
        try {
            File creFile = new File("Product.txt");
            //creat file if file not exist
            if (creFile.createNewFile()) {
                System.out.println("success: " + creFile.getName()
                        + "\n--------------------");
            } //check if file exist
            else {
                System.out.println("exist product");
            }
        } catch (IOException e) {
            //System.out.println("erro, product existed or mistake");
        }
    }

    // read file here FUNTION 2
    public void readFile() {
        try {
            FileReader fr = new FileReader("Product.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                //chỗ này nguy hiểm nếu user chỉnh sửa thông tin trong file hk đạt chuẩn
                String[] text = line.split(", ");
                productName = text[0];
                productID = text[1];
                unitPrice = Float.parseFloat(text[2]);
                status = text[3];
                quantity = Integer.parseInt(text[4]);

                flagg = true;
                for (int i = 0; i < listProducts.size(); i++) {
                    if (text[1].equals(listProducts.get(i).getProductID())) {
                        flagg = false;
                    }
                }
                if (flagg) {
//                    Product obj = new Product(productName, productID, unitPrice, status, quantity);
//                    listProducts.add(obj);
                    listProducts.add(new Product(productName, productID, unitPrice, status, quantity));
                }
                
                 
            }
            if (flagg) {
            System.out.println("read file success.");
            }
            // nên đặt điều kiện ở đầu ?!
            else if (listProducts.isEmpty()) {
                System.out.println("nothing here.");
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    //save or write file here FUNTION 5
    public void saveFile() {
        
        try {
            if (listProducts.size() == 0) {
                System.out.println("nothing to save.");
                throw new IOException();
            }
            FileWriter fw = new FileWriter("Product.txt");
//            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(fw); // cach khac
            for (int i = 0; i < listProducts.size(); i++) {
//                bw.newLine();// loi o day
//              co the dung file println()
                pw.println(listProducts.get(i).toString());
//                bw.write(listProducts.get(i).toString());
//                bw.newLine();
            }
            pw.close();
//            bw.close();
            System.out.println("save success.");
        } catch (IOException ex) {
            System.out.println("save faile.");
            System.out.println("\n--------------------");
        }
    }

    //search Name product here FUNTION 3
    public void searchNameProd() {
        
        System.out.println("search product by name: ");
        productName = sc.nextLine();
        flagg = true;
        if (listProducts.isEmpty()) {
            System.out.println("nothing.");
        }else
        for (int i = 0; i < listProducts.size(); i++) {
//            if (listProducts.size() == 0) break; // nên để cái này ở đầu
            //if user enter a part of name 
            if (listProducts.get(i).getProductName().contains(productName)) {
                System.out.println("product name = " + productName
                        + " - product name result is shown as: "
                        + listProducts.get(i)
                        + "\n--------------------");
                flagg = false;
            } // if user enter full product Name (for extend, not performance)
            else if (listProducts.get(i).getProductName().matches(productName)) {
                System.out.println("product name = "
                        + productName
                        + " - product name result is shown as: "
                        + listProducts.get(i)
                        + "\n--------------------");
                flagg = false;
            }

        }
        if (flagg == true) {
            System.out.println("have no any product.");
            System.out.println("--------------------");
        }
    }

    //update product here FUNTION 4.1
    public void updateProduct() {
        boolean knock = true;
        // update product
        if (listProducts.isEmpty()) {
            System.out.println("nothing to do.");
        }else
        System.out.println("update product by ID: ");
        productID = sc.nextLine();
        for (int i = 0; i < listProducts.size(); i++) {
//            if (listProducts.size() == 0) break; 
            if (productID.matches(listProducts.get(i).getProductID())) {
                //// product NAME
                do {
                    System.out.println("(please have at least 5 char and do not let it empty)\n"
                            + "please put product name: ");
                    productName = sc.nextLine();
                    if (productName.isEmpty() || productName.length() <5) { // check blank
                        System.out.println("please do not let it empty or lower 5.");
                        productName = "";
                    }
                    for (int j = 0; j < productName.length(); j++) { // check space
                        if (productName.charAt(i) == ' ') {
                            System.out.println("dont let space in name. ");
                            productName = "";
                        }
                    }
                    for (int d = 0; d < listProducts.size(); d++) { // check duplicate
                        if (listProducts.get(i).getProductName().matches(productName)) {
                            System.out.println("the product name has exited.");
                            productName = "";
                        }
                    }
                } while (productName.isEmpty());
                //// unit PRICE here 
                do {
                    try {
                    System.out.println("(please put REAL NUMBER 0-10.000 and do not let it empty)"
                            + "\nplease put unit price here: "
                    );
                    unitPrice = Float.parseFloat(sc.nextLine());
                    flagg = false;
                    if (unitPrice < 0 || unitPrice > 10000 /* || unitPrice != '\n' */) { // check requirement
                        System.out.println("please put REAL NUMBER from 0-10.000 and do not let it empty");
                        flagg = true;
                    }
                    } catch (Exception e) {
                        System.out.println("please put number.");
                        flagg = true;
                    }
                } while (flagg == true);
                //// QUANTITY here
                do {
                    try {
                    System.out.println("(please put INTEGER NUMBER 0-1000 and do not let it empty)"
                            + "\nplease put quantity number here: ");
                    quantity = Integer.parseInt(sc.nextLine());
                    flagg = false;
                    if (quantity < 0 || quantity > 1000 /* || quantity != '\n' */) { //check requirement
                        System.out.println("please put INTEGER NUMBER 0-1000 and do not let it empty");
                        flagg = true;
                    }
                    } catch (Exception e) {
                        System.out.println("please put number.");
                        flagg = true;
                    }
                } while (flagg);
                //// STATUS here
                do {
                    System.out.println("please put status here A(available) or N(not available): "
                            + "\n(not empty end please follow the format)");
                    sc = new Scanner(System.in);
                    status = sc.nextLine().toUpperCase();
                    if (status.isEmpty()) { //check empty
                        System.out.println("can not be empty");
                    } // check follow format A or N
                    // else if (!status.matches("A") && !status.matches("N")){
                    else if (!"A".equals(status) && !"N".equals(status) /*status != "A" || status != "N"*/) {
                        System.out.println("please put A(available) or N(not available)");
                        status = "";
                    }
                } while (status.isEmpty());

                /// update product to product list
                Product obj = new Product(productName, productID, unitPrice, status, quantity);
                listProducts.set(i, obj);
                System.out.println("done.\n--------------------");
                knock = false;
            }
        }
        if (knock == true) {
            System.out.println("Not found or no any product.");
        }
    }

    //delete or remove product FUNTION 4.2
    public void removeProduct() {
        if (listProducts.isEmpty()) {
            System.out.println("nothing.");
        } else
        System.out.println("remove product by ID: ");
        productID = sc.nextLine();
        flagg = true;
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getProductID().matches(productID)) {
                listProducts.remove(i);
                System.out.println("remove done."
                        + "\n--------------------");
                flagg = false;
            }
        }
        if (flagg == true) {
            System.out.println("not found");
        }
    }

    //check exist product by name
    public void checkExistByName() {
        readFile();
        if (listProducts.isEmpty()) {
            System.out.println("nothing");
        } else
        do {
            System.out.println("please put product name: ");
            productName = sc.nextLine();
            if (productName.isEmpty()) {
                System.out.println("cannot be blank");
            }
            for (int i = 0; i < listProducts.size(); i++) {
                if (listProducts.get(i).getProductName().matches(productName)) {
                    System.out.println("exist\n--------------------");
                    flagg = false;
                }
            }
            if (flagg == true) {
                System.out.println("not exist.");
            }
        } while (productName.isEmpty());
    }

    //check exist product by ID
    public void checkExistByID() {
        readFile();
        if (listProducts.size() == 0) { 
                System.out.println("nothing.");}
        else
        do {        
            
            flagg = true;
            System.out.println("pleae put product ID: ");
            productID = sc.nextLine();
            if (productID.isEmpty()) {
                System.out.println("cannot be blank");
            }
            if (!productID.matches("P\\d{4}")) {
                System.out.println("wrong format, put again.");
                productID = "";
                flagg = false;
            }
            for (int i = 0; i < listProducts.size(); i++) {
                if (listProducts.get(i).getProductID().matches(productID)) {
                    System.out.println("exit\n--------------------");
                    flagg = false;
                }
            }
            if (flagg == true) {
                System.out.println("ID not exist.");
            }
        } while (productID.isEmpty());
    }
}
