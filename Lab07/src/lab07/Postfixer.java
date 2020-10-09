package lab07;

import java.util.Stack;

public class Postfixer {
	
		public static String PostfixConvertor(String line) {
			
			StringSplitter data =  new StringSplitter(line);
			Stack<String> operators =  new Stack<String>();
			StringBuilder postfixs = new StringBuilder();
			while(data.hasNext()) {
				String s = data.next();
				if (s.charAt(0)>= '0' && s.charAt(0)<= '9') 
				{
					postfixs.append(s);
				}
				else if(s.charAt(0) == '(')
				{
					operators.push(s);
				}
		
				else if(s.charAt(0) == ')')
				{
					while(operators.peek().charAt(0) != '(')
						postfixs.append(operators.pop());
					operators.pop();
				}

				else 
				{
					while(operators.peek().charAt(0) != '(' && StringSplitter.isGreater(s.charAt(0),operators.peek().charAt(0))) {
						postfixs.append(operators.pop());
				}
					operators.push(s);
				}
			}
		String postfixs_ = "" + postfixs;
		return postfixs_;
		}
	}
