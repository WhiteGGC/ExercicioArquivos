package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ControllerArquivos {

	public void readFile(String path, String nome) throws IOException {
		File arq = new File(path, nome);
		File dir = new File(path);
		if(dir.exists() && dir.isDirectory()){
			if(arq.exists() && arq.isFile()){
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha != null){
					if(linha.contains("Fruits")){
						String output = "";
						String palavras[] = linha.split(",");
						for(String palavra : palavras){
							if(!palavra.contains("Fruits") && palavra.length()>6){
								output += palavra + "	";
							}else if(!palavra.contains("Fruits")){
								output += palavra + "		";
							}
						}
						System.out.println(output);
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			}else{
				throw new IOException("Arquivo Inválido ou Inexistente");
			}
		}else{
			throw new IOException("Diretório Inválido ou  Inexistente");
		}
		
	}
}
