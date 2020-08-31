package me.mical.becaptcha.config;

import me.mical.becaptcha.BeCaptcha;
import org.serverct.parrot.parrotx.config.PConfig;

import java.io.File;
import java.util.List;

public class ConfigManager extends PConfig {

    public static int captchaIndex;
    public static List<String> commandList;
    public static int timedOut;

    public ConfigManager() {
        super(BeCaptcha.getInstance(), "config", "主配置文件");
    }

    @Override
    public void load(File var) {
        captchaIndex = getConfig().getInt("Captcha.Index");
        commandList = getConfig().getStringList("Commands");
        timedOut = getConfig().getInt("TimedOut");
    }
}
