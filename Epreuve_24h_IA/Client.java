import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

	public Socket socket;
	public String adresse = "localhost";
	public int port = 1337;
	public DataOutputStream os = null;
	public BufferedReader in;
	
	public Client() {
		this.connect();
	}
	
	public Client(String adresse) {
		this.adresse = adresse;
		this.connect();
	}
	
	public Client(String adresse, String port) {
		this.adresse = adresse;
		this.port = Integer.parseInt(port);
		this.connect();
	}

	private void connect() {
		try {
			this.socket = new Socket(this.adresse, this.port);
			System.out.print("Demande de connexion à : " + adresse + " port : " + port + "\n");
			this.os = new DataOutputStream(this.socket.getOutputStream());
			this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void send(String cmd) {
		try {
			this.os.writeUTF(cmd);
			this.os.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String read() {
		try {
			return this.in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void close() {
		try {
			this.socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isConnected() {
		return this.socket.isConnected();
	}
}
