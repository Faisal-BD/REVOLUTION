package revolution;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Forgot extends JFrame implements ActionListener
{
    private JTextField quesfield;
    private Font f= new Font("Arial",Font.BOLD,22);
    private Font g= new Font("Arial",Font.BOLD,17);
    private Font h= new Font("Arial",Font.BOLD,14);
    private Font i= new Font("Arial",Font.BOLD,15);
    private JButton submit;
    private Color c1 = new Color(97, 152, 230);
    private Color c2 = new Color(217, 231, 255);

    Forgot()
    {
        getContentPane().setBackground(c2);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgot.png"));
        Image i2 = i1.getImage().getScaledInstance(170, 247, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image_01 = new JLabel(i3);
        image_01.setBounds(-48, 103, 170, 247);
        add(image_01);

        JLabel title = new JLabel("Security Question");
        title.setBounds(180, -10, 200, 90);
        title.setForeground(c1);
        title.setFont(f);
        add(title);

        JLabel uline = new JLabel("________________");
        uline.setBounds(175, -5, 212, 90);
        uline.setForeground(c1);
        uline.setFont(f);
        add(uline);

        JLabel ques = new JLabel("Write the Total Number of Lines of Codes in this Project");
        ques.setBounds(40, 40, 451, 90);
        ques.setForeground(Color.BLACK);
        ques.setFont(g);
        add(ques);

        quesfield = new JTextField();
        quesfield.setBounds(225, 110, 80, 45);
        quesfield.setFont(f);
        quesfield.setHorizontalAlignment(JTextField.CENTER);
        add(quesfield);

        submit=new JButton("SUBMIT");
        submit.setBounds(215,180,100,30);
        submit.setFont(i);
        submit.addActionListener(this);
        submit.setFocusable(false);
        add(submit);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Forgot Password");
        setSize(550, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== submit)
        {
            String check = quesfield.getText();

            if (check.equals("3000"))
            {
                setVisible(false);
                JOptionPane.showMessageDialog(null, "Correct Answer\nPASSWORD : 123456.", "Success", JOptionPane.INFORMATION_MESSAGE);
                new Login();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong Answer!", "Failed", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void main(String[] args)
    {
        new Forgot();
    }

}