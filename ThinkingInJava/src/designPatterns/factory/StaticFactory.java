package designPatterns.factory;

class SenderStaticFactory {
    public static Sender createMailSender() {
        return new MailSender();
    }

    public static Sender createSmsSender() {
        return new SmsSender();
    }
}

public class StaticFactory {
    public static void main(String[] args) {
        Sender sender = SenderStaticFactory.createMailSender();
        sender.send();
    }
}
