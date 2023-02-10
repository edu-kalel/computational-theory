import java.util.*;

public class UserPracticaTres{
	public static void main(String[] args) {
		
		Scanner entrada=new Scanner(System.in);
		String input=entrada.nextLine();
		input=input+" ";

		if (!automata(input)) {
			System.out.println("\nError, la cadena no pertenece a la gramática");
		}
		else{
			System.out.println("\nAceptada, la cadena si pertenece a la gramática");
		}

	}

	public static boolean automata(String dis){
		//System.out.println(dis);
		int estado = 0;
		char[] chtkn=dis.toCharArray();
		String atoz="abcdefghijklmnopqrstuvwxyz_ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String num="0123456789";
		String ops="+-*/%";

		Deque<Character> stack = new ArrayDeque<Character>();
		stack.push('0');
		//System.out.println(stack.peek());

		for (char s : chtkn) {
			//System.out.println(s);
			//System.out.println("entró al for");
			switch(estado){
				case 0:
					//System.out.println("Entra a case 0");
					if ((atoz.indexOf(s)!=-1)&&(stack.peek()=='0')) {
						stack.push('Z');
						estado=1;
					}
					else{
						//System.out.println("Error aquí case 0");
						return false;
					}
					break;
				case 1:
					//System.out.println("Entra a case 1");
					if (((atoz.indexOf(s)!=-1)||(num.indexOf(s)!=-1))&&(stack.peek()=='Z')) {
						estado=1;						
					}
					else if ((s=='=')&&(stack.peek()=='Z')) {
						estado=2;
					}
					else{
						//System.out.println("Error aquí case 1");
						return false;
					}
					break;
				case 2:
					//System.out.println("Entra a case 2");
					if ((atoz.indexOf(s)!=-1)&&(stack.peek()=='X')) {
						estado=3;
					}
					else if ((atoz.indexOf(s)!=-1)&&(stack.peek()=='Z')) {
						estado=3;
					}
					else if ((atoz.indexOf(s)!=-1)&&(stack.peek()=='Y')) {
						stack.pop();
						estado=3;
					}
					else if ((s=='(')&&(stack.peek()=='Z')) {
						stack.push('X');
						estado=2;
					}
					else if ((s=='(')&&(stack.peek()=='Y')) {
						stack.pop();
						stack.push('X');
						estado=2;
					}
					else if ((s=='(')&&(stack.peek()=='X')) {
						stack.push('X');
						estado=2;
					}
					else if ((num.indexOf(s)!=-1)&&(stack.peek()=='Z')) {
						estado=4;
					}
					else if ((num.indexOf(s)!=-1)&&(stack.peek()=='X')) {
						estado=4;
					}
					else if ((num.indexOf(s)!=-1)&&(stack.peek()=='Y')) {
						stack.pop();
						estado=4;
					}
					else{
						//System.out.println("Error aquí case 2");
						return false;
					}
					break;
				case 3:
					//System.out.println("Entra a case 3");
					//System.out.println(stack.peek());
					if (((atoz.indexOf(s)!=-1)||(num.indexOf(s)!=-1))&&(stack.peek()=='Z')) {
						estado=3;						
					}
					else if (((atoz.indexOf(s)!=-1)||(num.indexOf(s)!=-1))&&(stack.peek()=='X')) {
						estado=3;
					}
					else if ((s==')')&&(stack.peek()=='X')) {
						stack.pop();
						estado=5;
					}
					else if ((ops.indexOf(s)!=-1)&&(stack.peek()=='Z')) {
						stack.push('Y');
						estado=2;
					}
					else if ((ops.indexOf(s)!=-1)&&(stack.peek()=='X')) {
						stack.push('Y');
						estado=2;
					}
					else if ((s==';')&&(stack.peek()=='Z')) {
						stack.pop();
						//System.out.println(stack.peek());
						estado=6;
					}
					else{
						//System.out.println("Error aquí case 3");
						return false;
					}
					break;
				case 4:
					//System.out.println("Entra a case 4");
					if ((num.indexOf(s)!=-1)&&(stack.peek()=='Z')) {
						estado=4;
					}
					else if ((num.indexOf(s)!=-1)&&(stack.peek()=='X')) {
						estado=4;
					}
					else if ((s==')')&&(stack.peek()=='X')) {
						stack.pop();
						estado=5;
					}
					else if ((ops.indexOf(s)!=-1)&&(stack.peek()=='Z')) {
						stack.push('Y');
						estado=2;
					}
					else if ((ops.indexOf(s)!=-1)&&(stack.peek()=='X')) {
						stack.push('Y');
						estado=2;
					}
					else if ((s==';')&&(stack.peek()=='Z')) {
						stack.pop();
						estado=6;
					}
					else{
						//System.out.println("Error aquí case 4");
						return false;
					}
					break;
				case 5:
					//System.out.println("Entra a case 5");
					if ((s==';')&&(stack.peek()=='Z')) {
						stack.pop();
						estado=6;
					}
					else if ((s==')')&&(stack.peek()=='X')) {
						stack.pop();
						estado=5;
					}
					else if ((ops.indexOf(s)!=-1)&&(stack.peek()=='Z')) {
						stack.push('Y');
						estado=2;
					}
					else if ((ops.indexOf(s)!=-1)&&(stack.peek()=='X')) {
						stack.push('Y');
						estado=2;
					}
					else{
						//System.out.println("Error aquí case 5");
						return false;
					}
					break;
				case 6:
					//System.out.println("Entra a case 6");
					if (stack.peek()=='0') {
						return true;
					}
					/*else{
						System.out.println("Error aquí case 6");
						System.out.println("simón pero la pila we");
					}*/
				break;
				default:
					System.out.println("Error, estado desconocido.");
					return false;
			}
		}
		System.out.println("Error en ciclo for");
		return false;
	}
}
