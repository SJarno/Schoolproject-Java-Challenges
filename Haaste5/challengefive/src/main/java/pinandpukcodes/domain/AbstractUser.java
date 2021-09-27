package pinandpukcodes.domain;

public abstract class AbstractUser {
    private UsercodeGenerator uGenerator;
    private int pinCode;
    private int pukCode;
    private String username;
    private int id;

    public AbstractUser(String username, UsercodeGenerator uGenerator) {
        this.uGenerator = uGenerator;
        this.id = -1;
        this.username = username;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        uGenerator.codeLenghtCheck(pinCode);
        this.pinCode = pinCode;
    }

    public int getPukCode() {
        return pukCode;
    }

    public void setPukCode(int pukCode) {
        uGenerator.codeLenghtCheck(pukCode);
        this.pukCode = pukCode;
    }
    
}
