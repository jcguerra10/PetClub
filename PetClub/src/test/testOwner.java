package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.*;

class testOwner {
	
	Owner ow; 
	@BeforeEach
	void setUp() {
		ow = new Owner(null, null, null, null, null);
	}

	@Test
	void test() {
		setUp();
		ow.sortBySelectionId();
		ArrayList<Pet> o = ow.getPets();
		int in;
		for (int i = 1; i < o.size(); i++) {
			in = i-1;
			assertTrue((o.get(in).getId().compareTo(o.get(i).getId()))<0);		
		}
		
	}
	
	@Test
	void test1() {
		setUp();
		ow.sortBySelectionName();
		ArrayList<Pet> o = ow.getPets();
		int in;
		for (int i = 1; i < o.size(); i++) {
			in = i-1;
			assertTrue((o.get(in).getName().compareTo(o.get(i).getName()))<0);		
		}
		
	}
	
	@Test
	void test2() {
		setUp();
		ow.sortBySelectionPetType();
		ArrayList<Pet> o = ow.getPets();
		int in;
		for (int i = 1; i < o.size(); i++) {
			in = i-1;
			assertTrue((o.get(in).getPetType().compareTo(o.get(i).getPetType()))<0);		
		}
		
	}

}
