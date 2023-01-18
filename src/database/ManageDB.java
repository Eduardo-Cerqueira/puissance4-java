package database;
import java.sql.*;

public class ManageDB {

   public static void main( String args[] ) throws SQLException {
      CreateDB();
      InsertDB("oof", "red", "1000");
      SelectTop10DB();
   }

   private static void CreateDB() {
      Connection c = null;
       Statement stmt = null;
       
       try {
          c = DriverManager.getConnection("jdbc:sqlite:data.db");
          //System.out.println("Opened database successfully");
 
          stmt = c.createStatement();
          String sql = "CREATE TABLE IF NOT EXISTS SCORES " +
                         "(ID INTEGER PRIMARY KEY  NOT NULL," +
                         " USERNAME       TEXT     NOT NULL," + 
                         " COLOR          TEXT     NOT NULL," + 
                         " SCORE          TEXT     NOT NULL);"; 
          stmt.executeUpdate(sql);
          stmt.close();
          c.close();
       } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
       }
       //System.out.println("Table created successfully");
   }

   private static void InsertDB(String username, String color, String score) {
      Connection c = null;
      PreparedStatement stmt = null;

      try {
         c = DriverManager.getConnection("jdbc:sqlite:data.db");
         c.setAutoCommit(false);
         //System.out.println("Opened database successfully");
         String sql = "INSERT INTO SCORES (USERNAME, COLOR, SCORE) VALUES (?, ?, ?);";
         
         stmt = c.prepareStatement(sql);
         stmt.setString(1, username);
         stmt.setString(2, color);
         stmt.setString(3, score);
         stmt.executeUpdate();
         
         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      //System.out.println("Records created successfully");
   }

   private static void SelectTop10DB() {
      Connection c = null;
      Statement stmt = null;

      try {
         c = DriverManager.getConnection("jdbc:sqlite:data.db");
         c.setAutoCommit(false);
         //System.out.println("Opened database successfully");
         String sql = "SELECT ROW_NUMBER() OVER (ORDER BY SCORE DESC) AS ROW, * FROM SCORES ORDER BY SCORE DESC LIMIT 10;";
         stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         while (rs.next()) {
            System.out.println("TOP "+ rs.getString("ROW") +" -> "+ rs.getString("USERNAME")+ " : " +rs.getString("SCORE"));
        }
         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      //System.out.println("Records created successfully");
   }
}