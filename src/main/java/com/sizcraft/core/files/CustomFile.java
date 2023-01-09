package com.sizcraft.core.files;

import com.sizcraft.core.CoreMain;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public abstract class CustomFile {

    private final String name;
    private final File file;
    private YamlConfiguration configuration;

    public CustomFile(CoreMain plugin, String name) throws IOException {
        this.name = name;

        this.file = new File(plugin.getDataFolder(), name + ".yml");
        if (!file.exists()) file.createNewFile();
        this.configuration = YamlConfiguration.loadConfiguration(file);
    }

    public void reload() throws IOException {
        save();
        configuration = YamlConfiguration.loadConfiguration(file);
    }

    public void save() throws IOException {
        configuration.save(file);
    }

    public String getName() {
        return name;
    }

    public File getFile() {
        return file;
    }

    public YamlConfiguration getConfiguration() {
        return configuration;
    }

}