/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * delete_job.java
 *
 * Created on 1 Jul, 2015, 6:38:42 PM
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

public class delete_job extends javax.swing.JFrame implements ActionListener {
Connection conn;
Statement stmt;
Statement stmt1;
ResultSet rs;
int c=0,s=0;
String email;
JPanel p1=new JPanel();
JPanel p2=new JPanel();
JPanel p[]=new JPanel[1000];
JButton b[]=new JButton[1000];
JButton b1[]=new JButton[1000];
JScrollPane sp=new JScrollPane(p1);
  String job[]=new String[100];
    /** Creates new form delete_job */
    public delete_job(String a) {
        initComponents();
        p1.setLayout(new GridLayout(1000,1));
setLayout(new GridLayout(1,1));

     String column[]={"Designation"," Company","Location","Salary","Date","job_id","Delete","Edit"};
    p2.setLayout(new GridLayout(1,8));
     for(int i=0;i<8;i++)
     {
         JLabel l=new JLabel(column[i]);
         l.setFont(new Font("arial",Font.BOLD,20));
       p2.add(l);
     }
p1.add(p2);
    String desig[]=new String[100];
      String company[]=new String[100];
      String place[]=new String[100];
     String expr[]=new String[100];
     String salary[]=new String[100];
     String date[]=new String[100];
      String detail[]=new String[100];
     
     String arr[][]=new String[100][100];

email=a;
        try
         {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:seeker");
            System.out.println("connected");
            stmt=conn.createStatement();
           rs=stmt.executeQuery("select * from job");
           while(rs.next())

     {
         String str=rs.getString("email_id");

         if(str.equals(email))
         { System.out.println(str);
System.out.println(str);
                desig[c]=rs.getString("designation");
                System.out.println(desig[c]);
             company[c]=rs.getString("job_industry");
             place[c]=rs.getString("place");


             job[c]=rs.getString("job_id");

             salary[c]=rs.getString("salary");
             date[c]=rs.getString("date_of");

            detail[c]=rs.getString("description");
             c++;
    }
           }
        }
                  catch(SQLException se)
{
    System.out.println(se);
}
catch(ClassNotFoundException ce)
{
     System.out.println(ce);
}


      for(int i=0;i<c;i++)
      {
              arr[i][0]=desig[i];
              arr[i][1]=company[i];
              arr[i][2]=place[i];
              arr[i][3]="Rs."+salary[i];
              arr[i][4]=date[i];
              arr[i][5]=job[i];
              //arr[i][6]=detail[i];

      }
      for(int i=0;i<c;i++)
           {
               for(int g=0;g<6;g++)
               {
                              System.out.print(arr[i][g]+"\t\t");
           }
System.out.println();

      }
       for(int i=0;i<c;i++)
           {
           p[i]=new JPanel();

           p[i].setLayout(new GridLayout(1,9));
               for(int g=0;g<6;g++)

               {
System.out.println(arr[i][g]);
                       p[i].add(new JLabel(arr[i][g]));



          }


         

          b[i]=new JButton("Delete");
            b1[i]=new JButton("Edit");
                   p[i].add(b[i]);
                   p[i].add(b1[i]);
          p1.add(p[i]);
           }
 add(sp);
for(int i=0;i<c;i++)
{
    b[i].addActionListener(this);
    b1[i].addActionListener(this);
    }
    }






     public void actionPerformed(ActionEvent ae)
    {
        for(int i=0;i<c;i++)
        {
        if(ae.getSource()==b[i])
        {
           System.out.println(job[i]);


           try
         {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:seeker");
            System.out.println("connected");
            stmt1=conn.createStatement();
      System.out.println("abc");
      rs=stmt1.executeQuery("select * from job");

      while(rs.next())
      {
          if(job[i].equals(rs.getString("job_id")))
          {
          s=rs.getInt("ID");
              stmt1.executeUpdate("delete from job where [ID]="+s);
            p1.remove(p[i]);
            p1.validate();
            remove(sp);
            sp.validate();

            sp=new JScrollPane(p1);
            add(sp);
            validate();


      }
      }
           }
                             catch(SQLException se)
{
    System.out.println(se);
}
catch(ClassNotFoundException ce)
{
     System.out.println(ce);
}
        }
        if(ae.getSource()==b1[i])
        {
            new edit_job(email,job[i]).setVisible(true);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new delete_job("abcd").setVisible(true);
            }
        });
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
