package rj.handshool.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utilidades {
	public static String formatoMatricula(){
		String inicio_matricula = "MAT";
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
		Date hora = Calendar.getInstance().getTime(); 
		String dataFormatada = sdf.format(hora);
		return inicio_matricula + dataFormatada;
	}
}
