package com.sizcraft.core.files;

import com.sizcraft.core.CoreMain;

import java.io.IOException;

public class ConfigFile extends CustomFile {

    public ConfigFile(CoreMain plugin) throws IOException {
        super(plugin, "config");
    }
}
