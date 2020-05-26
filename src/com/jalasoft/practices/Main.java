package com.jalasoft.practices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main compila");
        Pedido pedido1 = new Pedido("ped1","normal","Juan Perez","2020-05-05");
        Pedido pedido2 = new Pedido("ped2","programado","Maria Guaman","2020-05-05");
        Pedido pedido3 = new Pedido("ped3","normal","Juan Perez 1","2020-05-06");

        Detalle detalle1 = new Detalle("cod1","cocina",2,1000,10,1990,"ped1");
        Detalle detalle2 = new Detalle("cod2","lavadora",1,2500,0,2500,"ped1");
        Detalle detalle3 = new Detalle("cod3","plancha",5,300,50,1450,"ped1");
        Detalle detalle4 = new Detalle("cod4","mesa",2,700,30,1370,"ped2");
        Detalle detalle5 = new Detalle("cod5","muebles",1,3500,0,3500,"ped2");
        Detalle detalle6 = new Detalle("cod6","comoda",3,800,100,2300,"ped2");
        Detalle detalle7 = new Detalle("cod7","camisa",10,100,100,900,"ped3");
        Detalle detalle8 = new Detalle("cod8","polera",20,80,0,1600,"ped3");
        Detalle detalle9 = new Detalle("cod9","zapatos",8,400,200,3000,"ped3");

        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);

        List<Detalle> detalleList = new ArrayList<>();
        detalleList.add(detalle1);
        detalleList.add(detalle2);
        detalleList.add(detalle3);
        detalleList.add(detalle4);
        detalleList.add(detalle5);
        detalleList.add(detalle6);
        detalleList.add(detalle7);
        detalleList.add(detalle8);
        detalleList.add(detalle9);

        //1.- Select cliente from Pedido
        System.out.println("1.- Select cliente from Pedido");
        pedidos.stream().map(pedido -> pedido.getCliente()).forEach(value -> System.out.println(value));

        //2.-Select cliente from Pedido where tipoPedido = “normal”
        System.out.println("2.- Select cliente from Pedido where tipoPedido = “normal”");
        pedidos.stream().filter(pedido -> pedido.getTipoPedido() == "normal").map(pedido -> pedido.getCliente())
                .forEach(value -> System.out.println(value));

        //3.- Select codPedido from Pedido where fecha = “2020-05-05”
        System.out.println("3.- Select codPedido from Pedido where fecha = “2020-05-05”");
        pedidos.stream().filter(pedido -> pedido.getFecha() =="2020-05-05").map(pedido -> pedido.getCodPedido())
                .forEach(value -> System.out.println(value));

        //4.- Select producto from Detalle, Pedido where Pedido.codPedido = Detalle.codPedido and
        //Pedido.codPedido = “ped1”
        System.out.println("4. - Select producto from Detalle, Pedido where Pedido.codPedido = Detalle.codPedido and" +
                " Pedido.codPedido = “ped1”" );
        List<String> codPedido1 = pedidos.stream().filter(pedido -> pedido.getCodPedido() == "ped1")
                                  .map(x -> x.getCodPedido()).collect(Collectors.toList());

        detalleList.stream()
                .filter(x -> codPedido1.contains(x.getCodPedido()))
                .forEach(x -> System.out.println(x.getProducto()));

        //Select Detalle.producto from Detalle, Pedido where Pedido.codPedido = Detalle.codPedido
        //and Detalle.cantidad > 8
        System.out.println("5.- Select Detalle.producto from Detalle, Pedido where Pedido.codPedido = Detalle.codPedido\n" +
                "and Detalle.cantidad > 8");

        List<String> codPedidos = pedidos.stream().map(pedido -> pedido.getCodPedido()).collect(Collectors.toList());
        detalleList.stream()
                .filter(detalle -> codPedidos.contains(detalle.getCodPedido()))
                .filter(detalle -> detalle.getCantidad() > 8)
                .forEach(detalle -> System.out.println(detalle.getProducto()));

    }
}

