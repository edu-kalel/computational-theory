import java.util.*;
import java.io.*;
public class UserPracticaDos{
	public static void main(String[] args) {
		
		/*Scanner entrada = new Scanner(System.in);
		String input=entrada.nextLine();*/

		try{
			//File archi = new File(input);
			File archi = new File("resources/EjemploPracticaAnalizador.txt");
			Scanner lectorl = new Scanner(archi);
			int numlin = 0, er=0;
			while(lectorl.hasNextLine()){
				numlin++;
				String linea = lectorl.nextLine();
				Scanner lectort = new Scanner(linea);
				while(lectort.hasNext()){
					String token = lectort.next();
					if(!automata(token)){
						System.out.println("Error en linea "+numlin);
						er=1;
						break;
					}
				}
				lectort.close();
			}
			if (er==0) {
				System.out.println("No hay errores de análisis léxico en las constantes numéricas del archivo");
			}
			lectorl.close();
		} catch (FileNotFoundException a) {
			System.out.println("Error al abrir archivo");
			a.printStackTrace();
		}

	}

	public static boolean automata(String dis){
		//System.out.println(dis);
		int estado = 5, i=0;
		char[] chtkn = dis.toCharArray();
		if (!checa(chtkn[0])) {
			return true;
		}
		for(char s : chtkn){
			i++;
			switch(estado){
				case 0:
					if ((s=='0')||(s=='1')||(s=='2')||(s=='3')||(s=='4')||(s=='5')||(s=='6')||(s=='7')||(s=='8')||(s=='9')) {
						estado=0;
						if (i==chtkn.length) {
							return true;
						}
					}
					else if (s=='.') {
						estado=10;
					}
					else{
						return false;
					}
					break;
				case 1:
					if ((s=='0')||(s=='1')||(s=='2')||(s=='3')||(s=='4')||(s=='5')||(s=='6')||(s=='7')) {
						estado=1;
						if (i==chtkn.length) {
							return true;
						}
					}
					else{
						return false;
					}
					break;
				case 2:
					if ((s=='0')||(s=='1')||(s=='2')||(s=='3')||(s=='4')||(s=='5')||(s=='6')||(s=='7')||(s=='8')||(s=='9')||(s=='A')||(s=='B')||(s=='C')||(s=='D')||(s=='E')||(s=='F')) {
						estado=2;
						if (i==chtkn.length) {
							return true;
						}
					}
					else{
						return false;
					}
					break;
				case 3:
					if ((s=='0')||(s=='1')||(s=='2')||(s=='3')||(s=='4')||(s=='5')||(s=='6')||(s=='7')||(s=='8')||(s=='9')) {
						estado=3;
						if (i==chtkn.length) {
							return true;
						}
					}
					else if (s=='E') {
						estado=11;
					}
					else{
						return false;
					}
					break;
				case 4:
					return false;
				case 5:
					if (s=='0') {
						estado=7;
					}
					else if ((s=='+')||(s=='-')) {
						estado=6;
						if (i==chtkn.length) {
							return true;
						}
					}
					else if ((s=='1')||(s=='2')||(s=='3')||(s=='4')||(s=='5')||(s=='6')||(s=='7')||(s=='8')||(s=='9')) {
						estado=9;
						if (i==chtkn.length) {
							return true;
						}
					}
					else{
						return false;
					}
					break;
				case 6:
					if (s=='0') {
						estado=7;
					}
					else if ((s=='1')||(s=='2')||(s=='3')||(s=='4')||(s=='5')||(s=='6')||(s=='7')||(s=='8')||(s=='9')) {
						estado=9;
						if (i==chtkn.length) {
							return true;
						}
					}
					else if ((s=='=')&&(i==chtkn.length)) {
						return true;
					}
					else{
						return false;
					}
					break;
				case 7:
					if ((s=='x')||(s=='X')) {
						estado=8;
					}
					else if ((s=='0')||(s=='1')||(s=='2')||(s=='3')||(s=='4')||(s=='5')||(s=='6')||(s=='7')) {
						estado=1;
						if (i==chtkn.length) {
							return true;
						}
					}
					else if (s=='.') {
						estado=10;
					}
					else{
						return false;
					}
					break;
				case 8:
					if ((s=='0')||(s=='1')||(s=='2')||(s=='3')||(s=='4')||(s=='5')||(s=='6')||(s=='7')||(s=='8')||(s=='9')||(s=='A')||(s=='B')||(s=='C')||(s=='D')||(s=='E')||(s=='F')) {
						estado=2;
						if (i==chtkn.length) {
							return true;
						}
					}
					else{
						return false;
					}
					break;
				case 9:
					if ((s=='0')||(s=='1')||(s=='2')||(s=='3')||(s=='4')||(s=='5')||(s=='6')||(s=='7')||(s=='8')||(s=='9')) {
						estado=0;
						if (i==chtkn.length) {
							return true;
						}
					}
					else if (s=='.') {
						estado=10;
					}
					else{
						return false;
					}
					break;
				case 10:
					if ((s=='0')||(s=='1')||(s=='2')||(s=='3')||(s=='4')||(s=='5')||(s=='6')||(s=='7')||(s=='8')||(s=='9')) {
						estado=3;
						if (i==chtkn.length) {
							return true;
						}
					}
					else{
						return false;
					}
					break;
				case 11:
					if ((s=='+')||(s=='-')) {
						estado=12;
					}
					else if ((s=='0')||(s=='1')||(s=='2')||(s=='3')||(s=='4')||(s=='5')||(s=='6')||(s=='7')||(s=='8')||(s=='9')) {
						estado=13;
					}
					else{
						return false;
					}
					break;
				case 12:
					if ((s=='0')||(s=='1')||(s=='2')||(s=='3')||(s=='4')||(s=='5')||(s=='6')||(s=='7')||(s=='8')||(s=='9')) {
						estado=13;
					}
					else{
						return false;
					}
					break;
				case 13:
					if ((s=='0')||(s=='1')||(s=='2')||(s=='3')||(s=='4')||(s=='5')||(s=='6')||(s=='7')||(s=='8')||(s=='9')) {
						estado=4;
						if (i==chtkn.length) {
							return true;
						}
					}
					else{
						return false;
					}
					break;
				default:
					System.out.println("Estado desconocido");
			}
		}
		return false;
	}

	public static boolean checa(char s){
		if ((s=='0')||(s=='1')||(s=='2')||(s=='3')||(s=='4')||(s=='5')||(s=='6')||(s=='7')||(s=='8')||(s=='9')||(s=='+')||(s=='-')||(s=='.')) {
			return true;
		}
		else{
			return false;
		}
	}

}