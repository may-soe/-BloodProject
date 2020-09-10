/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Pack;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class mySQLQueries {
static Connection con = null;
static Statement stmt;
static String query , query1;
ResultSet rs;
DBConnection connect = new DBConnection();
public mySQLQueries()
{
    try{
        con=connect.GetMySQLConnection();
    }catch(ClassNotFoundException cnfe)
    {
        System.out.println(cnfe);
    }catch(SQLException sqle)
    {
        System.out.println(sqle);
    }catch(Exception e)
    {
        e.printStackTrace();
    }
}
public static boolean insertData(String tbName , String[]data)
{
    if(tbName.equals("bloodtype"))
    {
        query = "insert into bloodtype(bloodtypeid,bloodtype)values ('"+data[0]+"','"+data[1]+"')";
    }
    else if(tbName.equals("blood"))
    {
        query = "insert into blood(bloodid,bloodtypeid,quantity)values('"+data[0]+"','"+data[1]+"','"+Integer.parseInt(data[2])+"')";
    }
    else if(tbName.equals("donor"))
    {
        query = "insert into donor(donorid,staffid,fullname,nrc,gender,lastDonateDate,nextDonateDate,bloodtype,phoneno,dateofBith,address,township,diseases,staffid)"
        		+ "values('"+data[0]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"','"+data[5]+"','"+data[6]+"','"+data[7]+"','"+data[8]+"','"+data[9]+"','"+data[10]+"','"+data[11]+"','"+data[12]+"',"+data[13]+"','"+data[1]+"')";
    }
    else if(tbName.equals("staff"))
	{	
    	query="insert into staff(staffid,name,password,nrc,address,email,phoneno,roll) values('"+ data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"','"+data[5]+"','"+data[6]+"','"+data[7]+"')";	
    }
    try{
        stmt = con.createStatement();
        System.out.println(query);
        if(stmt.executeUpdate(query)==1)
        {
            return true;
        }
        else return false;
    }catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null,e.getMessage());
        e.printStackTrace();
        return false;
    }
}

public boolean isduplicate(String tbName , String []data)
{
    if(tbName.equals("bloodtype"))
    {
        query = "select * from bloodtype where bloodtype='"+data[0]+"'";
    }
   
    System.out.println(query);
    try{
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);
        if(rs.next())
            return true;
        else
            return false;
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.getMessage(),"SQLException",JOptionPane.ERROR_MESSAGE);
        return false;
    }
}


public String getAutoid(String field , String tabel , String prefix)
{
    if(tabel.equals("bloodtype")||tabel.equals("staff"))
    {
        return connect.getPrimaryKey2(field, tabel, prefix);
    }
    else
    {
        return connect.getPrimaryKey(field, tabel, prefix);
    }

}

public String[] getIDForChoice(String tbName) throws Throwable {
	if (tbName.equals("blood")) {
		rs = connect.SQLSelect("bloodid", tbName);
	}
	else if (tbName.equals("bloodtype")) {
		rs = connect.SQLSelect("bloodtypeid", tbName);
	}
	int rowcount = 0;
	while (rs.next()) {
		rowcount++;
	}
	
	String temp[] = new String[rowcount];
	rs.beforeFirst();
	int i = 0;
	
	while (rs.next()) {
		temp[i] = rs.getString(1);
		i++;
	}
	return temp;
}

public String getBloodTypeName(String bloodtypeid) {
	try {
		String bloodtypename;
		stmt = con.createStatement();
		query = "select * from bloodtype where bloodtypeid='"+bloodtypeid+"';";
		rs = stmt.executeQuery(query);
		rs.next();
		bloodtypename = rs.getString(2);
		return bloodtypename;
	} catch (SQLException e) {
		System.out.println(e);
		return null;
	}
}

///////////////////////////////////////////////////////////////////////////////////////

public boolean ExcuteSQL(String query)
{
    return connect.ExecuteSQL(query);
}
public static void main(String args[])throws SQLException
{
    mySQLQueries sq = new mySQLQueries();
}

}
