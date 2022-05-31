package minecrafttest.minecrafttest;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventListener{
    public EventListener(){
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        player.sendMessage("혼저옵서예//" + player.getName());
    }
}
