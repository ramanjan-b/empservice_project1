package org.example.payrollservice.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import payroll.BonusDetails;
import payroll.EmployeeDetails;
import payroll.PayrollServiceGrpc.PayrollServiceImplBase;

@GrpcService
public class PayrollGrpcService extends PayrollServiceImplBase {
private static final Logger log= LoggerFactory.getLogger(PayrollGrpcService.class);


    @Override
    public void calculateBonus(EmployeeDetails request, StreamObserver<BonusDetails> responseObserver) {

        log.info("Bonus Calculated {}", request.toString());
        BonusDetails bonusDetails= BonusDetails.newBuilder().setAmount("10000")
                .setQuarter("Jan-Mar").build();
        responseObserver.onNext(bonusDetails);
        responseObserver.onCompleted();
    }

}
