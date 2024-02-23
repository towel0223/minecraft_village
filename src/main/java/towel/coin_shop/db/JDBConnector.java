package towel.coin_shop.db;

import java.sql.*;
import java.util.UUID;

public class JDBConnector {
    private Connection connection;
    private PreparedStatement psmt;
    private Statement stmt;
    private ResultSet rs;
    private int num;

    public Connection getConnection(){
        if(connection!=null)
        return connection;
        String url="jdbc:mysql://localhost:3306/mincraft_towel_village";
        String id="root";
        String pw="1234";
        try{
            connection= DriverManager.getConnection(url,id,pw);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return connection;}

    public int insertPlayer(UUID uuid) throws SQLException {
        connection=getConnection();
        psmt=connection.prepareStatement
                ("insert into player(uuid) values (?)");
        psmt.setString(1,uuid.toString());
        num=psmt.executeUpdate();
        psmt.close();

        return num;
    }
    public ResultSet searchPlayer(UUID uuid){
        connection=getConnection();
        try {
            psmt=connection.prepareStatement("select * from Player where uuid= ?");
            psmt.setString(1,uuid.toString());
            rs=psmt.executeQuery();
            psmt.close();
            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void addMoney(UUID uuid,int Money){
        connection=getConnection();
        try{
            psmt=connection.prepareStatement("update Player set money = money + ? where uuid = ?");
            psmt.setInt(1,Money);
            psmt.setString(2,uuid.toString());
            psmt.executeUpdate();
            psmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void resetMoney(UUID uuid){
        connection=getConnection();
        try{
            psmt=connection.prepareStatement("update Player set money = 0 where uuid = ?");
            psmt.setString(1,uuid.toString());
            psmt.executeUpdate();
            psmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
