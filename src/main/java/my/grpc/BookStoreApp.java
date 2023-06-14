package my.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class BookStoreApp {
    public static void main( String[] args ) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8081)
                .addService( new BookServiceImpl())
                .build();

        server.start();
        System.out.println("BookStore started");
        server.awaitTermination();
    }
}
