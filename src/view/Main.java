package view;

import java.io.IOException;

import controller.ControllerArquivos;

public class Main {

	public static void main(String[] args) {
		
		ControllerArquivos arqCont = new ControllerArquivos();
		String path = "C:\\TEMP";
		String nome = "generic_food.csv";
		
		try {
			arqCont.readFile(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
