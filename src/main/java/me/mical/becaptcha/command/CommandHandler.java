package me.mical.becaptcha.command;

import me.mical.becaptcha.BeCaptcha;
import org.serverct.parrot.parrotx.command.subcommands.HelpCommand;
import org.serverct.parrot.parrotx.command.subcommands.ReloadCommand;
import org.serverct.parrot.parrotx.command.subcommands.VersionCommand;

public class CommandHandler extends org.serverct.parrot.parrotx.command.CommandHandler {
    public CommandHandler() {
        super(BeCaptcha.getInstance(), "becaptcha");
        register(new ReloadCommand(BeCaptcha.getInstance(), "BeCaptcha.reload"));
        register(new VersionCommand(BeCaptcha.getInstance()));
        register(new HelpCommand(BeCaptcha.getInstance()));
    }
}
