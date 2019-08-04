package designPatterns.factory;

interface Sender {
    void send();
}

class MailSender implements Sender {
    public void send() {}
}

class SmsSender implements Sender {
    public void send() {}
}

class SenderFactory {
    public Sender create(String type) {
        if (type.equals("Mail")) {
            return new MailSender();
        } else if (type.equals("Sms")) {
            return new SmsSender();
        } else return null;
    }
}

public class SimpleFactory {
    public static void main(String[] args) {
        SenderFactory senderFactory = new SenderFactory();
        Sender sender = senderFactory.create("Sms");
        sender.send();
    }
}
