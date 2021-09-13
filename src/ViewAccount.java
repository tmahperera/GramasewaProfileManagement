import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewAccount  extends CreateAccount{
    private JButton delete;
    private JButton edit;
    private JButton backhome;
    private JTextField fnametxt;
    private JTextField lnametxt;
    private JTextField nictxt;
    private JTextField jareatxt;
    private JTextField numtxt;
    private JPanel viewaccount;

    CreateAccount newObj = new CreateAccount();




    public static void main(String[] args) {
        JFrame frame = new JFrame("ViewAccount");
        frame.setContentPane(new ViewAccount().viewaccount);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public ViewAccount() {
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
    }

    private void viewrecords()
    {
        int p = 0;


        try {


            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/nester", "root", "");
            PreparedStatement ps = con.prepareStatement("select * from myaccount");


            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {

                for(int q=1; q<=p; q++)
                {
                    fnametxt.setText(rs.getString("firstname"));
                    lnametxt.setText(rs.getString("lastname"));
                    nictxt.setText(rs.getString("nic"));
                    jareatxt.setText(rs.getString("jarea"));
                    numtxt.setText(rs.getString("contactnum"));


                }

            }


        } catch (ClassNotFoundException ex) {

            Logger.getLogger(ViewAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {

            Logger.getLogger(ViewAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
