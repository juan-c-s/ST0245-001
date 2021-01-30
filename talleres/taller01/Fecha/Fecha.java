public class Fecha{
    private int dia;
    private int mes;
    private int ayo;
    private int fechaEnNumero;


    public Fecha(int dia,int mes,int ayo){
        this.dia = dia;
        this.mes = mes;
        this.ayo = ayo;
        this.fechaEnNumero =  ayo + mes + dia;
        
    }

    public int getDia(){
        return this.dia;
    }

    public int getMes(){
        return this.mes;
    }

    public int getyño(){
        return this.ayo;
    }

    public int getfechaEnNumero(){
        return this.fechaEnNumero;
    }

    public String toString(){
        return String.valueOf(this.dia )+ '/' + String.valueOf(this.mes) + '/' + String.valueOf(this.ayo);
    }

    public boolean equals(Fecha fecha1){
       return fecha1.getfechaEnNumero() == this.getfechaEnNumero();
    }

    public boolean esMayor(Fecha f1){
        return this.getfechaEnNumero() > f1.getfechaEnNumero();
    }

    public boolean esMenor(Fecha f1){
        return this.getfechaEnNumero() < f1.getfechaEnNumero();
    }

    


}