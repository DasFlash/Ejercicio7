package ejercicio7;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class CrearXMLAlumnos {

    public static void main(String[] args) {
        // Scanner para leer los datos de los alumnos
        Scanner sc = new Scanner(System.in);

        // Array para almacenar los 5 alumnos
        Alumnos[] alumnos = new Alumnos[5];

        // Pedimos los datos de los alumnos al usuario
        for (int i = 0; i < 5; i++) {
            System.out.println("Introduce los datos del alumno " + (i + 1) + ":");

            System.out.print("NIA: ");
            int nia = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer de entrada

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Apellidos: ");
            String apellidos = sc.nextLine();

            System.out.print("Género (M/F): ");
            char genero = sc.nextLine().charAt(0);

            System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
            String fechaNacimiento = sc.nextLine();

            System.out.print("Ciclo: ");
            String ciclo = sc.nextLine();

            System.out.print("Curso: ");
            String curso = sc.nextLine();

            System.out.print("Grupo: ");
            String grupo = sc.nextLine();

            // Crear un objeto Alumno con los datos introducidos
            alumnos[i] = new Alumnos(nia, nombre, apellidos, genero, fechaNacimiento, ciclo, curso, grupo);
        }

        // Generamos el archivo XML
        generarXML(alumnos);
    }

    // Método para generar el archivo XML
    public static void generarXML(Alumnos[] alumnos) {
        try {
            // Crear un DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Crear el elemento raíz <Alumnos>
            Element rootElement = doc.createElement("Alumnos");
            doc.appendChild(rootElement);

            // Crear elementos XML para cada alumno
            for (Alumnos alumno : alumnos) {
                Element alumnoElement = doc.createElement("Alumno");
                rootElement.appendChild(alumnoElement);

                // Añadir el NIA
                Element nia = doc.createElement("NIA");
                nia.appendChild(doc.createTextNode(String.valueOf(alumno.getNia())));
                alumnoElement.appendChild(nia);

                // Añadir el Nombre
                Element nombre = doc.createElement("Nombre");
                nombre.appendChild(doc.createTextNode(alumno.getNombre()));
                alumnoElement.appendChild(nombre);

                // Añadir los Apellidos
                Element apellidos = doc.createElement("Apellidos");
                apellidos.appendChild(doc.createTextNode(alumno.getApellidos()));
                alumnoElement.appendChild(apellidos);

                // Añadir el Género
                Element genero = doc.createElement("Genero");
                genero.appendChild(doc.createTextNode(String.valueOf(alumno.getGenero())));
                alumnoElement.appendChild(genero);

                // Añadir la Fecha de Nacimiento
                Element fechaNacimiento = doc.createElement("FechaNacimiento");
                fechaNacimiento.appendChild(doc.createTextNode(alumno.getFechaNacimiento()));
                alumnoElement.appendChild(fechaNacimiento);

                // Añadir el Ciclo
                Element ciclo = doc.createElement("Ciclo");
                ciclo.appendChild(doc.createTextNode(alumno.getCiclo()));
                alumnoElement.appendChild(ciclo);

                // Añadir el Curso
                Element curso = doc.createElement("Curso");
                curso.appendChild(doc.createTextNode(alumno.getCurso()));
                alumnoElement.appendChild(curso);

                // Añadir el Grupo
                Element grupo = doc.createElement("Grupo");
                grupo.appendChild(doc.createTextNode(alumno.getGrupo()));
                alumnoElement.appendChild(grupo);
            }

            // Guardar el contenido del XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("alumnos.xml"));

            transformer.transform(source, result);

            System.out.println("Archivo XML generado correctamente como alumnos.xml");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
