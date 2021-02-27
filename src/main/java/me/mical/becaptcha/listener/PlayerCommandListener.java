package me.mical.becaptcha.listener;

import me.mical.becaptcha.BeCaptcha;
import me.mical.becaptcha.config.ConfigManager;
import me.mical.becaptcha.data.CaptchaConversation;
import me.mical.becaptcha.utils.CaptchaUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.serverct.parrot.parrotx.api.ParrotXAPI;
import org.serverct.parrot.parrotx.data.autoload.annotations.PAutoload;
import org.serverct.parrot.parrotx.utils.ConversationUtil;

@PAutoload
public class PlayerCommandListener implements Listener {

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        final String commandLine = event.getMessage().replace("/", "");
        if (ConfigManager.commandList.contains(event.getMessage().replace("/", ""))) {
            ConversationUtil.start(ParrotXAPI.getPlugin(BeCaptcha.class),
                    event.getPlayer(),
                    new CaptchaConversation(
                            event.getPlayer(),
                            CaptchaUtil.generate(ConfigManager.captchaIndex),
                            commandLine
                    ),
                    ConfigManager.timedOut,
                    ParrotXAPI.getPlugin(BeCaptcha.class).getLang().data.getWarn(
                            "Lang",
                            "TimedOut",
                            ConfigManager.timedOut)
            );
        }
    }
}
