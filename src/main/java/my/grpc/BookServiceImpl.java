package my.grpc;


import io.grpc.stub.StreamObserver;
import my.grpc.proto.BookServiceGrpc;
import my.grpc.proto.BookServiceOuterClass;

import java.util.UUID;

public class BookServiceImpl extends BookServiceGrpc.BookServiceImplBase {
    @Override
    public void saveBook(BookServiceOuterClass.BookRequest request, StreamObserver<BookServiceOuterClass.BookResponse> responseObserver) {
        System.out.println(request.getName());
        String id = UUID.randomUUID().toString();
        System.out.println(id);
        BookServiceOuterClass.BookResponse response = BookServiceOuterClass.BookResponse
                .newBuilder()
                .setExternalId(id)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
