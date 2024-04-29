package com.bits.bookapplication.entities;

import java.io.Serializable;

public class BookPK implements Serializable  {

	private int id;

	private int user_id;
	
	public BookPK(int id, int user_id) {
        this.id = id;
        this.user_id = user_id;
    }

    public BookPK() {
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
