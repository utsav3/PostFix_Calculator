import java.util.Scanner;
import java.util.Stack;

import javax.swing.border.EmptyBorder;


public class PostFix_Calc<T> {
	//public static void main(String[] args){
	Scanner scan=new Scanner(System.in);
	protected Stack<Character> CharStack=new Stack<Character>();
	protected Stack<Character> Operands=new Stack<Character>();
	protected String Infix_Exp;
	protected static char Chars;
	protected char[] List=new char[4];
	protected static int precedence;

	public PostFix_Calc(){

	}

	public String getInfix(){
		System.out.println("Enter the expression");
		Infix_Exp=scan.nextLine();
		return Infix_Exp;
	}

	public char[] toArray(){
		for(int i=0;i<Infix_Exp.length();i++){
			List[i]=Infix_Exp.charAt(i);
		}
		return List;
	}

	public int checkPrecedence(){
		precedence = 0;
		switch(Chars){
		case '*':
		case '/':
			precedence = 2;
			break;
		case '+':
		case '-':
			precedence = 1;
			break;
		case '(':
			precedence = 4;
			break;
		}
		
		return precedence;
	}
	public void getCurrent(){
		for(int i=0;i<Infix_Exp.length();i++){
			Chars=Infix_Exp.charAt(i);
			setSacks();
		}
	}

	public void setSacks(){

		if(Character.isDigit(Chars)){
			CharStack.push(Chars);
		}
		else{
			checkPrecedence();
			operandStack();
		}
	}

	public void operandStack(){

		switch(Chars){
		case'*':
			if(precedence==1||precedence==0)
				CharStack.push(Chars);
			else
				Operands.push(Chars);
			
		case'+':
			Operands.push(Chars);
		case'/':
			if(precedence==1)
				CharStack.push(Chars);
			else
				Operands.push(Chars);
		case'-':
			Operands.push(Chars);


			}
	}
	
	public void displayStack(){
		for(int i=0;i<CharStack.size();i++){
			System.out.println(CharStack.pop());
		}
	}
	public void displayArray(){
		for(char element:List)
			System.out.println(" "+element);
	}

}

