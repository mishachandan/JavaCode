package chemin8.genericframeworksample.usecase;


import java.io.IOException;

import chemin8.genericframeworksample.generic.RoverThreadHandler;


public class UseCaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 9897;
		
		try {
			
			UseCaseServer useCaseServer = new UseCaseServer(port);
			Thread server = RoverThreadHandler.getRoverThreadHandler().getNewThread(useCaseServer);
			
			UseCaseClient useCaseClient = new UseCaseClient(port, null);
			Thread client = RoverThreadHandler.getRoverThreadHandler().getNewThread(useCaseClient);
			
			server.start();
			
			client.start();
			
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
