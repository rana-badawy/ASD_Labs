import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ProductMgmtApp {
    public static void printProducts(ArrayList<Product> products) {
        products.sort((p1, p2) -> {return p2.getUnitPrice() > p1.getUnitPrice()? 1 : -1;});

        System.out.println("JSON Format:");
        System.out.println("[");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println("  {");
            System.out.println("    \"productId\": \"" + p.getProductId() + "\",");
            System.out.println("    \"name\": \"" + p.getName() + "\",");
            System.out.println("    \"dateSupplied\": \"" + new SimpleDateFormat("yyyy-MM-dd").format(p.getDateSupplied()) + "\",");
            System.out.println("    \"quantityInStock\": " + p.getQuantityInStock() + ",");
            System.out.println("    \"unitPrice\": " + p.getUnitPrice());
            System.out.print("  }");
            if (i < products.size() - 1) System.out.println(",");
            else System.out.println();
        }
        System.out.println("]");

        System.out.println("\n==========================================");
        System.out.println("\nXML Format:");
        System.out.println("<Products>");
        for (Product p : products) {
            System.out.println("  <Product>");
            System.out.println("    <ProductId>" + p.getProductId() + "</ProductId>");
            System.out.println("    <Name>" + p.getName() + "</Name>");
            System.out.println("    <DateSupplied>" + new SimpleDateFormat("yyyy-MM-dd").format(p.getDateSupplied()) + "</DateSupplied>");
            System.out.println("    <QuantityInStock>" + p.getQuantityInStock() + "</QuantityInStock>");
            System.out.println("    <UnitPrice>" + p.getUnitPrice() + "</UnitPrice>");
            System.out.println("  </Product>");
        }
        System.out.println("</Products>");


        System.out.println("\n==========================================");
        System.out.println("\nCSV Format:");
        System.out.println("Product ID, Name, Date Supplied, Quantity In Stock, Unit Price");
        for (Product p : products) {
            System.out.printf("%s, %s, %s, %d, %.2f%n",
                    p.getProductId(),
                    p.getName(),
                    new SimpleDateFormat("yyyy-MM-dd").format(p.getDateSupplied()),
                    p.getQuantityInStock(),
                    p.getUnitPrice()
            );
        }
    }

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            products.add(new Product("3128874119", "Banana", dateFormat.parse("2023-01-24"), 124, 0.55));
            products.add(new Product("2927458265", "Apple", dateFormat.parse("2022-12-09"), 18, 1.09));
            products.add(new Product("9189927460", "Carrot", dateFormat.parse("2023-03-31"), 89, 2.99));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        printProducts(products);
    }
}