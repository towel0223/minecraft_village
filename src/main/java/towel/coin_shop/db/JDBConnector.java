package towel.coin_shop.db;

import java.sql.*;
import java.util.UUID;

public class JDBConnector {
    private Connection connection;


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
        PreparedStatement psmt=connection.prepareStatement
                ("insert into player(uuid) values (?)");
        psmt.setString(1,uuid.toString());
        int i=psmt.executeUpdate();
        psmt.close();

        return i;
    }
    public ResultSet searchPlayer(UUID uuid){
        connection=getConnection();
        try {
            PreparedStatement psmt=connection.prepareStatement("select * from Player where uuid= ?");
            psmt.setString(1,uuid.toString());

            return psmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
