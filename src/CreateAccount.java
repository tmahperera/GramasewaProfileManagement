import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAccount {
    private JPanel main;
    private JTextField fname;
    private JTextField nic;
    private JTextField jarea;
    private JTextField lname;
    private JTextField num;
    private JButton createMyAccountButton;
    private JButton cancel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GramaNiladhari");
        frame.setContentPane(new CreateAccount().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    Connection con;
    PreparedStatement pst; //ss
    public void connect()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/nester","root","");
            System.out.println("Success");
        }
        catch(ClassNotFoundException ex) {
            ex.printStackTrace();

        }
            catch(SQLException ex)
            {
        }
    }


    public JTextField getNic() {
        return nic;
    }

    public void setNic(JTextField nic) {
        this.nic = nic;
    }

    public CreateAccount() {
        connect();
        createMyAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int contact = Integer.parseInt(num.getText());
                String firstname = fname.getText();
                String lastname = lname.getText();
                String natid = nic.getText();
                String juris = jarea.getText();



                try {
                    pst = con.prepareStatement("insert into myaccount(firstname,lastname,nic,contactnum,jarea)values(?,?,?,?,?)");
                    pst.setString(1, firstname);
                    pst.setString(2, lastname);
                    pst.setString(3, natid);
                    pst.setString(4, String.valueOf(contact));
                    pst.setString(5, juris);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null,"Account Successfully Created");

                    fname.setText("");
                    num.setText("");
                    lname.setText("");
                    nic.setText("");
                    jarea.setText("");
                    fname.requestFocus();



                }
                catch (SQLException e1){
                    e1.printStackTrace();

                }

            }
        });



        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
