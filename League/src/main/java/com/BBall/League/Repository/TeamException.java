/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BBall.League.Repository;

/**
 *
 * @author Nur
 */
public class TeamException extends Exception{
	public TeamException(String message) {
		super(message);
	}
public TeamException(String message, Throwable cause) {
	super(message, cause);
}
}
