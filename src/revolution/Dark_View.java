package revolution;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import javax.swing.table.*;

public class Dark_View extends JFrame implements ActionListener
{

    JTable table;
    Choice empName, empDesi;
    JButton search1, search2, print, update, back, refresh, lmode;
    Font f= new Font("Arial",Font.PLAIN,16);
    Font g= new Font("Arial",Font.BOLD,16);
    Font h= new Font("Arial",Font.BOLD,28);
    Font i= new Font("Arial",Font.BOLD,18);
    Font j= new Font("Arial",Font.PLAIN,17);
    Font k= new Font("Arial",Font.BOLD,17);
    Color a1 = new Color(231, 231, 231);
    Color a2 = new Color(231, 231, 231);

    Dark_View()
    {
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        ImageIcon Light = new ImageIcon(ClassLoader.getSystemResource("icons/light_mode.png"));
        Image Light1 = Light.getImage().getScaledInstance(35,35, Image.SCALE_SMOOTH);
        ImageIcon Light2 = new ImageIcon(Light1);
        
        ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("icons/Dark_View.jpg"));
        Image a1 = a.getImage().getScaledInstance(1600,600, Image.SCALE_SMOOTH);
        ImageIcon a2 = new ImageIcon(a1);
        JLabel image_01 = new JLabel(a2);
        image_01.setBounds(0, 0, 1600, 250);
        getContentPane().add(image_01);

        JLabel heading = new JLabel("View Employee List & Details");
        heading.setBounds(500,35,400, 35);
        heading.setForeground(Color.WHITE);
        heading.setFont(h);
        image_01.add(heading);

        JLabel searchName = new JLabel("Search by Employee Name  : ");
        searchName.setBounds(800, 140, 263, 20);
        searchName.setForeground(Color.LIGHT_GRAY);
        searchName.setFont(i);
        image_01.add(searchName);

        empName = new Choice();
        empName.setBounds(1090, 137, 190, 30);
        empName.setForeground(Color.WHITE);
        empName.setBackground(Color.DARK_GRAY);
        empName.setFont(j);
        image_01.add(empName);
        
        lmode = new JButton();
        lmode.setBounds(50, 103, 37, 37);
        lmode.addActionListener(this);
        lmode.setIcon(Light2);
        lmode.setBackground(Color.BLACK);
        lmode.setFocusable(false);
        image_01.add(lmode);

        JLabel searchDes = new JLabel("Filter by Designation             : ");
        searchDes.setBounds(800, 200, 263, 20); //x=20
        searchDes.setForeground(Color.LIGHT_GRAY);
        searchDes.setFont(i);
        image_01.add(searchDes);

        empDesi = new Choice();
        empDesi.setBounds(1090, 197, 190, 30);
        empDesi.setForeground(Color.WHITE);
        empDesi.setBackground(Color.DARK_GRAY);
        empDesi.setFont(j);
        image_01.add(empDesi);

        search1 = new JButton("Search");
        search1.setBounds(1300, 133, 110, 35);
        search1.setFont(g);
        search1.setForeground(Color.WHITE);
        search1.setBackground(Color.DARK_GRAY);
        search1.setFocusable(false);
        search1.addActionListener(this);
        image_01.add(search1);

        search2 = new JButton("Filter");
        search2.setBounds(1300, 193, 110, 35);
        search2.setForeground(Color.WHITE);
        search2.setBackground(Color.DARK_GRAY);
        search2.setFont(g);
        search2.setFocusable(false);
        search2.addActionListener(this);
        image_01.add(search2);

        print = new JButton("Print");
        print.setBounds(50-25, 193, 90, 45);
        print.setFont(k);
        print.setForeground(Color.WHITE);
        print.setBackground(Color.DARK_GRAY);
        print.setFocusable(false);
        print.addActionListener(this);
        image_01.add(print);

        back = new JButton("Back");
        back.setBounds(150-25, 193, 90, 45);
        back.setFont(k);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.DARK_GRAY);
        back.setFocusable(false);
        back.addActionListener(this);
        image_01.add(back);

        refresh = new JButton("Refresh");
        refresh.setBounds(250-25, 193, 90+10, 45);
        refresh.setFont(k);
        refresh.setForeground(Color.WHITE);
        refresh.setBackground(Color.DARK_GRAY);
        refresh.setFocusable(false);
        refresh.addActionListener(this);
        image_01.add(refresh);

        table = new JTable();
        table.setSelectionBackground(Color.lightGray);
        table.setForeground(Color.WHITE);
        table.setBackground(Color.DARK_GRAY);
        table.setFont(f);
        table.setRowHeight(30);
        image_01.add(table);

        JTableHeader head= table.getTableHeader();
        head.setFont(g);
        head.setForeground(Color.WHITE);
        head.setBackground(Color.BLACK);
        add(head);

        JScrollPane TableEdit = new JScrollPane(table);
        TableEdit.setBackground(Color.GRAY);
        TableEdit.setForeground(Color.BLACK);
        TableEdit.setBounds(0, 250, 1450, 650);
        add(TableEdit);

        try
        {
            sqlConnect c = new sqlConnect();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next())
            {
                empName.add(rs.getString("Name"));
                empDesi.add(rs.getString("Designation"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            sqlConnect c = new sqlConnect();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1460, 800);
        setLocationRelativeTo(null);
        ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("icons/Revolution_Icon.png"));
        setIconImage(icon.getImage());
        setResizable(true);
        setTitle("Employee Details");
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == search1)
        {
            String query = "select * from employee where Name = '"+empName.getSelectedItem()+"'";
            try
            {
                sqlConnect c = new sqlConnect();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == search2)
        {
            String query = "select * from employee where Designation = '"+empDesi.getSelectedItem()+"'";
            try
            {
                sqlConnect c = new sqlConnect();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == print)
        {
            try
            {
                table.print();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back)
        {
            setVisible(false);
            new Dark_Home();
        }
        else if(ae.getSource() == refresh)
        {
            setVisible(false);
            new Dark_View();
        }
        else if(ae.getSource() == lmode)
        {
            setVisible(false);
            new ViewEmployee();
        }
    }

    public static void main(String[] args)
    {
        new Dark_View();
    }
}
