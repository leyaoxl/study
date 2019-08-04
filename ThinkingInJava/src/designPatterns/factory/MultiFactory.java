package designPatterns.factory;

class SenderMultiFactory {
    public Sender createMailSender() {
        return new MailSender();
    }

    public Sender createSmsSender() {
        return new SmsSender();
    }
}

public class MultiFactory {
    public static void main(String[] args) {
        SenderMultiFactory senderMultiFactory = new SenderMultiFactory();
        Sender sender = senderMultiFactory.createMailSender();
        sender.send();
    }
}
