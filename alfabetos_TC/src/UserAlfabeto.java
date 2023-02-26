import java.util.*;
public class UserAlfabeto{
	public static void main(String[] args) {
		String atozmin="abcdefghijklmnopqrstuvwxyz";
		String atozMAY="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String num="0123456789";
		System.out.println("Ingrese rango:");

		Scanner entrada = new Scanner(System.in);
		String input;
		input=entrada.nextLine();

		String[] p = input.split("-");
		String p1 = p[0];
		String p2 = p[1];

		String dis="";//dis=alfabeto

		//checar a cual pertenece y generar el alfabeto
		if (atozmin.contains(p1)) {
			dis=(atozmin.substring((atozmin.indexOf(p1)),((atozmin.indexOf(p2))+1)));
		}
		else if (atozMAY.contains(p1)) {
			dis=(atozMAY.substring((atozMAY.indexOf(p1)),((atozMAY.indexOf(p2))+1)));
		}
		else if (num.contains(p1)) {
			dis=(num.substring((num.indexOf(p1)),((num.indexOf(p2))+1)));
		}

		//convertir dis de string a array of chars
		char[] dischars=dis.toCharArray();
		System.out.print("Alfabeto = { "+dischars[0]);
		for (int i=1; i<dis.length();i++) {
			System.out.print(" , "+dischars[i]);
		}
		System.out.println(" }");

		//input de w1 y w2
		System.out.println("Inserte cadena w1, debe pertenecer al alfabeto anteriormente definido:");
		String w1=entrada.nextLine();
		System.out.println("Inserte cadena w2, debe pertenecer al alfabeto anteriormente definido:");
		String w2=entrada.nextLine();

		//convertir de string a array de chars
		char[] chw1 = w1.toCharArray();
		char[] chw2 = w2.toCharArray();

		//checar que sean válidas
		int check=1;
		while (check==1){
			chw1 = w1.toCharArray();
			for (char c : chw1) {
				if (!dis.contains(String.valueOf(c))) {
					System.out.println("La cadena w1 es inválida, al menos "+c+" no pertenece al alfabeto.\nIntentar otra vez w1");
					w1=entrada.nextLine();
					check=1;
					break;
				}
				else {
					check=0;
				}
			}
		}
		System.out.println("La cadena w1 es válida.");
		check=1;
		while (check==1){
			chw2 = w2.toCharArray();
			for (char c : chw2) {
				if (!dis.contains(String.valueOf(c))) {
					System.out.println("La cadena w2 es inválida, al menos "+c+" no pertenece al alfabeto.\nIntentar otra vez w2");
					w2=entrada.nextLine();
					check=1;
					break;
				}
				else {
					check=0;
				}
			}
		}
		System.out.println("La cadena w2 es válida.");

		//checar si w1 es prefijo sufijo subcadena o subsecuencia o lo que sea de w2
		int w1l=w1.length(), w2l=w2.length();
		if (w2.startsWith(w1)) {				//prefijo
			if (w1l==w2l) {
				System.out.println("w1 es prefijo de w2. Ambas son iguales.");
			}
			else{
				System.out.println("w1 es prefijo de w2, no son iguales, prefijo propio");
			}
		}
		if (w2.endsWith(w1)) {					//sufijo
			if (w1l==w2l) {
				System.out.println("w1 es sufijo de w2. Ambas son iguales.");
			}
			else{
				System.out.println("w1 es sufijo de w2, no son iguales, sufijo propio");
			}
		}
		if (w2.contains(w1)) {					//subcadena
			if (w1l==w2l) {
				System.out.println("w1 es subcadena de w2. Ambas son iguales.");
			}
			else{
				System.out.println("w1 es subcadena de w2, no son iguales, subcadena propia");
			}			
		}
												//subsecuencia
		int j=0;
		for (int i=0; i<w2l && j<w1l ; i++) {
			if (w1.charAt(j)==w2.charAt(i)) {
				j++;
			}
		}
		if (j==w1l) {
			System.out.println("w1 es subsecuencia de w2");
		}

		//L's aaaaaaaa
		System.out.println("Ahora se generarán los lenguajes L1 y L2 de forma aleatoria.");
		Random rand=new Random();
		int np,lon;
		System.out.println("(NP) Número de elementos/palabras a ser generados para L1:");
		np=entrada.nextInt();
		System.out.println("Longitud de dichos elementos:");
		lon=entrada.nextInt();
		String[] l1=new String[np];
		for (int i=0;i<np;i++) {
			l1[i]="";
		}
		for (int i=0;i<np;i++) {										//recorre los l1[aquíwe]
			int checkagain=1;
			while(checkagain==1){
				l1[i]="";
				for (int k=0;k<lon;k++) {								//lo llena con la longitud que se dijo
					l1[i]+=dis.charAt(rand.nextInt(dis.length()));
				}
				for (int l=0;l<np;l++) {								//checar que no exista ya
					if (l1[i].equals(l1[l])) {
						if (l!=i) {
							checkagain=1;
							break;
						}
						else{
							checkagain=0;
						}
					}
					else{
						checkagain=0;
					}
				}
			}
		}

		//desplegar l1
		System.out.print("L1 = { "+l1[0]);
		for (int i=1;i<np;i++) {
			System.out.print(" , "+l1[i]);
		}
		System.out.println(" }");

		int np2,lon2;
		System.out.println("(NP) Número de elementos/palabras a ser generados para L2:");
		np2=entrada.nextInt();
		System.out.println("Longitud de dichos elementos:");
		lon2=entrada.nextInt();
		String[] l2=new String[np2];
		for (int i=0;i<np2;i++) {
			l2[i]="";
		}
		for (int i=0;i<np2;i++) {										//recorre los l2[aquíwe]
			int checkagain=1;
			while(checkagain==1){
				l2[i]="";
				for (int k=0;k<lon2;k++) {								//lo llena con la longitud que se dijo
					l2[i]+=dis.charAt(rand.nextInt(dis.length()));
				}
				for (int l=0;l<np2;l++) {								//checar que no exista ya
					if (l2[i].equals(l2[l])) {
						if (l!=i) {
							checkagain=1;
							break;
						}
						else{
							checkagain=0;
						}
					}
					else{
						checkagain=0;
					}
				}
			}
		}

		//desplegar l2
		System.out.print("L2 = { "+l2[0]);
		for (int i=1;i<np2;i++) {
			System.out.print(" , "+l2[i]);
		}
		System.out.println(" }");

		//unión de l's
		String[] lu=new String[np+np2];
		for (int i=0;i<np;i++) {
			lu[i]=l1[i];
		}
		for (int i=np;i<(np+np2);i++) {
			lu[i]=l2[i-np];
		}
		
		System.out.print("LU = { "+lu[0]);
		for (int i=1;i<(np+np2);i++) {
			System.out.print(" , "+lu[i]);
		}
		System.out.println(" }");

		//concatenación de l's
		/*System.out.println("Concatenación yeeeeet");
		String[] lc=new String[np*np2];
		for (int i=0;i<(np*np2);i++) {
			lc[i]=
		}
		*/

		//EXPRESIONES REGULARES
		System.out.println("Insertar una cadena de dígitos donde por lo menos un dígito se repita");
		entrada.nextLine();
		String cad;
		cad = entrada.nextLine();
		char[] cach = cad.toCharArray();
		int aaa=1;
		for (int i=0;i<cad.length();i++) {
			if ((cad.substring((cad.indexOf(cach[i]))+1)).contains(String.valueOf(cach[i]))) {
				System.out.println("PALABRA CORRECTA");
				aaa=0;
				break;
				}
		}
		if (aaa==1) {
			System.out.println("PALABRA INCORRECTA");
		}
	}
}