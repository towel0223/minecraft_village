package towel.coin_shop;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;
import towel.coin_shop.EventHandler.npctest;
import towel.coin_shop.db.JDBConnector;
import towel.coin_shop.models.Player_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class Coin_shop extends JavaPlugin {

    private JDBConnector jdbConnector;
    @Override
    public void onEnable() {
        jdbConnector =new JDBConnector();
        getServer().getPluginManager().registerEvents(new npctest(this),this);

    }
    @Override
    public void onDisable() {


    }

    public JDBConnector getDB(){
        return jdbConnector;
    }

}
