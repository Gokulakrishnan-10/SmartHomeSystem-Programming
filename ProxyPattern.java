// Subject interface
interface PaymentGateway {
    void processPayment(double amount);
}

// RealPaymentGateway class (Actual payment processing)
class RealPaymentGateway implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount);
    }
}

// ProxyPaymentGateway class (Security proxy)
class ProxyPaymentGateway implements PaymentGateway {
    private RealPaymentGateway realPaymentGateway;
    private String username;
    private String password;

    public ProxyPaymentGateway(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void processPayment(double amount) {
        // Check credentials before allowing payment processing
        if (authenticate()) {
            if (realPaymentGateway == null) {
                realPaymentGateway = new RealPaymentGateway();
            }
            realPaymentGateway.processPayment(amount);
        } else {
            System.out.println("Access denied. Invalid credentials.");
        }
    }

    private boolean authenticate() {
        // Simplified authentication logic, check username and password
        return username.equals("admin") && password.equals("password123");
    }
}

public class ProxyPattern {
    public static void main(String[] args) {
        // Create a proxy with valid credentials
        PaymentGateway proxyPayment = new ProxyPaymentGateway("admin", "password123");
        proxyPayment.processPayment(100.0);  // Payment should be processed

        // Create a proxy with invalid credentials
        PaymentGateway invalidProxyPayment = new ProxyPaymentGateway("user", "pass");
        invalidProxyPayment.processPayment(50.0);  // Access denied, payment should not be processed
    }
}
