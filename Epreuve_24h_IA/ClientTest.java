public class ClientTest {

	public static void main(String[] args)
	{
		String nom = "Companeros";
		Client client = new Client();
		
		if (args.length == 1) {
			client = new Client(args[0]);
		}
		
		if (args.length == 2) {
			client = new Client(args[0], args[1]);
		}
		
		client.send(nom);
		
		while(client.isConnected())
		{
			String l_serveur_Return = client.read();
			System.out.println(l_serveur_Return + "\n");
			//Algo de prise de décisions
			client.send("S-E-S\n");
		}

		client.close();
	}
	
}
