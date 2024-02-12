package towel.coin_shop.EventHandler;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import towel.coin_shop.Coin_shop;
import towel.coin_shop.db.JDBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class npctest implements Listener {

    ItemStack copper_coin=new ItemStack(Material.DIAMOND);
    ArrayList<ItemMeta> copper_coin_ItemMeta=
            new ArrayList<>(List.of
                            (copper_coin.getItemMeta(),
                             copper_coin.getItemMeta(),
                             copper_coin.getItemMeta(),
                             copper_coin.getItemMeta(),
                             copper_coin.getItemMeta(),
                             copper_coin.getItemMeta()));
    private final Coin_shop Coin_shop;

    public npctest(Coin_shop Coin_shop){
        this.Coin_shop=Coin_shop;
    }
    public List<String> buyNore(String buy_price){
        List<String> temp=new ArrayList<>
                (List.of("",
                            ChatColor.WHITE+"\uE222"+" "+ChatColor.DARK_GRAY+ChatColor.BOLD+buy_price+ChatColor.WHITE+"\uE333"
                ));
        return temp;
    }
    @EventHandler
    public void insertPlayer(PlayerJoinEvent e) throws SQLException {
        JDBConnector connector=Coin_shop.getDB();
        ResultSet rs=connector.searchPlayer(e.getPlayer().getUniqueId());
        if(!rs.next())
        connector.insertPlayer(e.getPlayer().getUniqueId());
    }
    @EventHandler
    public void RightClickNPC(NPCRightClickEvent e){
        ArrayList<String> coin_name=new ArrayList<String>(List.of
               (ChatColor.GOLD + "" + ChatColor.BOLD +"동리퍼",
                ChatColor.GRAY + "" + ChatColor.BOLD +"은리퍼",
                ChatColor.YELLOW + "" + ChatColor.BOLD +"금리퍼",
                ChatColor.AQUA + "" + ChatColor.BOLD +"다이아리퍼",
                ChatColor.DARK_GRAY + "" + ChatColor.BOLD +"네더리퍼",
                ChatColor.BOLD + "마을귀환서"));
        if(1==e.getNPC().getId()){
            Player player=e.getClicker();
            Inventory inventory=Bukkit.createInventory(player,54, "\uE111"+ChatColor.WHITE+"\uE000");
            player.openInventory(inventory);
                copper_coin_ItemMeta.get(0).setLore(buyNore("100"));
                copper_coin_ItemMeta.get(1).setLore(buyNore("1000"));
                copper_coin_ItemMeta.get(2).setLore(buyNore("10000"));
                copper_coin_ItemMeta.get(3).setLore(buyNore("100000"));
                copper_coin_ItemMeta.get(4).setLore(buyNore("1000000"));
                copper_coin_ItemMeta.get(5).setLore(buyNore("3000"));
            for(int i=1; i<7; i++) {
                copper_coin_ItemMeta.get(i-1).setCustomModelData(i);
                copper_coin_ItemMeta.get(i-1).setDisplayName(coin_name.get(i-1));
                copper_coin.setItemMeta(copper_coin_ItemMeta.get(i-1));
                inventory.setItem(10+i,copper_coin);
            }
        }

    }

}
