package lab07;

// Chapter 14.4 - Case Study: Expression Evaluator

// This class breaks up a string into a sequence of tokens using both whitespace and a list of special characters
// in this case are used to tokenize an arithmetic expression. For example, the expression: 2*3.8/(4.95-7.8)
// would be tokenized as 2 * 3.8 / ( 4.95 - 7.8 ) even though it has no whitespace to separate these tokens.

import java.util.*;

public class StringSplitter {
private Queue<Character> characters;
private String token;
public static final String SPECIAL_CHARACTER = "()+-*/^";

public StringSplitter(String line){
characters = new LinkedList<Character>();
for (int i = 0; i < line.length(); i++){
characters.add(line.charAt(i));
}
findNextToken();
}

public boolean hasNext(){
return token != null;
}


public String next(){
checkToken();
String result = token;
findNextToken();
return result;
}


public String peek(){
checkToken();
return token;
}


private void findNextToken(){
while (!characters.isEmpty() && Character.isWhitespace(characters.peek())){
characters.remove();
}
if (characters.isEmpty()){
token = null;
}else{
token = "" + characters.remove();
if (!SPECIAL_CHARACTER.contains(token)){
boolean done = false;
while (!characters.isEmpty() && !done){
char ch = characters.peek();
if (Character.isWhitespace(ch) || SPECIAL_CHARACTER.indexOf(ch) >= 0){
done = true;
}else{
token = token + characters.remove();
}
}
}
}
}

private void checkToken(){
if (!hasNext()){
throw new NoSuchElementException();
}
}

public static double InfixEvaluator(String line) {
StringSplitter data =  new StringSplitter(line);
Stack<String> operators =  new Stack<String>();
Stack<Double> operands =  new Stack<Double>();
while(data.hasNext()) {
String s = data.next();
if (s.charAt(0)>= '0' && s.charAt(0)<= '9') {
operands.push(Double.parseDouble(s));
}


else if(s.charAt(0) == '(')
operators.push(s);
else if(s.charAt(0) == ')') {
if(operators.peek().charAt(0) != '(') {
double y = operands.pop();
double x = operands.pop();
String s1 =  operators.pop();
switch (s1.charAt(0)) {
case '+':
operands.push(x+y);
break;
case '-':
operands.push(x-y);
break;
case '*':
operands.push(x*y);
break;
case '/':
operands.push(x/y);
break;
}
operators.pop();
}
}

else {
if(!operators.isEmpty() && isEqualGreater(s.charAt(0),operators.peek().charAt(0))) {
double y = operands.pop();
double x = operands.pop();
String s1 =  operators.pop();
switch (s1.charAt(0)) {
case '+':
operands.push(x+y);
break;
case '-':
operands.push(x-y);
break;
case '*':
operands.push(x*y);
break;
case '/':
operands.push(x/y);
break;
}
}
operators.push(s);
}
}


while(!operators.isEmpty()) {
double y = operands.pop();
double x = operands.pop();
String s1 =  operators.pop();
switch (s1.charAt(0)) {
case '+':
operands.push(x+y);
break;
case '-':
operands.push(x-y);
break;
case '*':
operands.push(x*y);
break;
case '/':
operands.push(x/y);
break;
}
}
return operands.pop();


}

public static boolean isEqualGreater(char a, char b) {
if (a == '+' || a == '-') {
if (b == '+' || b == '-' || b == '*' || b == '/')
return true;
else
return false;
}
else {
if (b == '*' || b == '/')
return true;
else
return false;
}
}

public static boolean isGreater(char a, char b) {
if (a == '+' || a == '-') {
if (b == '*' || b == '/')
return true;
else
return false;
}
else {
return false;
}
}
}

