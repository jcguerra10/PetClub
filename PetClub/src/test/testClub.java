package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.*;

class testClub {
	
	Club clubs;
	
	@BeforeEach
	void setUp() {
		clubs = new Club(null, null, null, null);
	}

	@Test
	void test() {
		setUp();
		clubs.sortOwnersBubbleName();
		ArrayList<Owner> o = clubs.getOwners();
		int in;
		for (int i = 1; i < o.size(); i++) {
			in = i-1;
			assertTrue((o.get(in).getName().compareTo(o.get(i).getName()))<0);		
		}
		
	}
	
	@Test
	void test1() {
		setUp();
		clubs.sortBySelectionId();
		ArrayList<Owner> o = clubs.getOwners();
		int in;
		for (int i = 1; i < o.size(); i++) {
			in = i-1;
			assertTrue((o.get(in).getId().compareTo(o.get(i).getId()))<0);		
		}
		
	}
	
	@Test
	void test2() {
		setUp();
		clubs.sortOwnersBubbleMascotType();
		ArrayList<Owner> o = clubs.getOwners();
		int in;
		for (int i = 1; i < o.size(); i++) {
			in = i-1;
			assertTrue((o.get(in).getPetType().compareTo(o.get(i).getPetType()))<0);		
		}
		
	}

}
