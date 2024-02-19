package towel.coin_shop.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import towel.coin_shop.Coin_shop;

public class command_towel implements CommandExecutor {
    private final Coin_shop coinShop;

    public command_towel(Coin_shop coinShop){
        this.coinShop=coinShop;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("add")){
            if(sender instanceof Player){
                Player p =(Player)sender;
                if(p.isPermissionSet("towel_op")){
                        coinShop.getDB().addMoney(p.getUniqueId(),Integer.parseInt(args[0]));


                        return true;
                }

                        return true;
            }
        }

        return true;
    }
}
