package br.edu.impacta.saudacao_server;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaudacaoServer {
	public static void main(String[] args) throws IOException  {
		ServerSocket ss = new ServerSocket(58888);
		while (true) {
			System.out.println("Servidor esperando conex�o...");
			Socket soc = ss.accept();
			System.out.println("Conectado!");
			InputStream is = soc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			OutputStream os = soc.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			String nome = br.readLine();
			Date data = new Date();
			SimpleDateFormat fmtData = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat fmtHora = new SimpleDateFormat("hh:mm:ss");
			String msg = "Ol� " + nome + "! ";
			msg += "O relat�rio desse servidor indica que hoje � " + fmtData.format(data);
			msg += " e o hor�rio � " + fmtHora.format(data);
			pw.println(msg);
			pw.flush();
			pw.close();
			br.close();
			soc.close();			
	
		}
	}
}
