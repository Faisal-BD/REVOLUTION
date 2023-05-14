package revolution;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dark_Home extends JFrame implements ActionListener
{
    private JButton view, add, update, remove, logout, lmode;
    private Font i= new Font("Arial",Font.BOLD,17);
    private Font j= new Font("Arial",Font.BOLD,22);
    private Color a11 = new Color(53, 87, 255);
    private Color aa1 = new Color(178, 0, 0);
    private Color a3 = new Color(52, 52, 52);

    Dark_Home()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Dark_Home2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1130, 680, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image_05 = new JLabel(i3);
        image_05.setBounds(0, 0, 1130, 680);
        add(image_05);

        ImageIcon cc = new ImageIcon(ClassLoader.getSystemResource("icons/Revo_Logo.png"));
        Image ccc = cc.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon cccc = new ImageIcon(ccc);
        JLabel image_cc = new JLabel(cccc);
        image_cc.setBounds(320, 10,90, 90);
        image_05.add(image_cc);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/Revolution.png"));
        Image i5 = i4.getImage().getScaledInstance(430, 230, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image_02 = new JLabel(i6);
        image_02.setBounds(340, -57, 430, 230);
        image_05.add(image_02);

        ImageIcon Light0 = new ImageIcon(ClassLoader.getSystemResource("icons/light_mode.png"));
        Image Light1 = Light0.getImage().getScaledInstance(35,35, Image.SCALE_SMOOTH);
        ImageIcon Light2 = new ImageIcon(Light1);

        lmode = new JButton();
        lmode.setBounds(750, 37, 35, 35);
        lmode.addActionListener(this);
        lmode.setIcon(Light2);
        lmode.setBackground(Color.BLACK);
        lmode.setFocusable(false);
        image_05.add(lmode);

        ImageIcon addemp = new ImageIcon(ClassLoader.getSystemResource("icons/Add_Emp.png"));
        Image addemp1 = addemp.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon addemp2 = new ImageIcon(addemp1);
        JLabel addemp3 = new JLabel(addemp2);
        addemp3.setBounds(80+30, 200, 150, 150);
        image_05.add(addemp3);

        add = new JButton("Add Employee");
        add.setBounds(58+30, 360, 185, 47);
        add.setFont(i);
        add.setFocusable(false);
        add.setBackground(a3);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        image_05.add(add);

        ImageIcon viewemp0 = new ImageIcon(ClassLoader.getSystemResource("icons/View_Emp3.png"));
        Image viewemp1 = viewemp0.getImage().getScaledInstance(139, 141, Image.SCALE_SMOOTH);
        ImageIcon viewemp2 = new ImageIcon(viewemp1);
        JLabel viewemp3 = new JLabel(viewemp2);
        viewemp3.setBounds(330+30+5, 202, 139, 141);
        image_05.add(viewemp3);

        view = new JButton("View Employee Details");
        view.setBounds(302+30-2, 360, 210, 47);
        view.setFont(i);
        view.addActionListener(this);
        view.setBackground(a3);
        view.setForeground(Color.WHITE);
        view.setFocusable(false);
        image_05.add(view);

        ImageIcon update0 = new ImageIcon(ClassLoader.getSystemResource("icons/Update_Emp2.png"));
        Image update1 = update0.getImage().getScaledInstance(145, 153, Image.SCALE_SMOOTH);
        ImageIcon update2 = new ImageIcon(update1);
        JLabel update3 = new JLabel(update2);
        update3.setBounds(330+30+257, 190, 145, 153);
        image_05.add(update3);

        update = new JButton("Update Details");
        update.setBounds(302+30+244+3+5, 360, 185, 47);
        update.addActionListener(this);
        update.setFont(i);
        update.setBackground(a3);
        update.setForeground(Color.WHITE);
        update.setFocusable(false);
        image_05.add(update);

        ImageIcon rmv0 = new ImageIcon(ClassLoader.getSystemResource("icons/Remove_Emp.png"));
        Image rmv1 = rmv0.getImage().getScaledInstance(140, 140+3, Image.SCALE_SMOOTH);
        ImageIcon rmv2 = new ImageIcon(rmv1);
        JLabel rmv3 = new JLabel(rmv2);
        rmv3.setBounds(302+30+244+3+5+50+230, 202, 140, 140+3); //330,200 ,w150
        image_05.add(rmv3);

        remove = new JButton("Delete Employee");
        remove.setBounds(302+30+244+3+5+250, 360, 185, 47);
        remove.addActionListener(this);
        remove.setFont(i);
        remove.setFocusable(false);
        remove.setBackground(a3);
        remove.setForeground(Color.WHITE);
        image_05.add(remove);

        logout = new JButton("LOG OUT");
        logout.setBounds(203+300-15, 498+3, 130+5, 45+5);
        logout.addActionListener(this);
        logout.setFont(j);
        logout.setBackground(aa1);
        logout.setForeground(Color.WHITE);
        logout.setFocusable(false);
        image_05.add(logout);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("HOME");
        setSize(1100+30, 680);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == add)
        {
            setVisible(false);
            new Dark_Add();
        }
        else if (ae.getSource() == view)
        {
            setVisible(false);
            new Dark_View();
        }
        else if (ae.getSource() == update)
        {
            setVisible(false);
            new Dark_Update();
        }
        else if(ae.getSource() == remove)
        {
            setVisible(false);
            new Dark_Delete();
        }
        else if(ae.getSource() == logout)
        {
            setVisible(false);
            new Login();
        }
        else if(ae.getSource() == lmode)
        {
            setVisible(false);
            new Home();
        }
        else{}
    }

    public static void main(String[] args)
    {
        new Dark_Home();
    }
}


