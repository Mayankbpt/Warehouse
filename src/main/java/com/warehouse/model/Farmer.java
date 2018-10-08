package com.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Farmer")
public class Farmer {

@Id
@GeneratedValue
 int id;

@Column(name="name")
String name;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Farmer() {
	super();
	// TODO Auto-generated constructor stub
}

}
