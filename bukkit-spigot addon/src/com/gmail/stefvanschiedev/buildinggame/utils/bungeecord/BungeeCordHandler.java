package com.gmail.stefvanschiedev.buildinggame.utils.bungeecord;

import com.gmail.stefvanschiedev.buildinggame.utils.JoinSign;
import fr.rhaz.socket4mc.Bukkit;
import fr.rhaz.socket4mc.Socket4MC;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Handles all bungeecord calls
 */
public class BungeeCordHandler implements Listener {

    private static final String CHANNEL = "BuildingGame";

    public final class Receiver {
        public static final String BUNGEE = "bungee";
        public static final String MAIN = "main";

        private Receiver() {}
    }

    private final Collection<IdentifiedCallable> callables = new HashSet<>();

    private void send(String message, IdentifiedCallable callable) {
        if (callable != null)
            callables.add(callable);
        Socket4MC.bukkit().getSocketClient().writeJSON(CHANNEL, message + (callable == null ? "" : ";uuid:" +
                callable.getUuid()));
    }

    public void connect(String receiver, AnimalTamer player, String server, IdentifiedCallable callable) {
        send("connect:" + player.getName() + ", " + server + ";receiver:" + receiver, callable);
    }

    public void write(String receiver, String file, String key, String value, IdentifiedCallable callable) {
        send("write:" + file + ", " + key + ", " + value + ";receiver:" + receiver, callable);
    }

    public void save(String receiver, IdentifiedCallable callable) {
        send("save;receiver:" + receiver, callable);
    }

    public void join(String receiver, String playerName, String arena, IdentifiedCallable callable) {
        send("join:" + playerName + ", " + arena + ";receiver:" + receiver, callable);
    }

    @EventHandler
    public void onBukkitSocketJSON(Bukkit.BukkitSocketJSONEvent e) {
        if (!e.getChannel().equals("BuildingGame"))
            return;

        //decode data
        String[] data = e.getData().split(";");

        if (data[0].startsWith("response") && data.length > 1)
            getCallable(UUID.fromString(data[1].split(":")[1])).call(data[0].split(":")[1]);
        else if (data[0].startsWith("teleport"))
            send(teleport(data[0].split(":")[1]) + ';' + (data.length > 2 ? data[2] : ""), null);
        else if (data[0].startsWith("sign"))
            send(sign(data[0].split("[^\\\\]:")[1]) + ';' + (data.length > 2 ? data[2] : ""), null);
    }

    private String teleport(String input) {
        String[] data = input.split(", ");

        Player player = org.bukkit.Bukkit.getPlayer(data[0]);
        if (player == null)
            return "response:failed";

        World world = org.bukkit.Bukkit.getWorld(data[1]);
        if (world == null)
            return "response:failed";

        int x, y, z;
        try {
            x = Integer.parseInt(data[2]);
            y = Integer.parseInt(data[3]);
            z = Integer.parseInt(data[4]);
        } catch (NumberFormatException e) {
            return "response:failed";
        }

        player.teleport(new Location(world, x, y, z));
        return "response:success";
    }

    private String sign(String input) {
        //undo escaping of special ':' character
        String[] data = input.replace("\\:", ":").split(", ");

        Set<JoinSign> joinSigns = JoinSign.getSigns(data[0]);
        for (JoinSign joinSign : joinSigns) {
            Sign sign = joinSign.getSign();

            sign.setLine(0, data[1]);
            sign.setLine(1, data[2]);
            sign.setLine(2, data[3]);
            sign.setLine(3, data[4]);
            sign.update();
        }

        return "response: success";
    }

    private IdentifiedCallable getCallable(UUID uuid) {
        for (IdentifiedCallable callable : callables) {
            if (callable.getUuid().equals(uuid))
                return callable;
        }

        return null;
    }

    private BungeeCordHandler() {}
    private static BungeeCordHandler INSTANCE;
    public static BungeeCordHandler getInstance() {
        if (INSTANCE == null)
            INSTANCE = new BungeeCordHandler();
        return INSTANCE;
    }
}
