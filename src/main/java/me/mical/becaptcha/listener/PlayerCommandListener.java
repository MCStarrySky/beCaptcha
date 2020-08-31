package me.mical.becaptcha.listener;

import me.mical.becaptcha.BeCaptcha;
import me.mical.becaptcha.config.ConfigManager;
import me.mical.becaptcha.data.CaptchaConversation;
import me.mical.becaptcha.utils.CaptchaUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.serverct.parrot.parrotx.PPlugin;
import org.serverct.parrot.parrotx.utils.ConversationUtil;
import org.serverct.parrot.parrotx.utils.I18n;

import java.util.List;

public class PlayerCommandListener implements Listener {

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        PPlugin plugin = BeCaptcha.getInstance();
        Player user = event.getPlayer();
        String command = event.getMessage();
        String commandLine = command.replace("/", "");
        int index = ConfigManager.captchaIndex;
        List<String> commandList = ConfigManager.commandList;
        int timedOut = ConfigManager.timedOut;
        if (commandList.contains(command)) {
            String timedOutMsg = plugin.lang.getWithFormat(plugin.localeKey, I18n.Type.WARN, "Lang", "TimedOut", timedOut);
            ConversationUtil.start(plugin, user, new CaptchaConversation(user, CaptchaUtil.generate(index), commandLine), timedOut, timedOutMsg);
        }
    }
}
