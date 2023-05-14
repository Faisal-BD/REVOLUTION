package revolution;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import javax.swing.table.*;

public class ViewEmployee extends JFrame implements ActionListener
{

    JTable table;
    Choice empName, empDesi;
    JButton search1, search2, print, update, back, refresh, dmode;
    Font f= new Font("Arial",Font.PLAIN,16);
    Font g= new Font("Arial",Font.BOLD,16);
    Font h= new Font("Arial",Font.BOLD,28);
    Font i= new Font("Arial",Font.BOLD,18);
    Font j= new Font("Arial",Font.PLAIN,17);
    Font k= new Font("Arial",Font.BOLD,17);
    Color a1 = new Color(216, 224, 252);
    Color a2 = new Color(161, 178, 229);

    ViewEmployee()
    {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon Dark = new ImageIcon(ClassLoader.getSystemResource("icons/dark_mode.png"));
        Image Dark1 = Dark.getImage().getScaledInstance(35,35, Image.SCALE_SMOOTH);
        ImageIcon Dark2 = new ImageIcon(Dark1);
                
        ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("icons/View.jpg"));
        Image a1 = a.getImage().getScaledInstance(1600,250, Image.SCALE_SMOOTH);
        ImageIcon a2 = new ImageIcon(a1);
        JLabel image_01 = new JLabel(a2);
        image_01.setBounds(0, 0, 1600, 250);
        getContentPane().add(image_01);

        JLabel heading = new JLabel("View Employee List & Details");
        heading.setBounds(500,35,400, 35);
        heading.setFont(h);
        image_01.add(heading);

        dmode = new JButton();
        dmode.setBounds(50, 103, 35, 35);
        dmode.addActionListener(this);
        dmode.setIcon(Dark2);
        dmode.setBackground(Color.WHITE);
        dmode.setFocusable(false);
        image_01.add(dmode);
        
        JLabel searchName = new JLabel("Search by Employee Name  : ");
        searchName.setBounds(800, 140, 263, 20);
        searchName.setFont(i);
        image_01.add(searchName);

        empName = new Choice();
        empName.setBounds(1090, 137, 190, 30);
        empName.setFont(j);
        image_01.add(empName);

        JLabel searchDes = new JLabel("Filter by Designation             : ");
        searchDes.setBounds(800, 200, 263, 20); //x=20
        searchDes.setFont(i);
        image_01.add(searchDes);

        empDesi = new Choice();
        empDesi.setBounds(1090, 197, 190, 30);
        empDesi.setFont(j);
        image_01.add(empDesi);

        search1 = new JButton("Search");
        search1.setBounds(1300, 133, 110, 35);
        search1.setFont(g);
        search1.setFocusable(false);
        search1.addActionListener(this);
        image_01.add(search1);

        search2 = new JButton("Filter");
        search2.setBounds(1300, 193, 110, 35);
        search2.setFont(g);
        search2.setFocusable(false);
        search2.addActionListener(this);
        image_01.add(search2);

        print = new JButton("Print");
        print.setBounds(50-25, 193, 90, 45);
        print.setFont(k);
        print.setFocusable(false);
        print.addActionListener(this);
        image_01.add(print);

        back = new JButton("Back");
        back.setBounds(150-25, 193, 90, 45);
        back.setFont(k);
        back.setFocusable(false);
        back.addActionListener(this);
        image_01.add(back);

        refresh = new JButton("Refresh");
        refresh.setBounds(250-25, 193, 90+10, 45);
        refresh.setFont(k);
        refresh.setFocusable(false);
        refresh.addActionListener(this);
        image_01.add(refresh);

        table = new JTable();
        table.setSelectionBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setFont(f);
        table.setRowHeight(30);
        image_01.add(table);

        JTableHeader head= table.getTableHeader();
        head.setFont(g);
        add(head);

        JScrollPane TableEdit = new JScrollPane(table);
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
        setSize(1460, 800); //914, 800
        setLocationRelativeTo(null);
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
        else if(ae.getSource() == dmode)
        {
            setVisible(false);
            new Dark_View();
        }
        else if(ae.getSource() == back)
        {
            setVisible(false);
            new Home();
        }
        else if(ae.getSource() == refresh)
        {
            setVisible(false);
            new ViewEmployee();
        }
    }

    public static void main(String[] args)
    {
        new ViewEmployee();
    }
}
