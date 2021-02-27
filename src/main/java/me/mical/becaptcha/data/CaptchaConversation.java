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
import org.serverct.parrot.parrotx.api.ParrotXAPI;
import org.serverct.parrot.parrotx.utils.i18n.I18n;

import java.util.Objects;

public class CaptchaConversation extends StringPrompt {

    private final PPlugin plugin;
    private final I18n lang;
    private final Player user;
    private final String captcha;
    private final String commandLine;

    public CaptchaConversation(Player user, String captcha, String commandLine) {
        this.plugin = ParrotXAPI.getPlugin(BeCaptcha.class);
        this.lang = plugin.getLang();
        this.user = user;
        this.captcha = captcha;
        this.commandLine = commandLine;
    }

    @Override
    public String getPromptText(ConversationContext context) {
        return lang.data.getWarn("Lang", "EnterCaptcha", commandLine, captcha, ConfigManager.timedOut);
    }

    @Override
    public Prompt acceptInput(ConversationContext context, String input) {
        if (Objects.isNull(input) || Objects.equals(input.toLowerCase(), "cancel")) {
            I18n.sendAsync(plugin, user, lang.data.getWarn("Lang", "CancelTask"));
            return END_OF_CONVERSATION;
        }
        if (Objects.equals(input, captcha)) {
            I18n.sendAsync(plugin, user, lang.data.getInfo("Lang", "Successful"));
            new BukkitRunnable() {
                @Override
                public void run() {
                    Bukkit.dispatchCommand(user, commandLine);
                }
            }.runTaskLater(plugin, 1);
        } else {
            I18n.sendAsync(plugin, user, lang.data.getError("Lang", "InvalidCaptcha"));
        }
        return END_OF_CONVERSATION;
    }
}
