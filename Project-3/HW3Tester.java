/**
 * A tester class for HW3
 * @author Andrea Tongsak
 *
 */
import org.junit.*;
import static org.junit.Assert.*;

/* *
 * A testing class for HW2 Methods 1-4
 * A conditional statement will need tests that go through each branch of the execution.
 * Any loops will need tests that cover "test 0, test 1, test many" and "test first, test middle, test last"
 */
public class HW3Tester {
  /**
   * Test the update and lookup method in State class.
   */
  @Test
  public void testState() {

    State stateTest = new State();

    stateTest.update("x", 10);
    assertEquals(10, stateTest.lookup("x"));

  }

  /**
   * Test the Variable class
   */
  @Test
  public void testVariable() {
    Variable y = new Variable("y");
    State s = new State();

    assertEquals(0, y.value(s));
    Assignment increment = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y, new Number(1)));
    increment.execute(s);
    assertEquals(1, y.value(s));
    increment.execute(s);
    assertEquals(2, y.value(s));

    assertEquals("y", y.getName());
    assertEquals("y", y.toString());
  }

  /**
   * Test the Number class
   */
  @Test
  public void testNumber() {
    Number n = new Number(18);
    State s = new State();

    assertEquals(18, n.value(s));

    assertEquals("18", n.toString());
  }

  /**
   * Test the ArithmeticOperation class
   */
  @Test
  public void testArithmeticOperation() {
    State s = new State();
    ArithmeticOperation testAdd = new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(5), new Number(5));
    assertEquals(10, testAdd.value(s));
    assertEquals("5 + 5", testAdd.toString());

    ArithmeticOperation testSub = new ArithmeticOperation(ArithmeticOperation.Operator.Sub, new Number(10), new Number(3));
    assertEquals(7, testSub.value(s));
    assertEquals("10 - 3", testSub.toString());

    ArithmeticOperation testMult = new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(10), new Number(3));
    assertEquals(30, testMult.value(s));
    assertEquals("10 * 3", testMult.toString());

    ArithmeticOperation testDiv = new ArithmeticOperation(ArithmeticOperation.Operator.Div, new Number(30), new Number(3));
    assertEquals(10, testDiv.value(s));
    assertEquals("30 / 3", testDiv.toString());

    ArithmeticOperation testRem = new ArithmeticOperation(ArithmeticOperation.Operator.Rem, new Number(10), new Number(3));
    assertEquals(1, testRem.value(s));
    assertEquals("10 % 3", testRem.toString());
  }

  /**
   * Test the Comparison class
   */
  @Test
  public void testComparison() {
    State s = new State();
    Comparison testLT = new Comparison(Comparison.Operator.LT, new Number(5), new Number(10));
    assertEquals(true, testLT.value(s));
    assertEquals("5 < 10", testLT.toString());

    Comparison testLTE = new Comparison(Comparison.Operator.LTE, new Number(5), new Number(10));
    assertEquals(true, testLTE.value(s));
    assertEquals("5 <= 10", testLTE.toString());

    Comparison testGT = new Comparison(Comparison.Operator.GT, new Number(10), new Number(5));
    assertEquals(true, testGT.value(s));
    assertEquals("10 > 5", testGT.toString());

    Comparison testGTE = new Comparison(Comparison.Operator.GTE, new Number(10), new Number(5));
    assertEquals(true, testGTE.value(s));
    assertEquals("10 >= 5", testGTE.toString());

    Comparison testEQ = new Comparison(Comparison.Operator.EQ, new Number(10), new Number(10));
    assertEquals(true, testEQ.value(s));
    assertEquals("10 == 10", testEQ.toString());

    Comparison testNEQ = new Comparison(Comparison.Operator.NEQ, new Number(5), new Number(10));
    assertEquals(true, testNEQ.value(s));
    assertEquals("5 != 10", testNEQ.toString());

  }

  /**
   * Test the BooleanOperation class
   */
  @Test
  public void testBooleanOperation() {
    State s = new State();
    BooleanOperation testAnd1 = new BooleanOperation(BooleanOperation.Operator.And,
                                                     new Comparison(Comparison.Operator.LT, new Number(5), new Number(10)),
                                                     new Comparison(Comparison.Operator.LT, new Number(10), new Number(5)));
    assertEquals(false, testAnd1.value(s));
    assertEquals("5 < 10 && 10 < 5", testAnd1.toString());

    BooleanOperation testAnd2 = new BooleanOperation(BooleanOperation.Operator.And,
                                                     new Comparison(Comparison.Operator.LT, new Number(5), new Number(10)),
                                                     new Comparison(Comparison.Operator.LT, new Number(10), new Number(20)));
    assertEquals(true, testAnd2.value(s));
    assertEquals("5 < 10 && 10 < 20", testAnd2.toString());

    BooleanOperation testOr = new BooleanOperation(BooleanOperation.Operator.Or,
                                                     new Comparison(Comparison.Operator.LT, new Number(5), new Number(10)),
                                                     new Comparison(Comparison.Operator.LT, new Number(10), new Number(5)));
    assertEquals(true, testOr.value(s));
    assertEquals("5 < 10 || 10 < 5", testOr.toString());
  }

  /*
   * Test the Assignment class
   */
  @Test
  public void testAssignment() {
    Variable v = new Variable("v");
    Assignment increment = new Assignment(v, new ArithmeticOperation(ArithmeticOperation.Operator.Add, v, new Number(1)));
    State s = new State();
    increment.execute(s);
    assertEquals(1, v.value(s));

    assertEquals("v := v + 1;\n", increment.toString());
    assertEquals("\tv := v + 1;\n", increment.toStringTabbed(1));
  }

  /**
   * Test the Return class
   */
  @Test
  public void testReturn() {
    Return testReturn = new Return(new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(5), new Number(10)));
    State s = new State();
    testReturn.execute(s);

    assertEquals("return 5 + 10;\n", testReturn.toString());
    assertEquals("\treturn 5 + 10;\n", testReturn.toStringTabbed(1));
  }

  /**
   * Test the ConditionalStatement class
   */
  @Test
  public void testConditionalStatement() {
    Variable v = new Variable("v");
    ConditionalStatement testCondS = new ConditionalStatement(new Comparison(Comparison.Operator.LT, new Number(5), new Number(10)),
                                                           new Assignment(v, new ArithmeticOperation(ArithmeticOperation.Operator.Add,
                                                                                                     v, new Number(1))),
                                                           new Assignment(v, new ArithmeticOperation(ArithmeticOperation.Operator.Mult,
                                                                                                     v, new Number(5))));
    State s = new State();
    testCondS.execute(s);

    assertEquals("if (5 < 10)\n\tv := v + 1;\nelse\n\tv := v * 5;\n", testCondS.toString());
    assertEquals("\tif (5 < 10)\n\t\t\tv := v + 1;\n\t\telse\n\t\t\tv := v * 5;\n", testCondS.toStringTabbed(2));
  }

  /**
   * Test the Loop class
   */
  @Test
  public void testLoop() {
    Variable x = new Variable("x");
    Assignment increment = new Assignment(x, new ArithmeticOperation(ArithmeticOperation.Operator.Add, x, new Number(1)));

    Variable result = new Variable("result");
    Assignment sumUpdate = new Assignment(result, new ArithmeticOperation(ArithmeticOperation.Operator.Add, result, x));

    Loop loop = new Loop(new Comparison(Comparison.Operator.LTE, x, new Number(10)), new CompoundStatement(sumUpdate, increment));

    State s = new State();
    loop.execute(s);

    assertEquals("while (x <= 10)\n\t{\n\t\tresult := result + x;\n\t\tx := x + 1;\n\t}\n", loop.toString());
    assertEquals("\twhile (x <= 10)\n\t\t\t{\n\t\t\t\tresult := result + x;\n\t\t\t\tx := x + 1;\n\t\t\t}\n", loop.toStringTabbed(2));
  }

  /**
   * Test the Compound Statement class
   */
  @Test
  public void testCompoundStatement() {
    Return test1 = new Return(new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(5), new Number(10)));
    Return test2 = new Return(new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(5), new Number(10)));
    Return test3 = new Return(new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(5), new Number(10)));

    CompoundStatement testCompS = new CompoundStatement(test1, test2, test3);

    State s = new State();
    testCompS.execute(s);

    assertEquals("{\n\treturn 5 + 10;\n\treturn 5 + 10;\n\treturn 5 + 10;\n}\n", testCompS.toString());
    assertEquals("\t{\n\t\t\treturn 5 + 10;\n\t\t\treturn 5 + 10;\n\t\t\treturn 5 + 10;\n\t\t}\n", testCompS.toStringTabbed(2));
  }

  /**
   * Test the Function class
   */
  @Test
  public void testFunction() {
    Variable x = new Variable("x");
    Variable n = new Variable("n");
    Function f = new Function("sum", new CompoundStatement(new Assignment(x, new Number(0)), new Loop(new Comparison(Comparison.Operator.GT, n, new Number(0)), new CompoundStatement(new Assignment(x, new ArithmeticOperation(ArithmeticOperation.Operator.Add, x, n)), new Assignment(n, new ArithmeticOperation(ArithmeticOperation.Operator.Sub, n, new Number(1))))), new Return(x)), n);

    assertEquals("function sum(n)\n{\n\tx := 0;\n\twhile (n > 0)\n\t\t{\n\t\t\tx := x + n;\n\t\t\tn := n - 1;\n\t\t}\n\treturn x;\n}\n", f.toString());

  }

  /**
   * Test the FunctionCall class
   */
  @Test
  public void testFunctionCall() {
    //FunctionCall f = new FunctionCall();
    // f.value
  }


}
