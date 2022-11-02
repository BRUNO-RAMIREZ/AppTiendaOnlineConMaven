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
                Cliente cliente1 = new Cliente("Juan","Almicar","Sprinfield#12");
                DetallesCliente detallesCliente1 = new DetallesCliente("www.pildorasInformaticas","5645","primer cliente");
                cliente1.setDetallesCliente(detallesCliente1);
                miSession.beginTransaction();
                miSession.save(cliente1);
                miSession.getTransaction().commit();
                System.out.println("Cliente registrado");
            }catch (Exception e){
                System.out.println("Cliente no registrado");
            }finally {
                miSession.close();
                configuration.close();
            }

    }
}
