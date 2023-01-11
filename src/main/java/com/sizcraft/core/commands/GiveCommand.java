package com.sizcraft.core.commands;

import com.sizcraft.core.CoreMain;
import com.sizcraft.core.files.MessageFile;
import com.sizcraft.core.utils.ColorUtils;
import com.sizcraft.core.utils.MessageUtils;
import org.apache.logging.log4j.message.Message;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class GiveCommand extends Command {

    private final CoreMain plugin;
    private final MessageFile messageFile;

    public GiveCommand(CoreMain plugin) {
        super(
                "give",
                new String[]{},
                "Give a item to a player",
                "sizcraft.give"
        );
        this.plugin = plugin;
        this.messageFile = plugin.getMessageFile();
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof Player player) {
            if(args.length == 1) {
                ItemStack itemStack = new ItemStack(Material.valueOf(args[0].toUpperCase()));
                player.getInventory().addItem(itemStack);
                MessageUtils.sendMessageFromFile(player, "give", true);
            } else if (args.length == 2) {
                Player target = plugin.getServer().getPlayer(args[0]);
                if (target == null) {
                    MessageUtils.sendErrorMessageFromFile(player, "player-not-online");
                    return;
                }
                ItemStack itemStack = new ItemStack(Material.valueOf(args[1].toUpperCase()));
                target.getInventory().addItem(itemStack);
                MessageUtils.sendMessageFromFile(player, "give", true);
            } else if (args.length == 3) {
                Player target = plugin.getServer().getPlayer(args[0]);
                if (target == null) {
                    MessageUtils.sendErrorMessageFromFile(player, "player-not-online");
                    return;
                }
                ItemStack itemStack = new ItemStack(Material.valueOf(args[1].toUpperCase()), Integer.parseInt(args[2]));
                target.getInventory().addItem(itemStack);
                MessageUtils.sendMessageFromFile(player, "give", true);
            }
        } else {
            sender.sendMessage(ColorUtils.colorize(messageFile.getString("not-a-player")));
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
