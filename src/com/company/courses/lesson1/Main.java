package com.company.courses.lesson1;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		// try (FileInputStream in = new FileInputStream("1.txt");
		// FileOutputStream out = new FileOutputStream("1_clone2.txt");) {
		// int c;
		// while ((c = in.read()) != -1) {
		// out.write(c);
		// }
		// System.out.println("Success...");
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		// try (FileReader in = new FileReader("1.txt");
		// FileWriter out = new FileWriter("1_clone.txt");) {
		// int c;
		// while ((c = in.read()) != -1) {
		// out.write(c);
		// }
		// System.out.println("Success...");
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		/*
		 * try (BufferedReader in = new BufferedReader(new FileReader("1.txt"));
		 * PrintWriter out = new PrintWriter(new FileWriter("1_cloneBuffer.txt"));) {
		 * String line; while ((line = in.readLine()) != null) { out.write(line);
		 * System.out.println(line); } System.out.println("Success...");
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 */

//		Scanner in = new Scanner(new FileReader("1.txt"));
//		double sum = 0;
//		while (in.hasNext()) {
//			if (in.hasNextDouble()) {
//				String temp = in.next();
//				try {
//					Integer.parseInt(temp);
//				} catch (Exception e) {
//					double num = Double.parseDouble(temp);
//					System.out.println("Number: " + num);
//				}
//			} else {
//				in.next();
//			}
//		}
		// in.useDelimiter("h");
		// while (in.hasNext()) {
		// System.out.println(in.next());
		// }

		//in.close();

//		Console console = System.console();
//		if(console == null) {
//			System.out.println("Opps. no console found...");
//			System.exit(66613);
//		}
//		System.out.println("Enter login: ");
//		String login = console.readLine();
//		System.out.println("Enter password: ");
//		char[] password = console.readPassword();
//		System.out.println("Login: "+login);
//		System.out.println("Password: "+Arrays.toString(password));
		
		
		
	}

}
