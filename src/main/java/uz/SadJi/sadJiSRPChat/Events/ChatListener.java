package uz.SadJi.sadJiSRPChat.Events;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import uz.SadJi.sadJiSRPChat.SadJiSRPChat;

public final class ChatListener implements Listener {

    @EventHandler
    public void RP_Check(AsyncPlayerChatEvent event) {
        FileConfiguration config = SadJiSRPChat.getPlugin().getConfig();
        String message = event.getMessage(); // получи Сообщение
        Player player = event.getPlayer(); // Получи отправителя
        String plname = player.getDisplayName(); // Получи имя игрока
        Location playerLocation = event.getPlayer().getLocation();
        int NRPdistance = config.getInt("NoneRPDistance");
        int ActionDistance = config.getInt("ActionDistance");
        int EnvironmentDistance = config.getInt("EnvironmentDistance");
        int ShoutDistance = config.getInt("ShoutDistance");
        int WhisperDistance = config.getInt("WhisperDistance");
        int Distance = config.getInt("ChatDistance");



        if (message.startsWith("%")) {
            String[] R_Message = message.split("%%", 2);
            for (Player pl : event.getRecipients()) {
                if (pl.getLocation().distance(playerLocation) <= NRPdistance) {
                    pl.sendMessage(ChatColor.of("#7e7e7e") + "NRP: " + plname + ": " + R_Message[1]);
                    event.setCancelled(true);
                } else event.setCancelled(true);
                player.sendMessage("Никто вас не услышал");
            }

        } else if (message.startsWith("!!")) {
            String[] R_Message = message.split("!!", 2);
            Bukkit.broadcastMessage(ChatColor.of("#ffabec") + plname + " " + R_Message[1]);
            event.setCancelled(true);

        } else if (message.startsWith("--")) {
            String[] R_Message = message.split("--", 2);
            for (Player pl : event.getRecipients()) {
                if (pl.getLocation().distance(playerLocation) <= ActionDistance) {
                    pl.sendMessage(ChatColor.of("#f8ffab") + "*" + plname + " " + R_Message[1] + "*");
                    event.setCancelled(true);

                } else {
                    event.setCancelled(true);
                }
            }
        } else if (message.startsWith("-")) {
            String[] R_Message = message.split("%", 2);
            for (Player pl : event.getRecipients()) {
                if (pl.getLocation().distance(playerLocation) <= EnvironmentDistance) {
                    pl.sendMessage(ChatColor.of("#f6f6f6") + "**" + R_Message[1] + "**" + " " + "(" + plname + ")" );
                    event.setCancelled(true);
                } else {
                    event.setCancelled(true);
                }
            }
        } else if (message.startsWith("!")) {
            String[] R_Message = message.split("!", 2);
            for (Player pl : event.getRecipients()) {
                if (pl.getLocation().distance(playerLocation) <= ShoutDistance) {
                    pl.sendMessage(ChatColor.of("#ff5353") + "[" + "\u041a\u0440\u0438\u043a" + "]" + " " + plname + ": " + R_Message[1]);
                    event.setCancelled(true);
                } else {
                    event.setCancelled(true);
                }
            }
        } else if (message.startsWith("-=")) {
            String[] R_Message = message.split("-=", 1);
            for (Player pl : event.getRecipients()) {
                if (pl.getLocation().distance(playerLocation) <= WhisperDistance) {
                    pl.sendMessage(ChatColor.of("#313733") + "[" + "\u0428\u0435\u043f\u043e\u0442" + "]" + " " + plname + ": " + R_Message[1]);
                    event.setCancelled(true);
                } else {
                    event.setCancelled(true);
                }
            }
        } else {
            for (Player pl : event.getRecipients()) {
                if (pl.getLocation().distance(playerLocation) <= Distance) {
                    pl.sendMessage(ChatColor.of("#b5d2d8") + "<" + plname + ">" + ChatColor.of("#b8cbcf") + " " + message);
                    event.setCancelled(true);
                } else {
                    event.setCancelled(true);
                }
            }
        }
    }
}