import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Server {
	private int vmCount = 1;
	private int[] totalMemory = new int[1024];
	private long[] threadID;
	private VM[] vmArray;
	private String serverName;
	
	public Server(String serverName) {
		this.serverName = serverName;
	}
	
	public void setup() {
		System.out.println("How many VMs you want to create on Server " + serverName + "?");
		String str = null;
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			str = stdIn.readLine();
			int vmCount = Integer.parseInt(str);
			System.out.println(vmCount);
			threadID = new long[vmCount];
			vmArray= new VM[vmCount];
			for(int i=0; i<vmCount; i++) {
				VM vm = new VM(serverName);
				threadID[i] = vm.getId();
				vmArray[i] = vm;
				vm.start();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void startVM(int vmIndex) {
		VM vm = vmArray[vmIndex];
		vm.setStart();
	}
	
	public void stopVM(int vmIndex) {
		VM vm = vmArray[vmIndex];
		vm.setStop();
	}
	
	public void suspendVM(int vmIndex) {
		VM vm = vmArray[vmIndex];
		vm.setSleep();
	}
	
	public void resumeVM(int vmIndex) {
		VM vm = vmArray[vmIndex];
		vm.setResume();
	}
	
	public void start(){
		for(int i=0; i<vmArray.length; i++) {
			startVM(i);
		}
	}
	
	public void stop(){
		for(int i=0; i<vmArray.length; i++) {
			stopVM(i);
		}
	}
	
	public void suspend(){
		for(int i=0; i<vmArray.length; i++) {
			suspendVM(i);
		}
	}
	
	public void resume(){
		for(int i=0; i<vmArray.length; i++) {
			resumeVM(i);
		}
	}
	
	public String getName(){
		return this.serverName;
	}
}
