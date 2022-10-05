package com.colsubsidio.dotaciones.scheduled.config.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.springframework.stereotype.Component;

@Component
public class HandleDate {
	public Date getFechaHora() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}

	public Calendar retornaCalendar(String cadena) {
		Calendar cal = null;
		try {
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date = formatter.parse(cadena);
			cal = Calendar.getInstance();
			cal.setTime(date);
		} catch (ParseException localParseException) {
		}
		return cal;
	}

	public Calendar retornaCalendarHora(String cadena) {
		Calendar cal = null;
		try {
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = formatter.parse(cadena + ":00");
			cal = Calendar.getInstance();
			cal.setTime(date);
		} catch (ParseException localParseException) {
		}
		return cal;
	}

	public Date retornaDate(String cadena) {
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
			date = formatter.parse(cadena);
		} catch (ParseException localParseException) {
		}
		return date;
	}

	public Timestamp retornaTimeStamp(String cadena) {
		Calendar cal = retornaCalendar(cadena);
		long date = cal.getTime().getTime();
		Timestamp timeStamp = new Timestamp(date);
		return timeStamp;
	}

	public Timestamp getFechaHoraTimeStamp(int dias) {
		TimeZone timeZone = TimeZone.getTimeZone("America/Bogota");
		Calendar calendar = Calendar.getInstance(timeZone);
		calendar.add(6, dias != 0 ? -dias : 0);
		long date = calendar.getTime().getTime();
		Timestamp timeStamp = new Timestamp(date);
		return timeStamp;
	}

	public String DevuelveFormato(Timestamp t) {
		String s = "";
		if (t != null) {
			s = new SimpleDateFormat("dd-MM-yyyy").format(t);
		}
		return s;
	}

	public String DevuelveFormatoHora(Timestamp t) {
		String s = "";
		if (t != null) {
			s = new SimpleDateFormat("HH:mm:ss").format(t);
		}
		return s;
	}

	public Timestamp FechaHoraToTimestamp(String FechaHora) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		Date parsedTimeStamp = dateFormat.parse(FechaHora);
		Timestamp timestamp = new Timestamp(parsedTimeStamp.getTime());
		return timestamp;
	}

	public String DevuelveAnio(Timestamp t) {
		String s = "";
		if (t != null) {
			s = new SimpleDateFormat("yyyy").format(t);
		}
		return s;
	}

	public String FechaLetras(Timestamp t) {
		String s = "";
		if (t != null) {
			s = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy").format(t);
		}
		return s;
	}

	public Timestamp StringToTimeStamp(String cadena) {
		Calendar cal = retornaCalendar(cadena);
		long date = cal.getTime().getTime();
		Timestamp timeStamp = new Timestamp(date);
		return timeStamp;
	}

	public Timestamp StringHoraToTimeStamp(String cadena) {
		Calendar cal = retornaCalendarHora(cadena);
		long date = cal.getTime().getTime();
		Timestamp timeStamp = new Timestamp(date);
		return timeStamp;
	}

	public String FechaLetras(String t) {
		String s = "";
		if (t != null) {
			s = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy").format(StringToTimeStamp(t));
		}
		return s;
	}

	public String getCadenaArchivo(int dias) {
		String nombre = getFechaHoraTimeStamp(dias).toString().replace("-", "").replace(":", "").replace(".", "")
				.replace(" ", "");
		nombre = nombre.substring(0, 12);
		return nombre;
	}

	public String geCadena(int dias) {
		String nombre = getFechaHoraTimeStamp(dias).toString().replace("-", "").replace(":", "").replace(".", "")
				.replace(" ", "");
		return nombre;
	}

	public int compare(Timestamp t1, Timestamp t2) {
		long l1 = t1.getTime();
		long l2 = t2.getTime();
		if (l2 > l1) {
			return 1;
		}
		if (l1 > l2) {
			return -1;
		}
		return 0;
	}

	public String calcularEdad(String fecha_nac) {
		Date fechaActual = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		String hoy = formato.format(fechaActual);
		String[] dat1 = fecha_nac.split("-");
		String[] dat2 = hoy.split("-");
		int anos = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
		int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
		if (mes < 0) {
			anos -= 1;
		} else if (mes == 0) {
			int dia = Integer.parseInt(dat1[0]) - Integer.parseInt(dat2[0]);
			if (dia > 0) {
				anos -= 1;
			}
		}
		return String.valueOf(anos);
	}
}
