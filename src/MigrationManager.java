import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MigrationManager {
	
    private static ArrayList<Server> servers = new ArrayList<Server>();
	
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");
		String str = null;
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Usage: create <server name>\r"
                + "start <server name>\r"
                + "stop <server name>\r"
                + "startvm <vm> on <server name>\r"
                + "stopvm <vm> on <server name>\r");
		
		while(true) {
			str = stdIn.readLine();
			String[] opts = str.split(" ");
			
			if(opts[0].equals("u")) {
				System.out.println("Usage: create server\r"
		                + "start server\r"
		                + "stop server\r"
		                + "suspend server\r"
		                + "resume server\r"
		                + "startvm vm on server\r"
		                + "stopvm vm on server\r");
				continue;
			}
			
			if(opts[0].equals("q")) {
				break;
			} else if(opts[0].equals("create")){
				Server server = new Server(opts[1]);
				servers.add(server);
				server.setup();
			} else if(opts[0].equals("start")) {
				for(Server s: servers){
					if(s.getName().equals(opts[1])) {
						s.start();
						break;
					}
				}
			} else if(opts[0].equals("stop")) {
				for(Server s: servers){
					if(s.getName().equals(opts[1])) {
						s.stop();
						break;
					}
				}
			} else if(opts[0].equals("suspend")) {
				for(Server s: servers){
					if(s.getName().equals(opts[1])) {
						s.suspend();
						break;
					}
				}
			} else if(opts[0].equals("resume")) {
				for(Server s: servers){
					if(s.getName().equals(opts[1])) {
						s.resume();
						break;
					}
				}
			} else if(opts[0].equals("startvm")) {
				for(Server s: servers){
					if(s.getName().equals(opts[3])) {
						s.startVM(Integer.parseInt(opts[1]));
						break;
					}
				}
			} else if(opts[0].equals("stopvm")) {
				for(Server s: servers){
					if(s.getName().equals(opts[3])) {
						s.stopVM(Integer.parseInt(opts[1]));
						break;
					}
				}
			} else {
				System.out.println("Invalid Command!");
			}
		}
		
	}

}
