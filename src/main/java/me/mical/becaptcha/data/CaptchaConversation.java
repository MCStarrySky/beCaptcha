package me.mical.becaptcha.data;

import me.mical.becaptcha.BeCaptcha;
import org.bukkit.Bukkit;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.StringPrompt;
import org.bukkit.entity.Player;
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
        return plugin.lang.getWithFormat(plugin.localeKey, I18n.Type.WARN, "Lang", "EnterCaptcha", commandLine, captcha);
    }

    @Override
    public Prompt acceptInput(ConversationContext context, String input) {
        if (Objects.equals(input, captcha)) {
            Bukkit.dispatchCommand(user, commandLine);
            String sucMsg = plugin.lang.get(plugin.localeKey, I18n.Type.INFO, "Lang", "Successful");
            I18n.send(user, sucMsg);
        } else {
            String failMsg = plugin.lang.get(plugin.localeKey, I18n.Type.ERROR, "Lang", "InvalidCaptcha");
            I18n.send(user, failMsg);
        }
        if (Objects.equals(input.toLowerCase(), "cancel")) {
            String cancelMsg = plugin.lang.get(plugin.localeKey, I18n.Type.WARN, "Lang", "CancelTask");
            I18n.send(user, cancelMsg);
        }
        return END_OF_CONVERSATION;
    }
}
