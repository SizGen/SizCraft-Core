package com.sizcraft.core;

import com.sizcraft.core.commands.GiveCommand;
import com.sizcraft.core.files.ConfigFile;
import com.sizcraft.core.files.MessageFile;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class CoreMain extends JavaPlugin {

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
//            configFile = new ConfigFile(this);
//            messageFile = new MessageFile(this);
//
////            FileUtils.copyToFile(this.getResource("messages.yml"), new File(getDataFolder() + "/messages.yml"));
//
//            configFile.reload();
//            messageFile.reload();
//
//            configFile.save();
//            messageFile.save();

        try {
            saveResource("messages.yml", false);
            File file = new File(getDataFolder(), "messages.yml");
            YamlConfiguration fileConfig = YamlConfiguration.loadConfiguration(file);
            fileConfig.save(file);
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
