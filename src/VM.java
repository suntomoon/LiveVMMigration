
public class VM extends Thread {
	private String serverName;
	private Boolean running = true;
	private Boolean sleeping = true;
	private int[] memory = new int[20];
	private int pc;
	
	public VM(String serverName) {
		this.serverName = serverName;
		this.running = true;
		this.sleeping = true;
	}
	
    public void run() {
    	int i=0;
    	pc = i;
    	
    	while(running) {
    		if(sleeping) {
    			System.out.println("VM " + this.getId() + " is running on " + serverName +"!");
    			
    			pc = i++ % 20;
    			memory[pc] = i;
    			
    			try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		} else {
    			printMemory();
    			//System.out.println("VM " + this.getId() + " is sleeping on " + serverName +"!");
	    		try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		}
    	}
    	
    	printMemory();
    }
    
    public void printMemory() {
    	for(int i=0; i<memory.length; i++)
    	{
    		System.out.print(memory[i]);
    		if(i!=memory.length - 1) System.out.print(", ");
    	}
    	
    	System.out.println();
    	System.out.println("current PC is "+ pc);
    }
    
    public void setStop() {
    	this.running = false;
    }
    
    public void setStart() {
    	this.running = true;
    }
    
    public void setSleep() {
    	this.sleeping = false;
    }
    
    public void setResume() {
    	this.sleeping = true;
    } 
}