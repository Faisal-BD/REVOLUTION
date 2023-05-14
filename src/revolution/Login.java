package  revolution;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame  implements ActionListener
{
    private JTextField namefield;
    private JPasswordField passfield;
    private JButton login, forgot, about_us;
    private JButton show, hide;
    private Font f= new Font("Arial",Font.BOLD,16);
    private Font fx= new Font("Arial",Font.BOLD,15);
    private Font g= new Font("Arial",Font.BOLD,14);
    private Font h= new Font("Arial",Font.BOLD,12);
    private Color c1 = new Color(196, 228, 252);
    private Color c2 = new Color(207, 225, 255);
    private JLabel image_01;

    public Login()
    {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login_page.jpg"));
        Image i2 = i1.getImage().getScaledInstance(760, 600, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        image_01 = new JLabel(i3);
        image_01.setBounds(0, 0, 760, 450);
        add(image_01);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/Revolution.png"));
        Image i5 = i4.getImage().getScaledInstance(440, 240, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image_02 = new JLabel(i6);
        image_02.setBounds(333, 145, 440, 240);
        image_01.add(image_02);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/Employee.png"));
        Image i8 = i7.getImage().getScaledInstance(320, 49, Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image_03 = new JLabel(i9);
        image_03.setBounds(399, 210, 320, 200);
        image_01.add(image_03);

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/face_2.png"));
        Image i11 = i10.getImage().getScaledInstance(113, 117, Image.SCALE_SMOOTH);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel image_04 = new JLabel(i12);
        image_04.setBounds(135, 43, 113, 117);
        image_01.add(image_04);

        ImageIcon cc = new ImageIcon(ClassLoader.getSystemResource("icons/Revo_Logo.png"));
        Image ccc = cc.getImage().getScaledInstance(135, 135, Image.SCALE_SMOOTH);
        ImageIcon cccc = new ImageIcon(ccc);
        JLabel image_cc = new JLabel(cccc);
        image_cc.setBounds(490, 88, 135, 135);
        image_01.add(image_cc);


        JLabel usname = new JLabel("U S E R N A M E");
        usname.setBounds(132, 179, 130, 30);
        usname.setForeground(Color.BLACK);
        usname.setFont(f);
        image_01.add(usname);

        namefield = new JTextField();
        namefield.setBounds(51, 212, 170+100, 35);
        namefield.setHorizontalAlignment(JTextField.CENTER);
        namefield.setFont(fx);
        namefield.setBackground(c2);
        image_01.add(namefield);

        JLabel pass = new JLabel("P A S S W O R D");
        pass.setBounds(51+81, 271, 130, 30);
        pass.setForeground(Color.BLACK);
        pass.setFont(f);
        image_01.add(pass);

        passfield = new JPasswordField();
        passfield.setBounds(51, 304, 170+100, 35);
        passfield.setHorizontalAlignment(JTextField.CENTER);
        passfield.setBackground(c2);
        passfield.setFont(fx);
        passfield.setEchoChar('●');
        image_01.add(passfield);


        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/hide.png"));
        Image icon2 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon ic2 = new ImageIcon(icon2);

        hide  = new JButton();
        hide.setBounds(323, 306, 30, 30);
        hide.addActionListener(this);
        hide.setFont(g);
        hide.setFocusable(false);
        hide.setIcon(ic2);
        image_01.add(hide);

        login = new JButton("LOGIN");
        login.setBounds(145, 379, 98, 37);
        login.setForeground(Color.BLACK);
        login.setBackground(c1);
        login.setFont(g);
        login.addActionListener(this);
        login.setFocusable(false);
        image_01.add(login);

        forgot  = new JButton("Forgot Password ?");
        forgot.setBounds(124, 434, 142, 27);
        forgot.setBackground(Color.BLACK);
        forgot.setForeground(Color.WHITE);
        forgot.addActionListener(this);
        forgot.setFont(h);
        forgot.setFocusable(false);
        image_01.add(forgot);

        about_us  = new JButton("Click to See About Me");
        about_us.setBounds(470, 350, 188, 27);
        about_us.setBackground(Color.BLACK);
        about_us.setForeground(Color.WHITE);
        about_us.addActionListener(this);
        about_us.setFont(g);
        about_us.setFocusable(false);
        image_01.add(about_us);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("LOG-IN");
        setSize(760, 600);
        ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("icons/Revolution_Icon.png"));
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == login)
        {
            try
            {
                String username = namefield.getText();
                String password = passfield.getText();

                sqlConnect connect = new sqlConnect();
                String query = "select * from login where username = '"+username+"' and password = '"+password+"'";

                ResultSet result = connect.s.executeQuery(query);
                if (result.next())
                {
                    setVisible(false);

                    new Home();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Wrong Username or Pass"+"\n              TRY AGAIN","Wrong",JOptionPane.ERROR_MESSAGE);
                }
            }

            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        else if (ae.getSource() == forgot)
        {
            setVisible(false);
            new Forgot();
        }

        else if (ae.getSource() == hide)
        {
            ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icons/show.png"));
            Image icon4 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon ic3 = new ImageIcon(icon4);
            passfield.setEchoChar((char)0);

            hide.setVisible(false);
  
            show  = new JButton();
            show.setBounds(323, 306, 30, 30);
            show.addActionListener(this);
            show.setFont(h);
            show.setIcon(ic3);
            show.setFocusable(false);
            image_01.add(show);
        }
        else if (ae.getSource() == show)
        {
            passfield.setEchoChar('●');

            show.setVisible(false);
            hide.setVisible(true);
        }
        else if (ae.getSource() == about_us)
        {
            new AboutUS();
        }
        else {}
    }

    public static void main(String[] args)
    {
        new Login();
    }
}