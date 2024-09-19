
//Clase para generar los promedios

package Proyecto2;

public class GenerarPromedios {
     public static float calcularPromedio(float proyecto1, float proyecto2, float foroAcademico, float encuesta, float juego) {

        //Se le asigna el porcentaje a cada isntrumento.
        float porcentajeProyecto1 = 40;
        float porcentajeProyecto2 = 40;
        float porcentajeForoAcademico = 10;
        float porcentajeEncuesta = 5;
        float porcentajeJuego = 5;

        //Se calcula el promedio utilizando los porcentajes asignados.
        float promedio = (proyecto1 * porcentajeProyecto1 / 100)
                + (proyecto2 * porcentajeProyecto2 / 100)
                + (foroAcademico * porcentajeForoAcademico / 100)
                + (encuesta * porcentajeEncuesta / 100)
                + (juego * porcentajeJuego / 100);

        //Redondear al 0.5 más cercano.
        promedio = Math.round(promedio * 2) / 2.0f;

        //Retorna el promedio.
        return promedio;
    }
}
