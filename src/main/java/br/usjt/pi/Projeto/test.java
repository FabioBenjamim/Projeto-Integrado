package br.usjt.pi.Projeto;

public class test {
	public static void main(String args[]) {
		String x = "teste.txt";
		String array[] = new String[2];
		array = x.split("\\.");
		System.out.print(array[1]);
	}
}
