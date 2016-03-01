package creativepatch;

import cn.nukkit.*;
import cn.nukkit.plugin.*;
import cn.nukkit.scheduler.PluginTask;
import cn.nukkit.event.*;
import cn.nukkit.event.player.PlayerJoinEvent;

public class Main extends PluginBase implements Listener{
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		if (player.isCreative()) {
			getServer().getScheduler().scheduleDelayedTask(new GmChangeTask(this, player), 10);
		}
	}
}
class GmChangeTask extends PluginTask<Main> {
	private Player player;

	public GmChangeTask(Main owner, Player player) {
		super(owner);
		this.player = player;
		player.setGamemode(0);
	}

	@Override
	public void onRun(int currentTick) {
		player.setGamemode(1);
	}
	
}
