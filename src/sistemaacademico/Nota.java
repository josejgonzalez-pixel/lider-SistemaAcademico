/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaacademico;

/**
 *
 * @author Camil
 */
public class Nota {
    
    private String codigoEstudiante;
    private String codigoAsignatura;
    private double valor;

    public Nota(String codigoEstudiante, String codigoAsignatura, double valor) {
        this.codigoEstudiante = codigoEstudiante;
        this.codigoAsignatura = codigoAsignatura;
        this.valor = valor;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public String getCodigoAsignatura() {
        return codigoAsignatura;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "codigoEstudiante='" + codigoEstudiante + '\'' +
                ", codigoAsignatura='" + codigoAsignatura + '\'' +
                ", valor=" + valor +
                '}';
    }
}
