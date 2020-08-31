package me.mical.becaptcha;

import me.mical.becaptcha.command.CommandHandler;
import me.mical.becaptcha.config.ConfigManager;
import me.mical.becaptcha.listener.PlayerCommandListener;
import org.bukkit.Bukkit;
import org.serverct.parrot.parrotx.PPlugin;
import org.serverct.parrot.parrotx.utils.I18n;

public final class BeCaptcha extends PPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    protected void preload() {
        printLogo();
        lang.log("正在加载 &cBECaptcha &7, 版本 &c" + getDescription().getVersion() + " &7, 作者 &cMical&7.", I18n.Type.INFO, false);
        pConfig = new ConfigManager();
    }

    @Override
    protected void load() {
        registerCommand(new CommandHandler());
        listen(pluginManager -> pluginManager.registerEvents(new PlayerCommandListener(), this));
        lang.log("插件已加载.", I18n.Type.INFO, false);
    }

    @Override
    public void onDisable() {
        lang.log("插件已卸载.", I18n.Type.INFO, false);
    }

    private void printLogo() {
        String[] logoFormat = {
                "",
                I18n.color("&f______________________________                __         .__            "),
                I18n.color("&f\\______   \\_   _____/\\_   ___ \\_____  _______/  |_  ____ |  |__ _____   "),
                I18n.color("&f |    |  _/|    __)_ /    \\  \\/\\__  \\ \\____ \\   __\\/ ___\\|  |  \\\\__  \\  "),
                I18n.color("&f |    |   \\|        \\\\     \\____/ __ \\|  |_> >  | \\  \\___|   Y  \\/ __ \\_"),
                I18n.color("&f |______  /_______  / \\______  (____  /   __/|__|  \\___  >___|  (____  /"),
                I18n.color("&f        \\/        \\/         \\/     \\/|__|             \\/     \\/     \\/ "),
                ""
        };
        Bukkit.getConsoleSender().sendMessage(logoFormat);
    }
}
