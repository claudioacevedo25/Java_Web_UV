
package Modelo;


public class Recurso {
    private int id;
    private String titulo;
    private String detalle;
    private String formato;
    private byte[] archivo;
    private boolean pub_priv;
    private Materia materia;
    private boolean estado;

    public Recurso() {
        materia = new Materia();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public boolean isPub_priv() {
        return pub_priv;
    }

    public void setPub_priv(boolean pub_priv) {
        this.pub_priv = pub_priv;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Recurso{" + "id=" + id + ", titulo=" + titulo + ", detalle=" + detalle + ", formato=" + formato + ", archivo=" + archivo + ", pub_priv=" + pub_priv + ", materia=" + materia + ", estado=" + estado + '}';
    }
    
}
