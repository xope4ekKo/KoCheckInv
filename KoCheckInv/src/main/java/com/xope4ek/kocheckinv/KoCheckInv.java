package com.xope4ek.kocheckinv;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class KoCheckInv extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("kocheckinv").setExecutor(this);
        this.getCommand("kocheckender").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && command.getName().toLowerCase().equals("kocheckinv")){
            if (args.length == 1){
                if (sender.isOp()) {
                    Player player = Bukkit.getPlayer(args[0]);
                    ((Player) sender).openInventory(player.getInventory()).setTitle(player.getDisplayName() + this.getConfig().get("Owner's Inv"));
                }

                else {
                    sender.sendMessage(ChatColor.DARK_PURPLE + "KoCheckInv > " + ChatColor.WHITE + this.getConfig().get("Not op"));
                }
            }

            else {
                sender.sendMessage(ChatColor.DARK_PURPLE + "KoCheckInv > " + ChatColor.WHITE + this.getConfig().get("Wrong arguments"));
                return false;
            }
        }

        else if (sender instanceof Player && command.getName().toLowerCase().equals("kocheckender")){
            if (args.length == 1){
                if (sender.isOp()) {
                    Player player = Bukkit.getPlayer(args[0]);
                    ((Player) sender).openInventory(player.getEnderChest()).setTitle(player.getDisplayName() + this.getConfig().get("Owner's Ender Chest"));
                }

                else {
                    sender.sendMessage(ChatColor.DARK_PURPLE + "KoCheckInv > " + ChatColor.WHITE + this.getConfig().get("Not op"));
                }
            }

            else {
                sender.sendMessage(ChatColor.DARK_PURPLE + "KoCheckInv > " + ChatColor.WHITE + this.getConfig().get("Wrong arguments"));
                return false;
            }
        }

        return true;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
