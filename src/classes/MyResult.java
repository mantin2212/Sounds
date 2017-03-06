package classes;


public class MyResult<A, B> {
	private A a;
	private B b;

	public MyResult(A a, B b) {
		this.a = a;
		this.b = b;
	}

	public A getFirst() {
		return a;
	}

	public B getSecond() {
		return b;
	}

}
