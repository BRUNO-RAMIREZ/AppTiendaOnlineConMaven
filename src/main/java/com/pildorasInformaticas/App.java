package com.pildorasInformaticas;

import com.pildorasInformaticas.Controller.Cliente;
import com.pildorasInformaticas.Controller.DetallesCliente;
import com.pildorasInformaticas.Controller.Pedido;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

            SessionFactory configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Cliente.class)
                    .addAnnotatedClass(DetallesCliente.class)
                    .addAnnotatedClass(Pedido.class)
                    .buildSessionFactory();
            Session miSession = configuration.openSession();
            try {
//                Cliente cliente1 = new Cliente("Juan","Almicar","Sprinfield#12");
//                DetallesCliente detallesCliente1 = new DetallesCliente("www.pildorasInformaticas","5645","primer cliente");
//                cliente1.setDetallesCliente(detallesCliente1);
//                miSession.beginTransaction();
//                miSession.save(cliente1);
//                miSession.getTransaction().commit();
//                System.out.println("Cliente registrado");

//                miSession.beginTransaction();
//
//                //Obtener cliente
//                Cliente cliente = miSession.get(Cliente.class,1);
//
//                //Crear Pedidos
//                Pedido p1 = new Pedido(new GregorianCalendar(2022,7,5));
//                Pedido p2 = new Pedido(new GregorianCalendar(2022,8,1));
//                Pedido p3 = new Pedido(new GregorianCalendar(2022,9,7));
//
//                //Agrega pedidos
//                cliente.agregarPedidos(p1);
//                cliente.agregarPedidos(p2);
//                cliente.agregarPedidos(p3);
//
//                //Guardar los pedidos
//                miSession.save(p1);
//                miSession.save(p2);
//                miSession.save(p3);
//
//                miSession.getTransaction().commit();

                miSession.beginTransaction();
                Cliente cliente = miSession.get(Cliente.class,1);
                System.out.println(cliente.getPedidos());
                miSession.getTransaction().commit();
            }catch (Exception e){
                System.out.println("Cliente no registrado");
            }finally {
                miSession.close();
                configuration.close();
            }

    }
}
