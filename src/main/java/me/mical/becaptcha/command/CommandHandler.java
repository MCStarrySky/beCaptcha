package me.mical.becaptcha.command;

import me.mical.becaptcha.BeCaptcha;
import org.serverct.parrot.parrotx.api.ParrotXAPI;
import org.serverct.parrot.parrotx.command.subcommands.DebugCommand;
import org.serverct.parrot.parrotx.command.subcommands.HelpCommand;
import org.serverct.parrot.parrotx.command.subcommands.ReloadCommand;
import org.serverct.parrot.parrotx.command.subcommands.VersionCommand;
import org.serverct.parrot.parrotx.data.autoload.annotations.PAutoload;

@PAutoload
@SuppressWarnings("unused")
public class CommandHandler extends org.serverct.parrot.parrotx.command.CommandHandler {
    public CommandHandler() {
        super(ParrotXAPI.getPlugin(BeCaptcha.class), "becaptcha");
        register(new ReloadCommand(plugin, ".reload"));
        register(new VersionCommand(plugin));
        register(new HelpCommand(plugin));
        register(new DebugCommand(plugin, ".debug"));
    }
}
