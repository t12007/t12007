package minecrafttest.minecrafttest;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
/*
    플러그인 시작
    2022-06-01 KDW
*/

public final class MinecraftTest extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("===============================================");
        getLogger().info("bombom's plugin enable - ver.1.0.0");
        getLogger().info("===============================================");
        //이벤트리스너 등록
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("plugin disable");
    }

    //서버접속 이벤트
    /*2022-06-01 KDW*/
/*    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        
        //메시지 생성
        Component mainTitle = Component.text("봄봄월드에 오신것을 환영합니다", NamedTextColor.DARK_GREEN);
        Component subTitle = Component.text("-봄봄-", NamedTextColor.DARK_BLUE);
        Component joinMsg = Component.text(player.getName() + "님 환영합니다");
        
        //메시지 출력
        player.showTitle(Title.title(mainTitle,subTitle));
        e.joinMessage(joinMsg);
    }
    */
    //커멘드 정의
    /*2022-06-01 KDW*/
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        //관리자 커멘드
        if(label.equalsIgnoreCase("super")){
            Player p = (Player) sender;
            //관리자 판단
            if(p.getName().equals("B0MB0M")){
                //명령어 판단
                if(args.length == 1){
                    // 1레벨 명령어
                    if(args[0].equals("gm")){
                        p.sendMessage("관리자입니다.");
                    }
                }else if(args.length >= 2){
                    // 2레벨 명령어
                    if (args[0].equals("notice")){
                        String msg = "";
                        getLogger().info("=================================");
                        for(int i=1;i<args.length;i++){
                            msg = msg + " " + args[i];
                        }
                        getLogger().info("=================================");
                        Component broMsg = Component.text(msg,NamedTextColor.DARK_GREEN);
                        Component broMsg_ = Component.text("",NamedTextColor.DARK_GREEN);



                        Player[] ply = (Player[]) getServer().getOnlinePlayers().toArray();
                        for(int i=0;i<ply.length;i++){
                            ply[i].showTitle(Title.title(broMsg,broMsg_));
                        }
                    }
                }
            }else{
                p.sendMessage("관리자가 아닙니다. 관리자한테 문의하세요");
            }
        }else if(label.equalsIgnoreCase("tph")){
            //집으로 텔레포트
            Player player = (Player) sender;
            World world = player.getWorld();
            Location lc = new Location(world,-2546.376,62.000,-25.122);

            player.teleport(lc);
            getLogger().info("===============================================");
            getLogger().info(player.getName() + "님이 텔레포트를 사용하였습니다.");
            getLogger().info("===============================================");

        }
        return true;
    }
}



