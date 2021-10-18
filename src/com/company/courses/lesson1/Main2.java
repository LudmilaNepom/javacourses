package com.company.courses.lesson1;

import java.time.LocalTime;

public class Main2 {

	public static void main(String[] args) {
		// Pudge pudge = new Pudge("Pudge", 13);

		// try (DataOutputStream dos = new DataOutputStream(new
		// FileOutputStream("pudge.bin"))) {
		// dos.writeUTF(pudge.getName());
		// dos.writeInt(pudge.getLevel());
		//
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

//		try (DataInputStream dos = new DataInputStream(new FileInputStream("pudge.bin"))) {
//			Pudge pudge = new Pudge(dos.readUTF(), dos.readInt());
//			System.out.println(pudge);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("End");
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
		
		
		
	}

}
