package uz.SadJi.sadJiSRPChat;

import org.bukkit.plugin.java.JavaPlugin;
import uz.SadJi.sadJiSRPChat.Events.ChatListener;

import java.util.logging.Logger;

import static java.rmi.server.LogStream.log;

public final class SadJiSRPChat extends JavaPlugin {

    Logger log = getLogger();
    private static SadJiSRPChat plugin;
    public static SadJiSRPChat getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {

        saveConfig();

        plugin = this;

        log("[=-=-=-=-=-=-==-=-=-=-=-=]");
        log("          RP Chat           ");
        log("[=-=-=-=-=-=-==-=-=-=-=-=]");
        log("           v1.0a");
        log("[=-=-=-=-=-=-==-=-=-=-=-=]");
        log("          ENABLED");
        log("[=-=-=-=-=-=-==-=-=-=-=-=]");

        getServer().getPluginManager().registerEvents(new ChatListener(), this);
    }

    @Override
    public void onDisable() {
        saveConfig();
        log("[=-=-=-=-=-=-==-=-=-=-=-=]");
        log("          RP Chat           ");
        log("[=-=-=-=-=-=-==-=-=-=-=-=]");
        log("          v1.0a");
        log("[=-=-=-=-=-=-==-=-=-=-=-=]");
        log("       For support:");
        log("    Telegram: @ItzzS4dJ1");
        log("     Discord: @itzsadji");
        log("[=-=-=-=-=-=-==-=-=-=-=-=]");

    }
}
