package revolution;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Dark_Delete extends JFrame implements ActionListener
{

    private JButton delete, back, close, lmode;
    private Font e= new Font("Arial",Font.BOLD,15);
    private Font fx= new Font("Arial",Font.BOLD,17);
    private Font f= new Font("Arial",Font.BOLD,20);
    private Font g= new Font("Arial",Font.BOLD,25);
    private Font h= new Font("Arial",Font.BOLD,30);
    private Font i= new Font("Serif",Font.PLAIN,18);
    private Choice dropdownbox;
    private Color c1 = new Color(231, 231, 231);
    private Color c2 = new Color(195, 195, 195);
    private Color c3 = new Color(53, 87, 255);
    private Color c4 = new Color(178, 0, 0);
    private Color c5 = new Color(39, 251, 40);
    private Color c6 = new Color(82, 0, 0);

    Dark_Delete()
    {

        ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("icons/Dark_add.jpg"));
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

        JLabel empID = new JLabel("Employee Unique ID : ");
        empID.setBounds(225+10+10, 30, 500, 50);
        empID.setFont(g);
        empID.setForeground(c1);
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
        name.setFont(f);
        name.setForeground(c1);
        image_01.add(name);

        JLabel jnamefield = new JLabel();
        jnamefield.setBounds(200+15+8, 130, 150, 30);
        jnamefield.setBackground(Color.GREEN);
        jnamefield.setFont(fx);
        jnamefield.setForeground(c1);
        image_01.add(jnamefield);

        JLabel fname = new JLabel("Father's Name  :");
        fname.setBounds(50, 180, 150+5, 30);
        fname.setFont(f);
        fname.setForeground(c1);
        image_01.add(fname);

        JLabel jfnamefield = new JLabel();
        jfnamefield.setBounds(200+15+8, 180, 150, 30);
        jfnamefield.setFont(fx);
        jfnamefield.setForeground(c1);
        image_01.add(jfnamefield);

        JLabel mname = new JLabel("Mother's Name :");
        mname.setBounds(50, 230, 150+5, 30);
        mname.setFont(f);
        mname.setForeground(c1);
        image_01.add(mname);

        JLabel jmnamefield = new JLabel();
        jmnamefield.setBounds(200+15+8, 230, 150, 30);
        jmnamefield.setFont(fx);
        jmnamefield.setForeground(c1);
        image_01.add(jmnamefield);

        JLabel dateOfBirth = new JLabel("Date of Birth     :");
        dateOfBirth.setBounds(50, 280, 150+7, 30);
        dateOfBirth.setFont(f);
        dateOfBirth.setForeground(c1);
        image_01.add(dateOfBirth);

        JLabel jdbfield = new JLabel();
        jdbfield.setBounds(200+15+8, 280, 150, 30);
        jdbfield.setFont(fx);
        jdbfield.setForeground(c1);
        image_01.add(jdbfield);

        JLabel contNum = new JLabel("Contact No       :");
        contNum.setBounds(50, 330, 150+5, 30);
        contNum.setFont(f);
        contNum.setForeground(c1);
        image_01.add(contNum);

        JLabel contfield = new JLabel();
        contfield.setBounds(220, 330, 150, 30);
        contfield.setFont(fx);
        contfield.setForeground(c1);
        image_01.add(contfield);

        JLabel email = new JLabel("Email                :");
        email.setBounds(50, 380, 150+5 , 30);
        email.setFont(f);
        email.setForeground(c1);
        image_01.add(email);

        JLabel emfield = new JLabel();
        emfield.setBounds(220, 380, 150, 30);
        emfield.setFont(fx);
        emfield.setForeground(c1);
        image_01.add(emfield);

        JLabel mstatus = new JLabel("Marital Status   :");
        mstatus.setBounds(50, 430, 150+7, 30);
        mstatus.setFont(f);
        mstatus.setForeground(c1);
        image_01.add(mstatus);

        JLabel msfield = new JLabel();
        msfield.setBounds(220, 430, 150, 30);
        msfield.setFont(fx);
        msfield.setForeground(c1);
        image_01.add(msfield);

        JLabel bGrp = new JLabel("Blood Group     :");
        bGrp.setBounds(50, 480, 150+8, 30);
        bGrp.setFont(f);
        bGrp.setForeground(c1);
        image_01.add(bGrp);

        JLabel jbgpfield = new JLabel();
        jbgpfield.setBackground(Color.WHITE);
        jbgpfield.setBounds(200+15+8, 480, 150, 30);
        jbgpfield.setFont(fx);
        jbgpfield.setForeground(c1);
        image_01.add(jbgpfield);

        JLabel address = new JLabel("Home Address        :");
        address.setBounds(400+30+15, 130, 150+45, 30);
        address.setFont(f);
        address.setForeground(c1);
        image_01.add(address);

        JLabel addfield = new JLabel();
        addfield.setBounds(600+30+15+5, 130, 150, 30);
        addfield.setFont(fx);
        addfield.setForeground(c1);
        image_01.add(addfield);

        JLabel bckgrnd = new JLabel("Background            :");
        bckgrnd.setBounds(400+30+15, 200-20, 150+45, 30);
        bckgrnd.setFont(f);
        bckgrnd.setForeground(c1);
        image_01.add(bckgrnd);

        JLabel bckgrndfield = new JLabel();
        bckgrndfield.setBounds(600+30+15+5, 200-20, 150, 30);
        bckgrndfield.setFont(fx);
        bckgrndfield.setForeground(c1);
        image_01.add(bckgrndfield);

        JLabel nid = new JLabel("NID Number            :");
        nid.setBounds(400+30+15, 250-20, 200, 30);
        nid.setFont(f);
        nid.setForeground(c1);
        image_01.add(nid);

        JLabel jnidfield = new JLabel();
        jnidfield.setBounds(600+30+15+7, 250-20, 150, 30);
        jnidfield.setFont(fx);
        jnidfield.setForeground(c1);
        image_01.add(jnidfield);

        JLabel hsc = new JLabel("HSC Batch              :");
        hsc.setBounds(400+30+15, 300-20, 200, 30);
        hsc.setFont(f);
        hsc.setForeground(c1);
        image_01.add(hsc);

        JLabel jhscfield = new JLabel();
        jhscfield.setBounds(600+30+15+7, 300-20, 150, 30);
        jhscfield.setFont(fx);
        jhscfield.setForeground(c1);
        image_01.add(jhscfield);

        JLabel gdyear = new JLabel("Graduation Year     :");
        gdyear.setBounds(400+30+15, 350-20, 200, 30);
        gdyear.setFont(f);
        gdyear.setForeground(c1);
        image_01.add(gdyear);

        JLabel jgdyearfield = new JLabel();
        jgdyearfield.setBounds(600+30+15+7, 350-20, 150, 30);
        jgdyearfield.setFont(fx);
        jgdyearfield.setForeground(c1);
        image_01.add(jgdyearfield);

        JLabel pvex = new JLabel("Earlier Experience  :");
        pvex.setBounds(400+30+15, 400-20, 200, 30);
        pvex.setFont(f);
        pvex.setForeground(c1);
        image_01.add(pvex);

        JLabel jerexpfield = new JLabel();
        jerexpfield.setBounds(600+30+15+7, 400-20, 150, 30);
        jerexpfield.setFont(fx);
        jerexpfield.setForeground(c1);
        image_01.add(jerexpfield);

        JLabel dg = new JLabel("Designation            :");
        dg.setBounds(400+30+15, 450-20, 200, 30);
        dg.setFont(f);
        dg.setForeground(c1);
        image_01.add(dg);

        JLabel dgfield = new JLabel();
        dgfield.setBounds(600+30+15+5, 450-20, 150, 30);
        dgfield.setFont(fx);
        dgfield.setForeground(c1);
        image_01.add(dgfield);

        JLabel slr = new JLabel("Salary                     :");
        slr.setBounds(400+30+15, 500-20, 200, 30);
        slr.setFont(f);
        slr.setForeground(c1);
        image_01.add(slr);

        JLabel slrfield = new JLabel("Salary            :");
        slrfield.setBounds(600+30+15+5, 500-20, 200, 30);
        slrfield.setFont(fx);
        slrfield.setForeground(c1);
        image_01.add(slrfield);

        back = new JButton("< Back");
        back.setBounds(150, 575, 150, 40);
        back.setFont(e);
        back.addActionListener(this);
        back.setBackground(c3);
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        image_01.add(back);

        delete = new JButton("DELETE");
        delete.setBounds(350, 567, 150, 55);
        delete.setFont(f);
        delete.addActionListener(this);
        delete.setBackground(c4);
        delete.setForeground(Color.WHITE);
        delete.setFocusable(false);
        image_01.add(delete);

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
                msfield.setText(r.getString("Marital"));
                jbgpfield.setText(r.getString("Blood"));
                addfield.setText(r.getString("Address"));
                bckgrndfield.setText(r.getString("Education"));
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
                        msfield.setText(r.getString("Marital"));
                        jbgpfield.setText(r.getString("Blood"));
                        addfield.setText(r.getString("Address"));
                        bckgrndfield.setText(r.getString("Education"));
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

        setSize (870, 770);
        setTitle("Delete Employee");
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == delete)
        {
            try {
                sqlConnect safin = new sqlConnect();
                String query = "delete from employee where ID = "+dropdownbox.getSelectedItem()+"";
                safin.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Successfully");
                setVisible(false);
                new Dark_Delete();
            }
            catch (Exception safin) {
                safin.printStackTrace ();
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
            new DeleteEmployee();
        }
        else{}

    }

    public static void main(String[] args)
    {
        new Dark_Delete();
    }
}
