package revolution;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AboutUS  extends JFrame
{
    private JLabel image_01;
    public AboutUS()
    {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/About_Us.jpg"));
        Image i2 = i1.getImage().getScaledInstance(980, 350, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        image_01 = new JLabel(i3);
        image_01.setBounds(0, 0, 980, 350);
        add(image_01);


        setTitle("About Me");
        setSize(996, 388);
        ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("icons/Revolution_Icon.png"));
        setIconImage(icon.getImage());
        setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new AboutUS();
    }
}

