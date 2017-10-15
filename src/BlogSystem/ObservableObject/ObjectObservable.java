package BlogSystem.ObservableObject;

public class ObjectObservable extends java.util.Observable
{
    //Vars
    private String comments;
    private String userName;
    private String title;

    public String getTitle()
	{return title;}

    public String getUserName()
    {
        return userName;
    }

    public String getComments()
    {
        return comments;
    }

    public void setComments(String title ,String comments, String userName)
    {
        this.title = title;
        this.comments = comments;
        this.userName = userName;
        setChanged();
    }

}
