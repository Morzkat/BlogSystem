package BlogSystem.Observes;

import BlogSystem.ObservableObject.ObjectObservable;
import BlogSystem.SaveComments;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class TextObserver implements Observer
{
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();

    @Override
    public void update(Observable observableObject, Object ob)
    {
        System.out.println(" Titulo del Post " + ((ObjectObservable)observableObject).getTitle() +
                " Cuerpo del Post: " + ((ObjectObservable)observableObject).getComments() +
                " Usuario: " + ((ObjectObservable)observableObject).getUserName() +
                "Publicado el: " + date);

    }
}
