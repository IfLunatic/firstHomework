package patterns.task.HTML;

import patterns.task.Customer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateHTMLFile {
    public static void createHtml(Customer customer) {
        // Шлях до нового файлу HTML
        String filePath = "index.html";

        // Створення файлу HTML
        File htmlFile = new File(filePath);

        try {
            FileWriter writer = new FileWriter(htmlFile);

            writer.write("<html>\n" +
                    "<head>\n" +
                    "<title>Example HTML File</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h1>" + customer.statement() + "</h1>\n" +
                    "</body>\n" +
                    "</html>");
        writer.close();
            System.out.println("HTML file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
