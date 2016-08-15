/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * applied_jobs.java
 *
 * Created on 2 Jul, 2015, 12:04:10 PM
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


public class applied_jobs extends javax.swing.JFrame implements ActionListener{
Connection conn;
Statement stmt;
Statement stmt1;
ResultSet rs;
ResultSet rs1;
String email;
int c=0,s=0,m=0;
JPanel p1=new JPanel();
JPanel p2=new JPanel();
JPanel p[]=new JPanel[1000];
JButton b[]=new JButton[1000];
JButton b1[]=new JButton[1000];
JScrollPane sp=new JScrollPane(p1);
 String j ;
   String detail[]=new String[100];
   String job[]=new String[100];
    String status[]=new String[100];
    /** Creates new form applied_jobs */





   public applied_jobs(String a) {
        initComponents();
                setLayout(new GridLayout(1,1));
p1.setLayout(new GridLayout(1000,1));

       email=a;
      
      String desig[]=new String[100];
      String company[]=new String[100];
      String place[]=new String[100];
     String expr[]=new String[100];
     String salary[]=new String[100];
     String date[]=new String[100];

     String arr[][]=new String[100][100];
     
      
     String column[]={"Designation"," Company","Location","Salary","Date","job_id","Status","Remove"};
    p2.setLayout(new GridLayout(1,8));
     for(int i=0;i<8;i++)
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
           rs=stmt.executeQuery("select * from applied_jobs");
           while(rs.next())

     {
         String str=rs.getString("email_id");
        
         if(str.equals(email))
         { System.out.println(str);

            
              j=rs.getString("job_id");
              System.out.println(j);
              
      
         
     try
         {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:seeker");
            System.out.println("connected");
            stmt1=conn.createStatement();

             rs1=stmt1.executeQuery("select * from job");

     
System.out.println(j);
      
             while(rs1.next())
             {
            
                if(j.equals(rs1.getString("job_id")))

                 {

                desig[c]=rs1.getString("designation");
                System.out.println(desig[c]);
             company[c]=rs1.getString("job_industry");
             place[c]=rs1.getString("place");
      status[c]=rs.getString("status");
      
             
job[c]=j;
 
             salary[c]=rs1.getString("salary");
             date[c]=rs1.getString("date_of");
            
            detail[c]=rs1.getString("description");
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
           }
           
           }
           

           stmt.close();
           conn.close();

           
      for(int i=0;i<c;i++)
      {
              arr[i][0]=desig[i];
              arr[i][1]=company[i];
              arr[i][2]=place[i];
              arr[i][3]="Rs."+salary[i];
              arr[i][4]=date[i];
              arr[i][5]=job[i];
             arr[i][6]=status[i];
      }
        /*   for(int i=0;i<c;i++)
           {
               for(int g=0;g<5;g++)
               {
                              System.out.print(arr[i][g]+"\t\t");
           }
System.out.println();
           }*/
           for(int i=0;i<c;i++)
           {
           p[i]=new JPanel();

           p[i].setLayout(new GridLayout(1,8));
               for(int g=0;g<7;g++)

               {
System.out.println(arr[i][g]);
                       p[i].add(new JLabel(arr[i][g]));



          }

          
        //p[i].add(new JLabel(job[i]));

          b[i]=new JButton("Remove");
                   p[i].add(b[i]);
         // p[i].add(new JLabel(""));
               p1.add(p[i]);
           }
 add(sp);
         
            stmt.close();
           conn.close();

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
      rs1=stmt1.executeQuery("select * from applied_jobs");
      while(rs1.next())
      {
          if(job[i].equals(rs1.getString("job_id")))
          {
             s=rs1.getInt("ID");
            stmt1.executeUpdate("delete from applied_jobs where [ID]="+s);
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
            .addGap(0, 906, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new applied_jobs("abcd").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
