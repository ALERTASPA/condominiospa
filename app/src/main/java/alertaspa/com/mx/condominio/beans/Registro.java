package alertaspa.com.mx.condominio.beans;

public class Registro {
  private String placas;
  private String marca;
  private String modelo;
  private String color;
  private String estatusVehiculo;
  private Integer interior;
  private String telefono;

  public Registro() {
    this("","","","","",0,"");
  }

  public Registro(String placas, String marca, String modelo, String color, String estatusVehiculo, Integer interior, String telefono) {
    this.placas = placas;
    this.marca = marca;
    this.modelo = modelo;
    this.color = color;
    this.estatusVehiculo = estatusVehiculo;
    this.interior = interior;
    this.telefono = telefono;
  }

  public String getPlacas() {
    return placas;
  }

  public void setPlacas(String placas) {
    this.placas = placas;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getEstatusVehiculo() {
    return estatusVehiculo;
  }

  public void setEstatusVehiculo(String estatusVehiculo) {
    this.estatusVehiculo = estatusVehiculo;
  }

  public String getInterior() {
    return interior.toString();
  }

  public void setInterior(String interior) {
    this.interior = Integer.parseInt(interior);
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
}
