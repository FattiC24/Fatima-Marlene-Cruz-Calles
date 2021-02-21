package com.fatima.Negocio;

import com.fatima.Entidades.Loguin;

public class ClsLoguin {
	public int acceso(Loguin log) {
		int acceso = 0;
		if (log.getUser().equals("fatima") && log.getPass().equals("123")) {
			acceso = 1;
		} else {

		}
		return acceso;
	}
}
