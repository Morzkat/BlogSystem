//Owner Package
package BlogSystem;

//packages
import BlogSystem.ObservableObject.ObjectObservable;
import BlogSystem.Observes.GraphicObserver;
import BlogSystem.Observes.TextObserver;

//Java Swing
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

//Java awt
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener
{

    //vars and objects

    //Observable Object
    ObjectObservable observableObjet = new ObjectObservable();

    //Observers
    GraphicObserver graphicObserver = new GraphicObserver();
    TextObserver textObserver = new TextObserver();

    //User
    String userName;

    //jpanels user and comments
    JPanel mainPanel = new JPanel();
    JPanel userPanel = new JPanel();
    JPanel commentsPanel = new JPanel();

    //Body of the post
    //buttons and text
    JButton btnComment = new JButton();

    JLabel lblTitle = new JLabel("Titulo");
    JLabel lblComment = new JLabel("Cuerpo del Posr");

    JTextField txtTitle = new JTextField(35);
    JTextArea txtBodyPost = new JTextArea(5,35);

    JScrollPane jscroll = new JScrollPane(txtBodyPost, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    //show comments
    JTextArea txtComments = new JTextArea();
    JScrollPane jscrollComments = new JScrollPane(txtComments, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    public Main()
    {
        String name = JOptionPane.showInputDialog(null,"nombre: ");

        if (!name.equals(""))
        {
         int chose = JOptionPane.showConfirmDialog(null,"Si (los post seran privados) No (los post seran publicos)");

            setUserName(name);

            //settings Jfame

            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setResizable(true);

            //
            mainPanel.setLayout(new BorderLayout());
            mainPanel.add(userPanel, BorderLayout.PAGE_START);
            mainPanel.add(commentsPanel, BorderLayout.CENTER);

            //adding objects to jframe
            add(mainPanel);

            //Adding Observer
            observableObjet.addObserver(graphicObserver);
            observableObjet.addObserver(textObserver);

            txtBodyPost.setLineWrap(true);
            txtBodyPost.setWrapStyleWord(true);

            //vars and objects properties
            btnComment.setText("comentar");
            btnComment.addActionListener(this);

            txtComments.setFont(new Font("Serif", Font.ITALIC, 16));
            txtComments.setLineWrap(true);
            txtComments.setWrapStyleWord(true);
            txtComments.setEditable(false);
            txtComments.setOpaque(false);

            txtComments.setSize(new Dimension(100,250));

            //jpanels settings

            //userPanel settings
            userPanel.setBackground(Color.lightGray);
            userPanel.setPreferredSize(new Dimension(100,150));
            userPanel.setLayout(new FlowLayout());
            userPanel.add(lblTitle);
            userPanel.add(txtTitle);
            userPanel.add(lblComment);
            userPanel.add(jscroll);
            userPanel.add(btnComment);

            //commentPanel Settings

            commentsPanel.setBackground(Color.black);
            commentsPanel.setLayout(new BorderLayout());
            commentsPanel.setPreferredSize(new Dimension(100,100));
            commentsPanel.add(jscrollComments, BorderLayout.CENTER);

            if (chose == JOptionPane.YES_OPTION)
         {
             graphicObserver.setNameFile(userName + ".txt");
         }

         //Show post
         txtComments.setText(graphicObserver.getPost());

          //visible
          setVisible(true);
        }
    }
    public static void main(String[] args)
    {
       Main m = new Main();
    }

    public void setUserName(String userName)
    {
       this.userName = userName;
    }

    //Listeners
    @Override
    public void actionPerformed(ActionEvent e)
    {
        observableObjet.setComments(txtTitle.getText(), txtBodyPost.getText(), userName);
        observableObjet.notifyObservers();
        txtComments.setText(graphicObserver.getPost());
    }

}
