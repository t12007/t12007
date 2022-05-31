package minecrafttest.minecrafttest.eventList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import static org.bukkit.Bukkit.getLogger;

public class ConnectionMessage{
    private static String TITLE;
    private static int FADEINTIME;
    private static int SHOWTIME;


    public ConnectionMessage(String title, int FadeInTime, int ShowTime){
        TITLE = title;
        FADEINTIME = FadeInTime;
        SHOWTIME = ShowTime;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        getLogger().info(TITLE + "//" + player.getName());
        player.sendMessage(TITLE + "//" + player.getName());
    }

}
