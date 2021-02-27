package me.mical.becaptcha.config;

import me.mical.becaptcha.BeCaptcha;
import org.serverct.parrot.parrotx.api.ParrotXAPI;
import org.serverct.parrot.parrotx.config.PConfig;
import org.serverct.parrot.parrotx.data.autoload.annotations.PAutoload;
import org.serverct.parrot.parrotx.data.autoload.annotations.PAutoloadGroup;

import java.util.List;
import java.util.Objects;

@PAutoloadGroup
public class ConfigManager extends PConfig {

    private static ConfigManager instance;


    @PAutoload("CaptchaIndex")
    public static int captchaIndex;
    @PAutoload("Commands")
    public static List<String> commandList;
    @PAutoload("TimeOut")
    public static int timedOut;

    public ConfigManager() {
        super(ParrotXAPI.getPlugin(BeCaptcha.class), "config", "主配置文件");
    }

    public static ConfigManager getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ConfigManager();
        }
        return instance;
    }
}
