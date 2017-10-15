package BlogSystem.Observes;

import java.util.Observable;
import BlogSystem.ObservableObject.ObjectObservable;
import BlogSystem.SaveComments;

import javax.swing.*;
import java.util.Observer;

public class GraphicObserver implements Observer
{
    private SaveComments sv = new SaveComments();
    private String nameFile = "DataBase.txt";
    private String r = sv.readerFile(nameFile);

    public String getNameFile()
    {
        return nameFile;
    }

    public void setNameFile(String nameFile)
    {
        this.nameFile = nameFile;
    }

    @Override
    public void update(Observable observableObject, Object arg)
    {
        sv.printCaps(((ObjectObservable)observableObject).getUserName(),
                ((ObjectObservable)observableObject).getTitle(),
                ((ObjectObservable)observableObject).getComments(),
                nameFile);

        JOptionPane.showMessageDialog(null,"El post a sido publicado");

    }

    public String getPost()
    {
        r = sv.readerFile(nameFile);

        return r;
    }

}
