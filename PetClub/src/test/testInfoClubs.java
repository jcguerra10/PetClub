package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Club;

class testInfoClubs {

	@BeforeEach
	void setUp1() {
		try {
			String Nid = "";
			String Nname = "";
			String Ndate = "";
			String Nmascot = "";
			int a = 0;
			int b = 1;
			int c = 2;
			int d = 3;
			FileReader rFile = new FileReader("D:\\AAPROGRAMAS\\apo2\\LAB2\\PetClub\\PetClub\\doc\\testing.csv");

			BufferedReader buffer = new BufferedReader(rFile);

			String read = "i";
			String hehe = "";
			String[] split = null;
			boolean exit = false;
			while (hehe != null || !exit) {

				hehe = buffer.readLine();

				if (hehe != null) {
					read += hehe;
				} else {
					exit = true;
				}
			}
			System.out.println(read);
			split = read.split(",");
			for (int i = 0; i < split.length; i++) {
				System.out.println(split[i]);
			}
			for (int i = 0; i < split.length; i = i + 4) {
				Nid = split[i];
				Nname = split[i + 1];
				Ndate = split[i + 2];
				Nmascot = split[i + 3];
				a = a + 4;
				b = b + 4;
				c = c + 4;
				d = d + 4;
				Club newClub = new Club(Nid, Nname, Ndate, Nmascot);
				System.out.println(newClub);
			}
			rFile.close();
			buffer.close();
		} catch (Exception e) {

		}

	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
