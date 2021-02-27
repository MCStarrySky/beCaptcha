package me.mical.becaptcha;

import me.mical.becaptcha.config.ConfigManager;
import org.bukkit.Bukkit;
import org.serverct.parrot.parrotx.PPlugin;
import org.serverct.parrot.parrotx.utils.i18n.I18n;

public final class BeCaptcha extends PPlugin {

    @Override
    protected void preload() {
        printLogo();
        lang.log.info("正在加载 &cBECaptcha &7, 版本 &c{0} &7, 作者 &cMical&7.", getDescription().getVersion());
        pConfig = ConfigManager.getInstance();
    }

    @Override
    protected void load() {
        lang.log.info("插件已加载.");
    }

    @Override
    public void onDisable() {
        super.onDisable();
        lang.log.info("插件已卸载.");
    }

    private void printLogo() {
        final String[] logoFormat = {
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
