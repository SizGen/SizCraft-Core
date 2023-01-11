package com.sizcraft.core;

import com.sizcraft.core.commands.GiveCommand;
import com.sizcraft.core.files.ConfigFile;
import com.sizcraft.core.files.MessageFile;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class CoreMain extends JavaPlugin {

    private ConfigFile configFile;
    private MessageFile messageFile;

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

//            configFile.reload();
//            messageFile.reload();
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
