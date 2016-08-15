/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * view_posted_jobs.java
 *
 * Created on 4 Jul, 2015, 8:18:43 AM
 */

package jobportal;

/**
 *
 * @author abhilasha
 */
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class applications extends javax.swing.JFrame implements ActionListener{
 Connection conn;
 Statement stmt;
  Statement stmt1;
  Statement stmt2;
 ResultSet rs;
  ResultSet rs1;
   ResultSet rs2;
String email,j_id;
JPanel p1=new JPanel();
JPanel p2=new JPanel();
JPanel p3=new JPanel();
JPanel panel[]=new JPanel[1000];
JButton b[]=new JButton[1000];
JButton b1[]=new JButton[1000];
JButton b2[]=new JButton[1000];
JButton b3[]=new JButton[1000];
JScrollPane sp=new JScrollPane(p1);
 String resume[]=new String[1000];
   String email_id[]=new String[1000];
int c=0,p=0;
int s=0;
int flag[]=new int[1000];
 String str2,company;
    /** Creates new form view_posted_jobs */



public applications(String em,String j) {
        initComponents();
        email=em;
        j_id=j;
                setLayout(new GridLayout(1,1));
p1.setLayout(new GridLayout(1000,1));
      
         String fname[]=new String[1000];
          String lname[]=new String[1000];
           String gender[]=new String[1000];
            String e[]=new String[1000];
             String contact[]=new String[1000];
              String expy[]=new String[1000];
               String qual[]=new String[1000];
               
                 String arr[][]=new String[1000][1000];
                   String column[]={"Name","gender","email_id","Contact no.","Experience","Qualifications","Resume","Accept","Reject","Interview call"};
    p3.setLayout(new FlowLayout());
    JLabel l1=new JLabel("Applications");
    l1.setFont(new Font("arial",Font.BOLD,30));
    p3.add(l1);
    p1.add(p3);

     p2.setLayout(new GridLayout(1,10));
     for(int i=0;i<10;i++)
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
           rs=stmt.executeQuery("select * from employee");
           while(rs.next())
           {
               String s=rs.getString("email_id");
              
               
                stmt1=conn.createStatement();
                //stmt1.executeUpdate("delete * from applied_jobs");
                rs1=stmt1.executeQuery("select * from applied_jobs");

               while(rs1.next())
               {
                company=rs1.getString("c_id");
                  String job_id=rs1.getString("job_id");
                  String employee_id=rs1.getString("email_id");
                   String str1=rs1.getString("status");
                 
if(company.equals(email)&&job_id.equals(j_id)&&s.equals(employee_id)&&(str1.equals("waiting")||str1.equals("accepted")))
{
if(str1.equals("accepted"))
{
    flag[c]=1;
   
}
    else
        flag[c]=0;
System.out.println(flag[c]);
               email_id[c]=s;
                
                 fname[c]=rs.getString("first_name");
                 System.out.println(fname[c]);

                 lname[c]=rs.getString("last_name");
                 System.out.println(lname[c]);
                 gender[c]=rs.getString("gender");
                 System.out.println(gender[c]);
                 e[c]=rs.getString("email");
                 System.out.println(e[c]);
                 contact[c]=rs.getString("contact_no");
                 expy[c]=rs.getString("exp_year");
                 qual[c]=rs.getString("qualifications");
                 resume[c]=rs.getString("resume");
                 c++;


                      }

                       }
                
                   
                   
               
               





    }


    for(int i=0;i<c;i++)
      {

             arr[i][0]=fname[i]+" "+lname[i].trim();
             // arr[i][1]=lname[i];
              arr[i][1]=gender[i];
              arr[i][2]=e[i];
              arr[i][3]=contact[i];
                arr[i][4]=expy[i];
                  arr[i][5]=qual[i];
                arr[i][6]=resume[i];
                arr[i][7]=email_id[i];
      }
           for(int i=0;i<c;i++)
           {
               for(int k=0;k<=7;k++)
               {
                              System.out.print(arr[i][k]+"\t\t");
           }
System.out.println();
           }

       for(int i=0;i<c;i++)
           {
           panel[i]=new JPanel();

           panel[i].setLayout(new GridLayout(1,10));
               for(int k=0;k<=5;k++)

               {

                       panel[i].add(new JLabel(arr[i][k]));



          }
            b2[i]=    new JButton("View");
           b[i]=    new JButton("Accept");
           b3[i]=    new JButton("Call");
           b1[i]=    new JButton("Reject");
            panel[i].add(b2[i]);
            panel[i].add(b[i]);
System.out.println("Button is="+str2);

             if(flag[i]==1)
             {
     b[i].setEnabled(false);
         b[i].setText("accepted");
         b1[i].setEnabled(false);

 }
            panel[i].add(b1[i]);
              panel[i].add(b3[i]);
p1.add(panel[i]);
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
    b[i].addActionListener( this);
    b1[i].addActionListener(this);
    b2[i].addActionListener(this);
     b3[i].addActionListener(this);
}
    }




    public void actionPerformed(ActionEvent ae)
    {
        for(int i=0;i<c;i++)
        {


        if(ae.getSource()==b2[i])
        {
            		File pdfFile = new File(resume[i]);

System.out.println(pdfFile);
try
{
		if (pdfFile.exists()) {

			if (Desktop.isDesktopSupported())
                        {
				Desktop.getDesktop().open(pdfFile);
			} else {
				System.out.println("Awt Desktop is not supported!");
			}

		} else {
			System.out.println("File does not exist!");
		}

		System.out.println("Done");
        }

	  catch (Exception ex)
	{
		ex.printStackTrace();
	  }


    }

          if(ae.getSource()==b[i])
            {
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
            String str2=rs.getString("job_id");
            if(str.equals(email_id[i])&&str2.equals(j_id))
            {
                s=rs.getInt("ID");
            System.out.println("Value of s is"+s);
           
            stmt.executeUpdate("update applied_jobs set status='accepted' where ID="+s );
            //b[i].setVisible(false);
        
            b[i].setEnabled(false);
         b[i].setText("accepted");
         b1[i].setEnabled(false);
       
              b3[i].setEnabled(true);
            }}
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
           rs=stmt.executeQuery("select * from applied_jobs");
           while(rs.next())
           {
            String str=rs.getString("email_id");
           String str2=rs.getString("job_id");

            if(str.equals(email_id[i])&&str2.equals(j_id))
            {
                
                s=rs.getInt("ID");
           }
           }
            stmt.executeUpdate("update applied_jobs set status='Rejected' where ID="+s );
            //b[i].setVisible(false);
         b1[i].setEnabled(false);
         b1[i].setText("rejected");
          b[i].setEnabled(false);

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
        if(ae.getSource()==b3[i])
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
           String str2=rs.getString("job_id");

            if(str.equals(email_id[i])&&str2.equals(j_id))
            {

                s=rs.getInt("ID");
                System.out.println("Company id="+company);
                  new interview_call(str,str2,company).setVisible(true);
           }
           }

             stmt.executeUpdate("update applied_jobs set call='called' where ID="+s );
         

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
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Applications");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1161, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new applications("abcd","567").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
