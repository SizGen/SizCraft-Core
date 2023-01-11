package com.sizcraft.core;

import com.sizcraft.core.commands.GiveCommand;
import com.sizcraft.core.files.ConfigFile;
import com.sizcraft.core.files.MessageFile;
import com.sizcraft.core.utils.MessageUtils;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class CoreMain extends JavaPlugin {

    private ConfigFile configFile;
    private MessageFile messageFile;

    private MessageUtils messageUtils;

    @Override
    public void onEnable() {

        try {
            loadFiles();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        registerManagers();
        registerCommands();
        registerListeners();

    }

    private void loadFiles() throws IOException {

        getDataFolder().mkdirs();

        configFile = new ConfigFile(this);
        messageFile = new MessageFile(this);

        configFile.reload();
        messageFile.reload();
    }

    private void registerManagers() {
        messageUtils = new MessageUtils(this);
    }

    private void registerCommands() {
        new GiveCommand(this);
    }

    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
    }

    public ConfigFile getConfigFile() { return configFile; }
    public MessageFile getMessageFile() { return messageFile; }

}
