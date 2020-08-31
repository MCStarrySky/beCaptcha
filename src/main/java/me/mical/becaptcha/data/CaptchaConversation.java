package me.mical.becaptcha.data;

import me.mical.becaptcha.BeCaptcha;
import me.mical.becaptcha.config.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.StringPrompt;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.serverct.parrot.parrotx.PPlugin;
import org.serverct.parrot.parrotx.utils.I18n;

import java.util.Objects;

public class CaptchaConversation extends StringPrompt {

    private final PPlugin plugin;
    private final Player user;
    private final String captcha;
    private final String commandLine;

    public CaptchaConversation(Player user, String captcha, String commandLine) {
        this.plugin = BeCaptcha.getInstance();
        this.user = user;
        this.captcha = captcha;
        this.commandLine = commandLine;
    }

    @Override
    public String getPromptText(ConversationContext context) {
        int timedOut = ConfigManager.timedOut;
        return plugin.lang.getWithFormat(plugin.localeKey, I18n.Type.WARN, "Lang", "EnterCaptcha", commandLine, captcha, timedOut);
    }

    @Override
    public Prompt acceptInput(ConversationContext context, String input) {
        if (Objects.isNull(input) || Objects.equals(input.toLowerCase(), "cancel")) {
            String cancelMsg = plugin.lang.get(plugin.localeKey, I18n.Type.WARN, "Lang", "CancelTask");
            I18n.sendAsync(plugin, user, cancelMsg);
            return END_OF_CONVERSATION;
        }
        if (Objects.equals(input, captcha)) {
            String sucMsg = plugin.lang.get(plugin.localeKey, I18n.Type.INFO, "Lang", "Successful");
            I18n.sendAsync(plugin, user, sucMsg);
            new BukkitRunnable() {
                @Override
                public void run() {
                    Bukkit.dispatchCommand(user, commandLine);
                }
            }.runTaskLater(plugin, 1);
        } else {
            String failMsg = plugin.lang.get(plugin.localeKey, I18n.Type.ERROR, "Lang", "InvalidCaptcha");
            I18n.sendAsync(plugin, user, failMsg);
        }
        return END_OF_CONVERSATION;
    }
}
