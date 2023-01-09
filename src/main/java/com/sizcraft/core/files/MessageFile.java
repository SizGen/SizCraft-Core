package com.sizcraft.core.files;

import com.sizcraft.core.CoreMain;

import java.io.IOException;

public class MessageFile extends CustomFile {

    public MessageFile(CoreMain plugin) throws IOException {
        super(plugin, "messages");
    }

}
