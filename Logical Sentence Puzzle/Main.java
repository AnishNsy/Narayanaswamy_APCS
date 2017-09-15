import java.util.regex.Matcher;
import java.util.regex.Pattern;

//findmatch 2nd argument: how deep?
//truthtable?
//classes:negation, conjunction
class Main {
	public static void main(String[] args) {
		PropositionConstant a = new PropositionConstant("a");
		PropositionConstant b = new PropositionConstant("b");
		TruthAssignment ta1 = new TruthAssignment();
		ta1.put(b, true);
		ta1.put(a, false); 
		System.out.println(b.pcName + " is " + ta1.get(b));
		System.out.println(a.pcName + " is " + ta1.get(a));
		LogicalSentence l1 = new LogicalSentence(a);
		LogicalSentence l2 = new LogicalSentence(b);
		System.out.println("l2 is " + l2.evaluate(ta1));
		System.out.println("l1 is " + l1.evaluate(ta1));
		LogicalSentence l3 = new Negation(l1);
		LogicalSentence l4 = new Negation(l3);
		System.out.println("l3 is " + l3.evaluate(ta1));
		System.out.println("l4 is " + l4.evaluate(ta1));
		LogicalSentence l5 =  new Conjunction(l3, new Negation(l4));
		System.out.println("l5 is " + l5.evaluate(ta1));
		
		System.out.println(legal("a&"));
		System.out.println(findMatch("a(b)", 0));

//		String[] pc = {"p"};
//		truthTable(pc);
		
		truthTable();
		
		System.out.println(findMatch("foo(p(q&r))", 0));
		System.out.println(findMatch("(foo(p&q", 2));
	}
	
	public static void truthTable() {
		TruthAssignment ta = new TruthAssignment();
		PropositionConstant a = new PropositionConstant("a");
		PropositionConstant b = new PropositionConstant("b");
		LogicalSentence A = new LogicalSentence(a);
		LogicalSentence B = new LogicalSentence(b);
		LogicalSentence AandB = new Conjunction(A, B);
		
		ta.put(b, false);
		ta.put(a, false); 
		System.out.println("A = " + A.evaluate(ta) + " B = " + B.evaluate(ta) + 
				" B and A = " + AandB.evaluate(ta));
		
		ta.set(b, true);
		ta.set(a, false); 
		System.out.println("A = " + A.evaluate(ta) + " B = " + B.evaluate(ta) + 
				" B and A = " + AandB.evaluate(ta));
		
		ta.set(b, false);
		ta.set(a, true); 
		System.out.println("A = " + A.evaluate(ta) + " B = " + B.evaluate(ta) + 
				" B and A = " + AandB.evaluate(ta));
		
		ta.set(b, true);
		ta.set(a, true); 
		System.out.println("A = " + A.evaluate(ta) + " B = " + B.evaluate(ta) + 
				" B and A = " + AandB.evaluate(ta));
	}
	
	public static String findMatch(String s, int index) {
		String result = "";
		boolean foundOpen = false;
		char currChar;
		for(int i = index; i < s.length(); i++) {
			currChar = s.charAt(i);
			if(currChar == '(') {
				foundOpen = true;
				result = "";
			}
			else if(currChar == ')'){
				
				return result;
			}
			else if(foundOpen) {
				result += currChar;
			}
		}
		return "";
	}
	
	public static boolean legal(String input) {
		String logConsRe = "\\b[a-z][a-zA-Z0-9_]*\\b";
		String operRe = "~|&|\\||=>|<=>";
		String unaryRe = "~";
		String binaryRe = "&|\\||=>|<=>";
		String altOperRe = "(" + operRe + ")";
		String tokenRe = "(" + operRe + "|" 
							+ logConsRe +
							")";
		Pattern logConsPat = Pattern.compile(logConsRe);
		Pattern operPat = Pattern.compile("(" + operRe + ")");
		Pattern tokenPat = Pattern.compile(tokenRe);
		Pattern expPat = Pattern.compile("^" +
				"(" + operRe + "|" 
				+ logConsRe + "|" + "\\s*" +
				")" 
				+ "*$");
		Matcher expm = expPat.matcher(input);
		if(!expm.matches()) {
			System.out.println("Bad tokens");
			return false;
		}
		Matcher m = tokenPat.matcher(input);
		
		String currToken = "";
		String nextToken = "";
		if(m.find()) {
			currToken = m.group(0);
		}
		while(m.find()) {
			nextToken = m.group(0);
//			System.out.println("Current token: " + currToken + 
//					" Next token: " + nextToken);
			if(currToken.matches(unaryRe) && 
					nextToken.matches(unaryRe)) {
				return false;
			}
			if(currToken.matches(binaryRe) && 
					nextToken.matches(binaryRe)) {
				return false;
			}
			if(currToken.matches(unaryRe) && 
					nextToken.matches(binaryRe)) {
				return false;
			}
			if(currToken.matches(logConsRe) && 
					nextToken.matches(logConsRe)) {
				return false;
			}
		
			currToken = nextToken;
//			System.out.println("Found value: " + 
//								currToken);
//			if(currToken.matches(logConsRe)) {
//				System.out.println("Logical Constant");
//			}
//			if(currToken.matches(altOperRe)) {
//				System.out.println("Oper");
//			}
		}
		if(currToken.matches(altOperRe))  {
			return false;
		}
		return true;
	}
}
