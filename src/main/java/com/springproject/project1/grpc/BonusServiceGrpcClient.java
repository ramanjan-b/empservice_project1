
package com.springproject.project1.grpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import payroll.BonusDetails;
import payroll.EmployeeDetails;
import payroll.PayrollServiceGrpc;

@Service
public class BonusServiceGrpcClient {

    private static final Logger log =
            LoggerFactory.getLogger(BonusServiceGrpcClient.class);

    @GrpcClient("bonus-service")
    private PayrollServiceGrpc.PayrollServiceBlockingStub blockingStub;

    public BonusDetails calculatedBonus(String eid, String eName, String email) {

        EmployeeDetails request = EmployeeDetails.newBuilder()
                .setEName(eName)
                .setId(eid)
                .setMail(email)
                .build();

        BonusDetails response = blockingStub.calculateBonus(request);

        log.info("Received response via GRPC: {}", response);
        return response;
    }
}