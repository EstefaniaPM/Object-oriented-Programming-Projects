public class TestProfesor
{
	public static void main(String[] args)
	{
		Profesor profesor1=new Profesor("Chip", "Canario", 20, false, false);
		Profesor profesor2=new Profesor();
		System.out.println("Profesor 1:");
		System.out.println(profesor1.getNombre());
		System.out.println(profesor1.getApellidio());
		System.out.println(profesor1.getEdad());
		System.out.println(profesor1.getCasado());
		System.out.println(profesor1.getEspecialista());
		System.out.println();
		System.out.println("Profesor 2:");
		System.out.println(profesor2.getNombre());
		System.out.println(profesor2.getApellidio());
		System.out.println(profesor2.getEdad());
		System.out.println(profesor2.getCasado());
		System.out.println(profesor2.getEspecialista());
	}
}