package htmldemo;

import java.io.InputStream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class demo {
    public static void main(String[] args) {
        try (InputStream input = demo.class.getClassLoader().getResourceAsStream("HTML/demo.html")) {
            if (input == null) {
                System.out.println("demo.html file not found");
                return;
            }

            // Parse HTML file using Jsoup
            Document doc = Jsoup.parse(input, "UTF-8", "");

            // Extract values
            String firstname = doc.select("p:contains(firstname)").text().replace("firstname: ", "");
            String lastname = doc.select("p:contains(lastname)").text().replace("lastname: ", "");

            // Output
            System.out.println("First name: " + firstname);
            System.out.println("Last name: " + lastname);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

