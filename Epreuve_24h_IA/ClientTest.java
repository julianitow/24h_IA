import java.io.IOException;

public class ClientTest {

	public static void main(String[] args) throws IOException
	{
		String nom = "Companeros";
		Client client = new Client();
		boolean cont = true;
		
		if (args.length == 1) {
			client = new Client(args[0]);
		}
		
		if (args.length == 2) {
			client = new Client(args[0], args[1]);
		}
		
		client.send(nom);
		
		while(cont)
		{
			String l_serveur_Return = client.read();
			System.out.println(l_serveur_Return + "\n");
			//Algo de prise de décisions
			client.send("S-E-S");
			if (!client.isConnected())
			{
				cont = false;
			}
		}

		client.close();
		
	}
	
}
