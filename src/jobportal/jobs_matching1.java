/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jobs_matching1.java
 *
 * Created on 1 Jul, 2015, 5:01:46 PM
 */

package jobportal;

/**
 *
 * @author abhilasha
 */
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class jobs_matching1 extends javax.swing.JFrame implements ActionListener {
Connection conn;
Statement stmt,stmt1;
ResultSet rs;
ResultSet rs1;
ResultSet rs2;
String email;
int c=0,s=0,k=0,flag=0;
JPanel p1=new JPanel();
JPanel p2=new JPanel();
JPanel p[]=new JPanel[1000];
JButton b[]=new JButton[1000];
JButton b1[]=new JButton[1000];
JScrollPane sp=new JScrollPane(p1);
  String job[]=new String[100];
   String detail[]=new String[100];
  String j[]=new String[100];
  String c_email[]=new String[100];
String status="waiting";
String call="waiting";

    /** Creates new form jobs_matching1 */
    public jobs_matching1(String a) {
        initComponents();
        setLayout(new GridLayout(1,1));
p1.setLayout(new GridLayout(1000,1));
//p1.setBackground(Color.WHITE);
       email=a;
       String applied_employee;
       String qual="";
       String exp_m="";
      String exp_y="";
      String qua;
      String expm;
      String expy;
      String j1;
      String desig[]=new String[100];
      String company[]=new String[100];
      String place[]=new String[100];
     String expr[]=new String[100];
     String salary[]=new String[100];
     String date[]=new String[100];
   
     String arr[][]=new String[100][100];

     String column[]={"Designation"," Company","Location","expr","Salary","Date","Apply","detail"};
    p2.setLayout(new GridLayout(1,8));
 // p2.setBackground(Color.black);
   //p2.setForeground(Color.white);
     for(int i=0;i<8;i++)
     {
         JLabel l=new JLabel(column[i]);
       //  l.setForeground(Color.white);
         l.setFont(new Font("arial",Font.BOLD,20));
       p2.add(l);
     }
p1.add(p2);


/*check for applied jobs*/

try
{
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:seeker");
            System.out.println("connected");
            stmt=conn.createStatement();
           rs=stmt.executeQuery("select * from applied_jobs");

    k=0;
           while(rs.next())
           {
 applied_employee =rs.getString("email_id");
    System.out.println(applied_employee);
     if(applied_employee.equals(email))
     {

        j[k]=rs.getString("job_id");
        
System.out.println(j[k]);
          k++;
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






     try
         {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:seeker");
            System.out.println("connected");
            stmt=conn.createStatement();
           rs=stmt.executeQuery("select * from employee");
           while(rs.next())

     {
         String str=rs.getString("email_id");
         if(str.equals(email))
         {
qual=rs.getString("qualifications");
System.out.println(qual);
exp_m=rs.getString("exp_mnths");
System.out.println(exp_m);
exp_y=rs.getString("exp_year");
System.out.println(exp_y);
         }
           }

        /*   rs2=stmt1.executeQuery("select * from applied_jobs");

while(rs2.next())
{
  //  j=rs2.getString("job_id");
    System.out.println(j);
}*/


        for(int i=0;i<k;i++)
    System.out.println(j[i]);



     rs1=stmt.executeQuery("select * from job");
   
            while(rs1.next())
            {
              qua=rs1.getString("qualifications");
              System.out.println(qua);
              expm=rs1.getString("exp_mnths");
              System.out.println(expm);
              expy=rs1.getString("exp_year");
              System.out.println(expy);
             j1=rs1.getString("job_id");
 System.out.println(j1);
             for(int i=0;i<k;i++)
             {
                 if(j1.equals(j[i]))
                 {
                     flag=1;
                     break;
                 }
                 else flag=0;
             }


         if(qua.equals(qual)&&exp_m.equals(expm)&&exp_y.equals(expy)&&flag==0)
         {
             c_email[c]=rs1.getString("email_id");
              System.out.println(c_email);
             desig[c]=rs1.getString("designation");
             company[c]=rs1.getString("job_industry");
             place[c]=rs1.getString("place");
            expr[c]=expy;

             salary[c]=rs1.getString("salary");
             date[c]=rs1.getString("date_of");
             job[c]=j1;
            detail[c]=rs1.getString("description");
             c++;
       flag=0;
            }
              System.out.println(c);
           }
          //  }
          //  }
           stmt.close();
           conn.close();




      for(int i=0;i<c;i++)
      {
              arr[i][0]=desig[i];
              arr[i][1]=company[i];
              arr[i][2]=place[i];
              arr[i][3]=expr[i]+" year";
              arr[i][4]="Rs."+salary[i];
              arr[i][5]=date[i];
      }
           for(int i=0;i<c;i++)
           {
               for(int j=0;j<=5;j++)
               {
                              System.out.print(arr[i][j]+"\t\t");
           }
System.out.println();
           }
     
       for(int i=0;i<c;i++)
           {
           p[i]=new JPanel();
         // p[i].setBackground(Color.black);
          // p[i].setForeground(Color.white);
           p[i].setLayout(new GridLayout(1,8));
               for(int j=0;j<=5;j++)

               {

                       p[i].add(new JLabel(arr[i][j]));



          }
        b[i]=    new JButton("apply");
         b1[i]=    new JButton("detail");
            p[i].add(b[i]);
            p[i].add(b1[i]);
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
     }
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
                try
                {

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:seeker");
            System.out.println("connected");
            stmt=conn.createStatement();
            //stmt.executeUpdate("delete *from applied_jobs");
            stmt.executeUpdate("insert into applied_jobs (email_id,job_id,details,c_id,status,call) values('"+email+"','"+job[i]+"','"+detail[i]+"','"+c_email[i]+"','"+status+"','"+call+"')");
           // b[i].setVisible(false);
         b[i].setEnabled(false);
         b[i].setText("applied");

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
                   try
                {

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:seeker");
            System.out.println("connected");
            stmt=conn.createStatement();
            rs=stmt.executeQuery("select * from job");
            while(rs.next())
            {
           String j=rs.getString("job_id") ;
           if(j.equals(job[i]))
           {
                s=rs.getInt("ID");
   String descrip=rs.getString("description");
         
          new job_details(descrip).setVisible(true);
            }
            }       }
   catch(SQLException se)
     {
     System.out.println(se);

    }
     catch(ClassNotFoundException ce)
     {
         System.out.println(ce);
     }
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
            .addGap(0, 1065, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jobs_matching1("defg").setVisible(true);
            }
        });
    }


  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
