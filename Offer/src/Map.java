import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class Server {}

public class Map {
    private ArrayList<Server> servers = new ArrayList<>();
    private HashMap<Server, Integer> map = new HashMap<>();

    public void add(Server server) {
        servers.add(server);
        map.put(server, servers.size() - 1);
    }

    public Server randomGet() {
        if (servers.size() == 0) return null;
        Random random = new Random();
        int num = random.nextInt(servers.size());
        return servers.get(num);
    }

    public void delete(Server server) {
        int index = map.get(server);
        map.remove(server);
        servers.set(index, servers.get(servers.size() - 1));
        map.put(servers.get(index), index);
        servers.remove(servers.size() - 1);
    }
}
