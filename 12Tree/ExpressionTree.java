
public class ExpressionTree{
	public double evaluate(){
		if (isValue()) return getValue();
		switch(getOp()){
			case '+':
				return getLeft().evaluate() +
					getRight().evaluate();
			case '-':
				return getLeft().evaluate() -
					getRight().evaluate();
			case '*':
				return getLeft().evaluate() *
					getRight().evaluate();
			case '/':
				return getLeft().evaluate() /
					getRight().evaluate();
		}
		return -1.0;
	}
  
	public String toString(){
		if (isValue()) return "" + getValue();
		return "(" + getLeft() + " " + getOp() + " " + getRight() + ")";
	}
  
	public String toStringPostfix(){
		if (isValue()) return "" + getValue();
		return getLeft().toStringPostfix() + " " +
			getRight().toStringPostfix() + " " +
			getOp() + " ";
	}
  
	public String toStringPrefix(){
		if (isValue()) return "" + getValue();
		return ("" + getOp()) + " " +
			getLeft().toStringPrefix() + " " +
			getRight().toStringPrefix() + " ";
	}
  
  
  
  private char op;
  private double value;
  private ExpressionTree left,right;
  
  public ExpressionTree(double value){
    this.value = value;
    op = '~';
  }
  public ExpressionTree(char op,ExpressionTree l, ExpressionTree r){
    this.op = op;
    left = l;
    right = r;
  }
  
  
  
  public char getOp(){
    return op;
  }
  
  private double getValue(){
    return value;
  }
  private ExpressionTree getLeft(){
    return left;
  }
  private ExpressionTree getRight(){
    return right;
  }
  
  private boolean isOp(){
    return hasChildren();
  }
  private boolean isValue(){
    return !hasChildren();
  }
  
  private boolean hasChildren(){
    return left != null && right != null;
  }
  
  
  public static void main(String[] args){
    ExpressionTree a = new ExpressionTree(4.0);
    ExpressionTree b = new ExpressionTree(2.0);

    ExpressionTree c = new ExpressionTree('+',a,b);
    System.out.println(c);
    System.out.println(c.toStringPostfix());
    System.out.println(c.toStringPrefix());
    System.out.println(c.evaluate());


    ExpressionTree d = new ExpressionTree('*',c,new ExpressionTree(3.5));
    System.out.println(d);
    System.out.println(d.toStringPostfix());
    System.out.println(d.toStringPrefix());
    System.out.println(d.evaluate());

    ExpressionTree ex = new ExpressionTree('-',d,new ExpressionTree(1.0));
    System.out.println(ex);
    System.out.println(ex.toStringPostfix());
    System.out.println(ex.toStringPrefix());
    System.out.println(ex.evaluate());

    ex = new ExpressionTree('+',new ExpressionTree(1.0),ex);
    System.out.println(ex);
    System.out.println(ex.toStringPostfix());
    System.out.println(ex.toStringPrefix());
    System.out.println(ex.evaluate());

    ex = new ExpressionTree('/',ex,new ExpressionTree(2.0));
    System.out.println(ex);
    System.out.println(ex.toStringPostfix());
    System.out.println(ex.toStringPrefix());
    System.out.println(ex.evaluate());
    
    
  }
  
}
