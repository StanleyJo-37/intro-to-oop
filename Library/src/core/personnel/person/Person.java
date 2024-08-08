package core.personnel.person;

import java.util.UUID;

abstract class Person {
	private final UUID id;
	private String name;
	
	public Person(String name) {
		this.id = UUID.randomUUID(); /* Could be changed to other
									  	method -> database id
		       						  		  	  generation      */
		this.name = name;
	}

	public final UUID getID() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
