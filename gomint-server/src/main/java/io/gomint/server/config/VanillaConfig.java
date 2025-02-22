package io.gomint.server.config;

import io.gomint.config.YamlConfig;
import io.gomint.config.annotation.Comment;

/**
 * @author geNAZt
 * @version 1.0
 */
public class VanillaConfig extends YamlConfig {

    @Comment("Disable the sprint reset when you hit something?")
    private boolean disableSprintReset = false;

    public boolean disableSprintReset() {
        return this.disableSprintReset;
    }
}
