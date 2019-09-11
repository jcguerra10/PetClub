package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Club;
import model.InfoClubs;

class testInfoClubs {
	
	InfoClubs infoSis;
	
	@BeforeEach
	void setUp() {
		infoSis = new InfoClubs();
	}

	@Test
	void test() {
		setUp();
		infoSis.sortById();
		ArrayList<Club> c = infoSis.getClubs();
		int in;
		for (int i = 1; i < c.size(); i++) {
			in = i-1;
			assertTrue((c.get(in).getId().compareTo(c.get(i).getId()))<0);		
		}
		
	}
	
	@Test
	void test2() {
		setUp();
		infoSis.sortByName();
		ArrayList<Club> c = infoSis.getClubs();
		int in;
		for (int i = 1; i < c.size(); i++) {
			in = i-1;
			assertTrue((c.get(in).getName().compareTo(c.get(i).getName()))<0);		
		}
		
	}
	
	@Test
	void test3() {
		setUp();
		infoSis.sortByPetType();
		ArrayList<Club> c = infoSis.getClubs();
		int in;
		for (int i = 1; i < c.size(); i++) {
			in = i-1;
			assertTrue((c.get(in).getMascotType().compareTo(c.get(i).getMascotType()))<0);		
		}
		
	}
}
