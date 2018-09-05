public class Apk
{
	public static void main(String[] args)
	{
		Mazo m=new Mazo();
		System.out.println(m.toString());
		m.shuffle();
		System.out.println(m.toString());
	}
}