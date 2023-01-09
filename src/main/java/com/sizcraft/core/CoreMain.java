package com.sizcraft.core;

import com.sizcraft.core.commands.GiveCommand;
import com.sizcraft.core.files.ConfigFile;
import com.sizcraft.core.files.MessageFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class CoreMain extends JavaPlugin {

    // Files
    private ConfigFile configFile;
    private MessageFile messageFile;

    @Override
    public void onEnable() {

        loadFiles();

        registerManagers();
        registerCommands();
        registerListeners();

    }

    private void loadFiles() {

        getDataFolder().mkdirs();

        try {
            configFile = new ConfigFile(this);
            messageFile = new MessageFile(this);

            configFile.reload();
            messageFile.reload();

            configFile.save();
            messageFile.save();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void registerManagers() { }

    private void registerCommands() {
        new GiveCommand(this);
    }

    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
    }

    public ConfigFile getConfigFile() { return configFile; }
    public MessageFile getMessageFile() { return messageFile; }

}
