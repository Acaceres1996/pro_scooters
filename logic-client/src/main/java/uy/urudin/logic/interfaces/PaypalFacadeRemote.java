package uy.urudin.logic.interfaces;

import javax.ejb.Remote;

@Remote
public interface PaypalFacadeRemote {
	String test();
}