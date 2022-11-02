package com.pildorasInformaticas.Controller;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "direccion")
    private String direccion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private DetallesCliente detallesCliente;

    @OneToMany(mappedBy = "cliente",cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Pedido> pedidos;

    public Cliente(String nombre, String apellido, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public Cliente() {
    }

    public void agregarPedidos(Pedido elPedido) {
        if(pedidos == null){
            pedidos = new ArrayList<>();
        }
        pedidos.add(elPedido);
        elPedido.setCliente(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public DetallesCliente getDetallesCliente() {
        return detallesCliente;
    }

    public void setDetallesCliente(DetallesCliente detallesCliente) {
        this.detallesCliente = detallesCliente;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
