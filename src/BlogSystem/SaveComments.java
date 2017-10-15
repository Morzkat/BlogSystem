package BlogSystem;


import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SaveComments
{

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate localDate = LocalDate.now();

    public void printCaps(String userName, String title, String comment, String fileName)
    {
        try
        {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));
            writer.write(" Titulo del Post: " + title + "\n");

            writer.write(System.getProperty("line.separator"));
            writer.write("Cuerpo del Post: " + comment + "\n");

            writer.write(System.getProperty("line.separator"));
            writer.write("publicado por: " + userName + "\n");

            writer.write(System.getProperty("line.separator"));
            writer.write("publicado el: " + dtf.format(localDate) + "\n");

            writer.write(System.getProperty("line.separator"));
            writer.write
            (
                "------------------------------------------------------------------------------------------" +
                 "--------------------------------------------------------------------------------------------" +
                 "--------------------------------------------------------------------------------------------"
            );

            writer.write(System.getProperty("line.separator"));
            writer.flush();
            writer.close();
        }

        catch (IOException e)
        {
            System.err.println(e + "Error al crear el archivo");
        }
    }

    public String readerFile(String fileName)
    {
        StringBuilder sb = new StringBuilder();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String ln = "";
            while( (ln = reader.readLine()) != null)
            {
                sb.append(ln).append("\n \r");
            }
        }
        catch ( IOException i)
        {
            System.err.println(i);
        }

        return sb.toString();
    }

}
