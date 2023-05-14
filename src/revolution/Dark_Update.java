package revolution;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Dark_Update extends JFrame implements ActionListener
{
    JTextField  contfield, emfield, addfield, dgfield, slrfield;
    JComboBox msfield, bckgrndfield;
    JButton updates, back, close, lmode;
    Font e= new Font("Arial",Font.BOLD,15);
    Font fx= new Font("Arial",Font.BOLD,17);
    Font f= new Font("Arial",Font.BOLD,20);
    Font g= new Font("Arial",Font.BOLD,25);
    Font i= new Font("Serif",Font.PLAIN,18);
    Choice dropdownbox;
    private Color c3 = new Color(53, 87, 255);
    private Color c4 = new Color(178, 0, 0);
    private Color c6 = new Color(82, 0, 0);

    Dark_Update()
    {

        ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("icons/DarkUpdate.jpg"));
        Image a1 = a.getImage().getScaledInstance(870,770, Image.SCALE_SMOOTH);
        ImageIcon a2 = new ImageIcon(a1);
        JLabel image_01 = new JLabel(a2);
        image_01.setBounds(0, 0, 900, 700);
        add(image_01);

        dropdownbox =new Choice();
        dropdownbox.setBounds(510, 37, 110, 0);
        dropdownbox.setFont(g);
        dropdownbox.setForeground(Color.BLUE);
        image_01.add(dropdownbox);

        try
        {
            sqlConnect safin = new sqlConnect();
            String query = "select * from employee ";
            ResultSet r = safin.s.executeQuery(query);
            while (r.next())
            {
                dropdownbox.add(r.getString("ID"));
            }

        }
        catch (Exception safin)
        {
            safin.printStackTrace();
        }

        JLabel empID = new JLabel("Update Details of ID : ");
        empID.setBounds(225+10+10, 30, 500, 50);
        empID.setFont(g);
        empID.setForeground(Color.WHITE);
        image_01.add(empID);

        ImageIcon Dark = new ImageIcon(ClassLoader.getSystemResource("icons/light_mode.png"));
        Image Dark1 = Dark.getImage().getScaledInstance(35,35, Image.SCALE_SMOOTH);
        ImageIcon Dark2 = new ImageIcon(Dark1);

        lmode = new JButton();
        lmode.setBounds(645, 38, 35, 35); //x=755
        lmode.addActionListener(this);
        lmode.setIcon(Dark2);
        lmode.setBackground(Color.WHITE);
        lmode.setFocusable(false);
        image_01.add(lmode);

        JLabel name = new JLabel("Full Name         :");
        name.setBounds(50, 130, 150+4, 30);
        name.setForeground(Color.WHITE);
        name.setFont(f);
        image_01.add(name);

        JLabel jnamefield = new JLabel();
        jnamefield.setBounds(200+15+8, 130, 150, 30);
        jnamefield.setBackground(Color.GREEN);
        jnamefield.setForeground(Color.WHITE);
        jnamefield.setFont(fx);
        image_01.add(jnamefield);

        JLabel fname = new JLabel("Father's Name  :");
        fname.setBounds(50, 180, 150+5, 30);
        fname.setFont(f);
        fname.setForeground(Color.WHITE);
        image_01.add(fname);

        JLabel jfnamefield = new JLabel();
        jfnamefield.setBounds(200+15+8, 180, 150, 30);
        jfnamefield.setFont(fx);
        jfnamefield.setForeground(Color.WHITE);
        image_01.add(jfnamefield);

        JLabel mname = new JLabel("Mother's Name :");
        mname.setBounds(50, 230, 150+5, 30);
        mname.setFont(f);
        mname.setForeground(Color.WHITE);
        image_01.add(mname);

        JLabel jmnamefield = new JLabel();
        jmnamefield.setBounds(200+15+8, 230, 150, 30);
        jmnamefield.setFont(fx);
        jmnamefield.setForeground(Color.WHITE);
        image_01.add(jmnamefield);

        JLabel dateOfBirth = new JLabel("Date of Birth     :");
        dateOfBirth.setBounds(50, 280, 150+7, 30);
        dateOfBirth.setFont(f);
        dateOfBirth.setForeground(Color.WHITE);
        image_01.add(dateOfBirth);

        JLabel jdbfield = new JLabel();
        jdbfield.setBounds(200+15+8, 280, 150, 30);
        jdbfield.setFont(fx);
        jdbfield.setForeground(Color.WHITE);
        image_01.add(jdbfield);

        JLabel contNum = new JLabel("Contact No       :");
        contNum.setBounds(50, 330, 150+5, 30);
        contNum.setFont(f);
        contNum.setForeground(Color.WHITE);
        image_01.add(contNum);

        contfield = new JTextField();
        contfield.setBounds(220, 330, 150, 30);
        contfield.setHorizontalAlignment(JTextField.CENTER);
        contfield.setFont(i);
        image_01.add(contfield);

        JLabel email = new JLabel("Email                :");
        email.setBounds(50, 380, 150+5 , 30);
        email.setFont(f);
        email.setForeground(Color.WHITE);
        image_01.add(email);

        emfield = new JTextField();
        emfield.setBounds(220, 380, 150, 30);
        emfield.setHorizontalAlignment(JTextField.CENTER);
        emfield.setFont(i);
        image_01.add(emfield);

        JLabel mstatus = new JLabel("Marital Status   :");
        mstatus.setBounds(50, 430, 150+7, 30);
        mstatus.setFont(f);
        mstatus.setForeground(Color.WHITE);
        image_01.add(mstatus);

        String moptions[] = {"","Married","UnMarried"};
        msfield = new JComboBox(moptions);
        msfield.setBackground(Color.WHITE);
        msfield.setBounds(220, 430, 150, 30);
        msfield.setFont(i);
        image_01.add(msfield);

        JLabel bGrp = new JLabel("Blood Group     :");
        bGrp.setBounds(50, 480, 150+8, 30);
        bGrp.setFont(f);
        bGrp.setForeground(Color.WHITE);
        image_01.add(bGrp);

        JLabel jbgpfield = new JLabel();
        jbgpfield.setBackground(Color.WHITE);
        jbgpfield.setBounds(200+15+8, 480, 150, 30);
        jbgpfield.setFont(fx);
        jbgpfield.setForeground(Color.WHITE);
        image_01.add(jbgpfield);

        JLabel address = new JLabel("Home Address        :");
        address.setBounds(400+30+15, 130, 150+45, 30);
        address.setFont(f);
        address.setForeground(Color.WHITE);
        image_01.add(address);

        addfield = new JTextField();
        addfield.setBounds(600+30+15+5, 130, 150, 30);
        addfield.setHorizontalAlignment(JTextField.CENTER);
        addfield.setFont(i);
        image_01.add(addfield);

        JLabel bckgrnd = new JLabel("Background            :");
        bckgrnd.setBounds(400+30+15, 200-20, 150+45, 30);
        bckgrnd.setFont(f);
        bckgrnd.setForeground(Color.WHITE);
        image_01.add(bckgrnd);

        String hoptions[] = {"","PHD","BBA", "MBA", "BSC", "MSC", "BTech", "BCom", "B.A", "M.A"};
        bckgrndfield = new JComboBox(hoptions);
        bckgrndfield.setBackground(Color.WHITE);
        bckgrndfield.setBounds(600+30+15+5, 200-20, 150, 30);
        bckgrndfield.setFont(i);
        image_01.add(bckgrndfield);

        JLabel nid = new JLabel("NID Number            :");
        nid.setBounds(400+30+15, 250-20, 200, 30);
        nid.setForeground(Color.WHITE);
        nid.setFont(f);
        image_01.add(nid);

        JLabel jnidfield = new JLabel();
        jnidfield.setBounds(600+30+15+7, 250-20, 150, 30);
        jnidfield.setFont(fx);
        jnidfield.setForeground(Color.WHITE);
        image_01.add(jnidfield);

        JLabel hsc = new JLabel("HSC Batch              :");
        hsc.setBounds(400+30+15, 300-20, 200, 30);
        hsc.setFont(f);
        hsc.setForeground(Color.WHITE);
        image_01.add(hsc);

        JLabel jhscfield = new JLabel();
        jhscfield.setBounds(600+30+15+7, 300-20, 150, 30);
        jhscfield.setFont(fx);
        jhscfield.setForeground(Color.WHITE);
        image_01.add(jhscfield);

        JLabel gdyear = new JLabel("Graduation Year     :");
        gdyear.setBounds(400+30+15, 350-20, 200, 30);
        gdyear.setFont(f);
        gdyear.setForeground(Color.WHITE);
        image_01.add(gdyear);

        JLabel jgdyearfield = new JLabel();
        jgdyearfield.setBounds(600+30+15+7, 350-20, 150, 30);
        jgdyearfield.setFont(fx);
        jgdyearfield.setForeground(Color.WHITE);
        image_01.add(jgdyearfield);

        JLabel pvex = new JLabel("Earlier Experience  :");
        pvex.setBounds(400+30+15, 400-20, 200, 30);
        pvex.setFont(f);
        pvex.setForeground(Color.WHITE);
        image_01.add(pvex);

        JLabel jerexpfield = new JLabel();
        jerexpfield.setBounds(600+30+15+7, 400-20, 150, 30);
        jerexpfield.setFont(fx);
        jerexpfield.setForeground(Color.WHITE);
        image_01.add(jerexpfield);

        JLabel dg = new JLabel("Designation            :");
        dg.setBounds(400+30+15, 450-20, 200, 30);
        dg.setFont(f);
        dg.setForeground(Color.WHITE);
        image_01.add(dg);

        dgfield = new JTextField();
        dgfield.setBounds(600+30+15+5, 450-20, 150, 30);
        dgfield.setHorizontalAlignment(JTextField.CENTER);
        dgfield.setFont(i);
        image_01.add(dgfield);

        JLabel slr = new JLabel("Salary                     :");
        slr.setBounds(400+30+15, 500-20, 200, 30);
        slr.setFont(f);
        slr.setForeground(Color.WHITE);
        image_01.add(slr);

        slrfield = new JTextField();
        slrfield.setBounds(600+30+15+5, 500-20, 150, 30);
        slrfield.setHorizontalAlignment(JTextField.CENTER);
        slrfield.setFont(i);
        image_01.add(slrfield);

        back = new JButton("< Back");
        back.setBounds(150, 575, 150, 40);
        back.setFont(e);
        back.addActionListener(this);
        back.setBackground(c3);
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        image_01.add(back);

        updates = new JButton("UPDATE");
        updates.setBounds(350, 567, 150, 55);
        updates.setFont(f);
        updates.addActionListener(this);
        updates.setBackground(c4);
        updates.setForeground(Color.WHITE);
        updates.setFocusable(false);
        image_01.add(updates);

        close = new JButton("Close >");
        close.setBounds(550, 575, 150, 40);
        close.setFont(e);
        close.addActionListener(this);
        close.setBackground(c6);
        close.setForeground(Color.WHITE);
        close.setFocusable(false);
        image_01.add(close);


        try
        {
            sqlConnect safin = new sqlConnect();
            String query = "select * from employee where ID = "+dropdownbox.getSelectedItem()+"";
            ResultSet r = safin.s.executeQuery(query);
            while (r.next())
            {

                jnamefield.setText(r.getString("Name"));
                jfnamefield.setText(r.getString("Fname"));
                jmnamefield.setText(r.getString("Mname"));
                jdbfield.setText(r.getString("Birth_Date"));
                contfield.setText(r.getString("Contact"));
                emfield.setText(r.getString("Email"));
                msfield.setSelectedItem(r.getString("Marital"));
                jbgpfield.setText(r.getString("Blood"));
                addfield.setText(r.getString("Address"));
                bckgrndfield.setSelectedItem(r.getString("Education"));
                jnidfield.setText(r.getString("NID"));
                jhscfield.setText(r.getString("HSC"));
                jgdyearfield.setText(r.getString("Graduation"));
                jerexpfield.setText(r.getString("Experience"));
                dgfield.setText(r.getString("Designation"));
                slrfield.setText(r.getString("Salary"));
            }
        }
        catch (Exception safin)
        {
            safin.printStackTrace();
        }

        dropdownbox.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent ie)
            {
                try
                {
                    sqlConnect safin = new sqlConnect();
                    String query = "select * from employee where ID = "+dropdownbox.getSelectedItem()+"";
                    ResultSet r = safin.s.executeQuery(query);
                    while (r.next())
                    {
                        jnamefield.setText(r.getString("Name"));
                        jfnamefield.setText(r.getString("Fname"));
                        jmnamefield.setText(r.getString("Mname"));
                        jdbfield.setText(r.getString("Birth_Date"));
                        contfield.setText(r.getString("Contact"));
                        emfield.setText(r.getString("Email"));
                        msfield.setSelectedItem(r.getString("Marital"));
                        jbgpfield.setText(r.getString("Blood"));
                        addfield.setText(r.getString("Address"));
                        bckgrndfield.setSelectedItem(r.getString("Education"));
                        jnidfield.setText(r.getString("NID"));
                        jhscfield.setText(r.getString("HSC"));
                        jgdyearfield.setText(r.getString("Graduation"));
                        jerexpfield.setText(r.getString("Experience"));
                        dgfield.setText(r.getString("Designation"));
                        slrfield.setText(r.getString("Salary"));
                    }

                }
                catch (Exception safin)
                {
                    safin.printStackTrace();
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Update Details");
        setSize(870, 770);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == updates)
        {

            String phone = contfield.getText();
            String email = emfield.getText();
            String mstatus = (String) msfield.getSelectedItem();
            String address = addfield.getText();
            String bckgrnd = (String) bckgrndfield.getSelectedItem();
            String designation = dgfield.getText();
            String salary = slrfield.getText();


            try
            {
                sqlConnect conn = new sqlConnect();
                String query = "update employee set Contact='"+phone+"', Email='"+email+"', Marital='"+mstatus+"', Address='"+address+"', Education='"+bckgrnd+"', Designation='"+designation+"', Salary='"+salary+"' where ID='"+dropdownbox.getSelectedItem()+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "DETAILS UPDATED !","Updated",JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
                new Home();
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

        else if(ae.getSource() == close)
        {
            setVisible(false);
        }
        else if(ae.getSource() == lmode)
        {
            setVisible(false);
            new UpdateEmployee();
        }
        else{}
    }

    public static void main(String[] args)
    {
        new Dark_Update();
    }
}

