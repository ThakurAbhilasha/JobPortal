/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * create_event.java
 *
 * Created on 7 Jul, 2015, 6:05:21 PM
 */

package jobportal;

/**
 *
 * @author abhilasha
 */import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class create_event extends javax.swing.JFrame implements ActionListener{
Connection conn;
Statement stmt,stmt1;
ResultSet rs;
ResultSet rs1;
ResultSet rs2;
String email;
int c=0,k=0,flag=0;
String event_name[]=new String[10000];
String detail[]=new String[10000];
int s[]=new int[1000];
String arr[][]=new String[1000][1000];
JPanel p1=new JPanel();
JPanel p2=new JPanel();
JPanel p3[]=new JPanel[1000];
JPanel p4[]=new JPanel[1000];
JPanel p[]=new JPanel[1000];
JButton b[]=new JButton[1000];
JButton b1[]=new JButton[1000];
JButton b2[]=new JButton[1000];
JScrollPane sp=new JScrollPane(p1);
    /** Creates new form create_event */
    public create_event() {

        initComponents();
        validate();
               setLayout(new GridLayout(1,1));
p1.setLayout(new GridLayout(1000,1));
  p2.setLayout(new GridLayout(1,3));

  String column[]={"Event Name","              Details","        Modify"};
     for(int i=0;i<3;i++)
     {
         JLabel l=new JLabel(column[i]);
         l.setFont(new Font("arial",Font.BOLD,20));
       p2.add(l);
     }
p1.add(p2);


try
{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:seeker");
            System.out.println("connected");
            stmt=conn.createStatement();
      rs=stmt.executeQuery("select * from admin");
      while(rs.next())

      {
           event_name[c]=rs.getString("event_name");
          detail[c]=rs.getString("details");
         s[c]=rs.getInt("ID");
          c++;

      }

for(int i=0;i<c;i++)
{
    arr[i][0]=i+1+". "+event_name[i];
    arr[i][1]=detail[i];
}
  for(int i=0;i<c;i++)
           {
           p[i]=new JPanel();
         // p[i].setBackground(Color.black);
          // p[i].setForeground(Color.white);
           p[i].setLayout(new GridLayout(1,3));
           

                       p[i].add(new JLabel(arr[i][0]));



        
        b[i]=    new JButton("View");
          p4[i]=new JPanel();
            p4[i].setLayout(new FlowLayout());
           p4[i].add(b[i]);
           p[i].add(p4[i]);
         b1[i]=    new JButton("Edit");
          b2[i]=    new JButton("Delete");
         p3[i]=new JPanel();
            p3[i].setLayout(new FlowLayout());
           p3[i].add(b1[i]);
             p3[i].add(b2[i]);
            p[i].add(p3[i]);
         
p1.add(p[i]);
           }
 add(sp);
}
       catch(SQLException se)
     {
     System.out.println(se);

    }
     catch(ClassNotFoundException ce)
     {
         System.out.println(ce);
     }        // TODO add your handling code here:



for(int i=0;i<c;i++)
{
    b[i].addActionListener(this);
    b1[i].addActionListener(this);
    b2[i].addActionListener(this);


}

    }

public void actionPerformed(ActionEvent ae)
{

    for(int i=0;i<c;i++)
    {
     
        if(ae.getSource()==b[i])
        {

                          new detail(detail[i]).setVisible(true);

        }
if(ae.getSource()==b1[i])
{
    dispose();
   new edit_event(event_name[i],detail[i],s[i]).setVisible(true);
   
      
}
        if(ae.getSource()==b2[i])
        {
           try
{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:seeker");
            System.out.println("connected");
            stmt=conn.createStatement();
            stmt.executeUpdate("delete * from admin where [ID]="+s[i]);
             p1.remove(p[i]);
            p1.validate();
            remove(sp);
            sp.validate();

            sp=new JScrollPane(p1);
            add(sp);
            validate();
        }
           catch(SQLException se)
     {
     System.out.println(se);

    }
     catch(ClassNotFoundException ce)
     {
         System.out.println(ce);
     }        // TODO add your handling code here:
    }
    }
}






    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run()   {
                new create_event().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
