package com.sizcraft.core.commands;

import com.sizcraft.core.CoreMain;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class GiveCommand extends Command {

    private final CoreMain plugin;

    public GiveCommand(CoreMain plugin) {
        super(
                "give",
                new String[]{},
                "Give a item to a player",
                "sizcraft.give"
        );
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof Player player) {
            switch (args.length) {
                case 1:
                    ItemStack itemStack = new ItemStack(Material.valueOf(args[0].toUpperCase()));
                    player.getInventory().addItem(itemStack);
                case 2:
                    Player target = plugin.getServer().getPlayer(args[0]);
                    if (target == null) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "That player is not online!"));
                        return;
                    }
                    itemStack = new ItemStack(Material.valueOf(args[1].toUpperCase()));
                    target.getInventory().addItem(itemStack);
                case 3:
                    target = plugin.getServer().getPlayer(args[0]);
                    if (target == null) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "That player is not online!"));
                        return;
                    }
                    itemStack = new ItemStack(Material.valueOf(args[1].toUpperCase()));
                    itemStack.setAmount(Integer.parseInt(args[2]));
                    target.getInventory().addItem(itemStack);
            }
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
