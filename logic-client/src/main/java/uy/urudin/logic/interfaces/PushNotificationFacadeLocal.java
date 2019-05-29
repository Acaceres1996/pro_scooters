package uy.urudin.logic.interfaces;

import javax.ejb.Local;


@Local
public interface PushNotificationFacadeLocal {
	public boolean sendPushNotification(String cabezal, String cuerpo);
}