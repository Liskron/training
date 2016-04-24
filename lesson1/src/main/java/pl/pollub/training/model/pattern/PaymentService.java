package pl.pollub.training.model.pattern;

/**
 * Created by Wlad on 24.04.2016.
 */
public class PaymentService {
    private static PaymentService ourInstance = new PaymentService();

    public static PaymentService getInstance() {
        return ourInstance;
    }

    private PaymentService() {
    }
}
