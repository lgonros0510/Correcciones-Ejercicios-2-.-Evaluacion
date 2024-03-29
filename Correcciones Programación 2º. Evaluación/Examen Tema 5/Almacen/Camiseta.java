/** @author Lucía González Rosas */

/* En esta parte del programa, se creará la clase "Camiseta" donde se almacenará los atributos
 * "codigo", "descripcion", "precio", "stockS", "stockM" y "stockL".
 * 
 * Esta tarea se ha corregido al completo el 27 de marzo del 2024.
 */

package Almacen;

class Camiseta {

    private int codigo;
    private String descripcion;
    private int stockS;
    private int stockM;
    private int stockL;

    public Camiseta(int codigo, String descripcion, int stockS, int stockM, int stockL) {

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.stockS = stockS;
        this.stockM = stockM;
        this.stockL = stockL;

    }

    public int getCodigo() {

        return codigo;

    }

    public String getDescripcion() {
        
        return descripcion;

    }

    public int getStockS() {

        return stockS;

    }

    public int getStockM() {

        return stockM;

    }

    public int getStockL() {

        return stockL;

    }

    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;
        
    }

    public void setStockS(int stockS) {

        this.stockS = stockS;

    }

    public void setStockM(int stockM) {

        this.stockM = stockM;

    }

    public void setStockL(int stockL) {

        this.stockL = stockL;

    }

    @Override
    public String toString() {
        
        return String.format("%-10s %-20s %-10s %-10s %-10s %-10s", codigo, descripcion, stockS, stockM, stockL, (stockS + stockM + stockL));
    
    }
}