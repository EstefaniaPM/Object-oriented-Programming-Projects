import java.util.Scanner;
public class Apk
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);

		Id mat = new Id();
		mat.setTipo(Id.TIPO_ALUMNO);
		mat.setCampus(Id.CAMPUS_PUEBLA);

		Id mat2 = new Id();
		mat2.setTipo(Id.TIPO_PROFESOR);
		mat2.setCampus(Id.CAMPUS_PUEBLA);
		
		Profesor p1 = new Profesor();
		p1.setNombre("Luisa");
		p1.setApellidoPaterno("Martinez");
		p1.setApellidoMaterno("Lopez");
		p1.setAnioNac(1997);
		p1.setMesNac(6);
		p1.setDiaNac(13);
		p1.setGenero(true);
		p1.setRFC("MALL","WX8");
		mat2.getNext();
		p1.setNomina(mat2.clone());
		
		Grupo g = new Grupo("Orientada a objetos", 3);
		g.setProfesor(p1);
		
		while(g.tieneCupo()){
			Alumno a = new Alumno();
			try{
				System.out.println("Agregando nuevo alumno...");
				System.out.print("Nombre: ");
				a.setNombre(sc.nextLine());
				System.out.print("Apellido paterno: ");
				a.setApellidoPaterno(sc.nextLine());
				System.out.print("Apellido materno: ");
				a.setApellidoMaterno(sc.nextLine());
				System.out.print("Anio nacimiento: ");
				a.setAnioNac(sc.nextInt());
				System.out.print("Mes nacimiento: ");
				a.setMesNac(sc.nextInt());
				System.out.print("Dia nacimiento: ");
				a.setDiaNac(sc.nextInt());
				
				System.out.print("Genero [F/M]: ");
				String gen = "";
				while(!gen.equals("f") && !gen.equals("m") && !gen.equals("F") && !gen.equals("M")){
					if(!gen.equals(""))
						System.out.print("Genero [F/M]: ");
					gen = sc.nextLine();
				}
				
				a.setGenero(gen.equals("f") || gen.equals("F"));
				
				mat.getNext();
				a.setMatricula(mat.clone());
				
				g.addAlumno(a);
				System.out.println("");
				System.out.println("");
				System.out.println(g.toString());
			}catch(Exception e){
				//something
			}
		}
	}
}