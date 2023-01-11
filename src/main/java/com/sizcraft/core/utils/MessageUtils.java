package com.sizcraft.core.utils;

import com.sizcraft.core.CoreMain;
import com.sizcraft.core.files.ConfigFile;
import com.sizcraft.core.files.MessageFile;
import org.bukkit.entity.Player;

public class MessageUtils {

    private static MessageFile messageFile;
    private static ConfigFile configFile;

    public MessageUtils(CoreMain plugin) {
        messageFile = plugin.getMessageFile();
        configFile = plugin.getConfigFile();
    }

    public static void sendMessageFromFile(Player player, String message, boolean prefix) {
        String prefixString = "";
        if (prefix) {
            prefixString = configFile.getString("prefix");
        }
        player.sendMessage(ColorUtils.colorize(prefixString + " " + messageFile.getString(message)));
    }

    public static void sendMessage(Player player, String message, boolean prefix) {
        String prefixString = "";
        if (prefix) {
            prefixString = configFile.getString("prefix");
        }
        player.sendMessage(ColorUtils.colorize(prefixString + " " + message));
    }

    public static void sendErrorMessageFromFile(Player player, String message) {
        player.sendMessage(ColorUtils.colorize("&4[ERROR]" + messageFile.getString(message)));
    }

    public static void sendErrorMessage(Player player, String message) {
        player.sendMessage(ColorUtils.colorize("&4[ERROR]" + message));
    }

}
