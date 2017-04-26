public class ExpressionTree {
	/*accessor method for the value, precondition is that isValue() is true.*/
  private double getValue(){    /*implementation not shown*/ }
  /*accessor method for the operation, precondition is that isOp() is true.*/
  private char getOp(){    /*implementation not shown*/  }    
  /* accessor method for left, precondition is that isOp() is true.*/
  private ExpressionTree getLeft(){    /*implementation not shown*/  }
  /* accessor method for right, precondition is that isOp() is true.*/
  private ExpressionTree getRight(){    /*implementation not shown*/  }

	private boolean isOp(){    /*implementation not shown*/  }
	private boolean isValue(){    /*implementation not shown*/  }

	public String toString(){    /*you are to write this method*/  }
	
	public String toStringPostfix(){    /*you are to write this method*/  }

	public String toStringPrefix(){    /*you are to write this method*/  }

	public double evaluate(){    /*you are to write this method*/  }
	
	
	public static void main(String[] args) {
		
	}
}
